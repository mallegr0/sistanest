package controlador;

import java.sql.Date;
import java.util.*;
import entidades.Anestesia;
import entidades.AnestesiaProcedimiento;
import entidades.Procedimiento;
import data.DataAnestesia;
import data.DataAnestesiaProcedimiento;
import data.DataProcedimientos;
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
	
	
	//METODOS
	
	public boolean altaAnestesia(Anestesia a, ArrayList<Integer> ids) {
		int j = a.getIdAnestesia();
		for(int i = 0; i <= ids.size(); i++){
			ap.setIdAnestesia(j);
			ap.setIdProcedimiento(ids.get(i));
			if(dap.altaAnestesiaProcedimiento(ap) == true) oks.set(i, true); 
		}
		if(ids.size() == oks.size() && da.altaAnestesia(a) == true) rta = true;
		return rta;
	}
	
	public boolean bajaAnestesia(Anestesia a) {
		ap.setIdAnestesia(a.getIdAnestesia());
		if(da.bajaAnestesia(a) == true && dap.bajaAnestesiaProcedimiento(ap) == true) rta = true;
		return rta;
	}
	
	public boolean modificaAnestesia(Anestesia a, ArrayList<Integer> ids) {
		int j = a.getIdAnestesia();
		for(int i = 0; i <= ids.size(); i++){
			ap.setIdAnestesia(j);
			ap.setIdProcedimiento(ids.get(i));
			if(dap.modificaAnestesiaProcedimiento(ap) == true) oks.set(i, true);
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

	public Anestesia buscaPaciente(String paciente){
		anestesia = da.consultarPaciente(paciente);
		return anestesia;
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

}


