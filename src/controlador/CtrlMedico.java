package controlador;

import java.util.*;
import entidades.Medico;
import data.DataMedico;
import utilidades.ApplicationException;


public class CtrlMedico {
	
	public CtrlMedico(){}
	
	private boolean rta = false; 
	private Medico medico = new Medico();
	private ArrayList<Medico> listado = new ArrayList<>();
	private DataMedico dm = new DataMedico();
	
	public boolean altaMedico(Medico m) {
		if(dm.consultaMedico(m) == null){
			if(dm.altaMedico(m) == true) rta = true;
		}
		return rta;
	}
	
	public boolean bajaMedico(Medico m) {
		if(dm.bajaMedico(m) == true) rta = true;
		return rta;
	}
	
	public boolean modificaMedico(Medico m) {
		if(dm.modificaMedico(m) == true) rta = true;
		return rta;
	}
	
	public Medico consultaMedico(Medico m){
		medico = dm.consultaMedico(m);
		return medico;
	}
	
	public ArrayList<Medico> listarMedico() {
		listado = dm.listarMedicos();
		return listado;
	}

}
