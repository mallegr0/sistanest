package controlador;

import java.sql.*;
import java.util.*;
import java.sql.Date;

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
	
	public boolean altaAnestesia(Anestesia a, ArrayList<Procedimiento> procedimientos) {
		int k = 0;
		a.setIdAnestesia(da.ultimoID() +1);
		int j = a.getIdAnestesia();
		if(da.altaAnestesia(a) == true){
			for(Procedimiento i: procedimientos){
				ap.setIdAnestesia(j);
				ap.setIdProcedimiento(i.getIdProcedimiento());
				if(dap.altaAnestesiaProcedimiento(ap) == true) {
					oks.add(k, true);;
					k++;
				}
			}
			if(procedimientos.size() == oks.size()) rta = true;
		}
		return rta;
	}
	
	public boolean bajaAnestesia(Anestesia a) {
		ap.setIdAnestesia(a.getIdAnestesia());
		if(dap.bajaAnestesiaProcedimiento(ap) == true){
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

}


