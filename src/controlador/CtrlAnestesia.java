package controlador;

import java.sql.*;
import java.util.*;
import java.sql.Date;
import entidades.Anestesia;
import entidades.AnestesiaProcedimiento;
import entidades.Procedimiento;
import entidades.Feriado;
import data.DataAnestesia;
import data.DataAnestesiaProcedimiento;
import data.DataProcedimientos;
import data.DataFeriado;
import utilidades.ApplicationException;


public class CtrlAnestesia {
	
	//CONSTRUCTOR
	public CtrlAnestesia() {}
	
	//VARIABLES 
	private boolean rta = false;
	//Variables de Anestesia
	private ArrayList<Anestesia> listado = new ArrayList<>();
	private Anestesia anestesia = new Anestesia();
	private DataAnestesia da = new DataAnestesia();
	//Variables combinadas Anestesia - Procedimiento
	private ArrayList<AnestesiaProcedimiento> listadoAP = new ArrayList<>();
	private AnestesiaProcedimiento ap = new AnestesiaProcedimiento();
	private DataAnestesiaProcedimiento dap = new DataAnestesiaProcedimiento();
	//Variables Procedimientos
	private ArrayList<Procedimiento> listadoP = new ArrayList<>();
	private Procedimiento procedimiento = new Procedimiento();
	private DataProcedimientos dp = new DataProcedimientos();
	private ArrayList<Boolean> oks = new ArrayList<>();
	//Variables Feriados
	private Feriado feriado = new Feriado();
	private DataFeriado df = new DataFeriado();
	private ArrayList<Feriado> listadoF = new ArrayList<>();
	
	
	
	//METODOS
	
	public boolean altaAnestesia(Anestesia a, ArrayList<Procedimiento> procedimientos) {
		int k = 0;
		a.setIdAnestesia(da.ultimoID() +1); //Devuelvo el ultimo ID y le sumo 1 para asignar a la variable.
		int j = a.getIdAnestesia();
		if(da.altaAnestesia(a) == true){
			for(Procedimiento i: procedimientos){ //Para cada Procedimiento que cargo
				ap.setIdAnestesia(j);
				ap.setIdProcedimiento(i.getIdProcedimiento());
				if(dap.altaAnestesiaProcedimiento(ap) == true) {
					oks.add(k, true);;
					k++;
				}
			}
			if(procedimientos.size() == oks.size()) rta = true; //Valido que no haya habido problemas en la carga
		}
		return rta;
	}
	
	public boolean bajaAnestesia(Anestesia a) {
		ap.setIdAnestesia(a.getIdAnestesia());
		if(dap.bajaAnestesiaProcedimiento(ap) == true){//Doy de baja la anestesia en la tabla de Anestesias/Procedimientos
			if(da.bajaAnestesia(a) == true) rta = true;
		}	
		return rta;
	}
	
	public boolean modificaAnestesia(Anestesia a, ArrayList<Integer> ids) {
		int j = a.getIdAnestesia();
		for(int i = 0; i <= ids.size()-1; i++){
			System.out.println(i);
			ap.setIdAnestesia(j);
			ap.setIdProcedimiento(ids.get(i));
			if(dap.modificaAnestesiaProcedimiento(ap) == true) oks.add(true);
		}
		if(ids.size() == oks.size() && da.modificaAnestesia(a) == true) rta = true;
		return rta;
	}
	
	public Anestesia consultaAnestesia(Anestesia a){
		anestesia = da.consultaAnestesia(a);
		return anestesia;
	}
	
	public ArrayList<Anestesia> listarAnestesia(){
		listado = da.listarAnestesias();
		return listado;
	}

	public ArrayList<Anestesia> listarPorFecha(Date fecIni, Date fecFin){
		listado = da.listarPorFecha(fecIni, fecFin);
		return listado;
	}
	
	public ArrayList<Anestesia> listarPorAnestesista(int id, Date fecIni, Date fecFin){
		listado = da.listarPorAnestesista(id, fecIni, fecFin);
		return listado;
	}
	
	public ArrayList<Anestesia> listarPorOS(int id, Date fecIni, Date fecFin){
		listado = da.listarPorOS(id, fecIni, fecFin);
		return listado;
	}

	public ArrayList<Anestesia> buscaPaciente(String paciente){
		listado = da.listarPaciente(paciente);
		return listado;
	}
	
	public ArrayList<Procedimiento> listarProcedimientos(Anestesia a){
		listadoAP = dap.listarProcedimientosAnestesias();
		for (AnestesiaProcedimiento e: listadoAP){
			if(a.getIdAnestesia() == e.getIdAnestesia()){
				procedimiento.setIdProcedimiento(e.getIdProcedimiento());
				procedimiento = dp.consultaProcedimiento(procedimiento);
				listadoP.add(procedimiento);
			}
		}
		return listadoP;
	}
	
	
	//Valida si la fecha corresponde a un feriado
	public boolean validaFeriado(Timestamp fecha){
		//Variables
		Feriado k = new Feriado();
		Date m = new Date(fecha.getTime());
		
		//Instancio la variable con la fecha 
		feriado.setFecFeriado(m);
		//Realizo la consulta con la fecha que quiero
		k = df.consultaFeriado(feriado);
		
		if(k != null){
				return true;
		}
		return false;
	}
	
	//Valida si la hora corresponde a nocturno
	public boolean validaNocturno(Timestamp fecha){
		//Variable Calendario para manejar la fecha que paso como parametro
		Calendar j = Calendar.getInstance();
		//Seteo la fecha en la variable
		j.setTime(fecha);
		if(j.get(Calendar.HOUR_OF_DAY) < 7){
			return true;
		}
		else if(j.get(Calendar.HOUR_OF_DAY) > 21){
			return true;
		}
		return false;
	}
		
	//Valida si la fecha corresponde a fin de semana
	public boolean validaFDS(Timestamp fecha){
		//Variable Calendario para manejar las fechas.
		Calendar j = Calendar.getInstance();
		//Seteo la fecha que paso como parametro
		j.setTime(fecha);
		int dia = j.get(Calendar.DAY_OF_WEEK);
		int hora = j.get(Calendar.HOUR_OF_DAY);
		//Pregunto si el dia que paso como parametro es sabado o domingo
		if(Calendar.SATURDAY == dia || 13 <= hora || Calendar.MONDAY == dia || hora <= 7 || Calendar.SUNDAY == dia ){
			return true;
		}
		else{ return false;}
		

	}
		
	
	

}


