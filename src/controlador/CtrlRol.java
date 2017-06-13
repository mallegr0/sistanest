package controlador;

import utilidades.ApplicationException;
import entidades.Rol;
import data.DataRol;
import java.util.*;

public class CtrlRol {
	
	private Rol rol = new Rol();
	private DataRol dr = new DataRol();
	private ArrayList<Rol> listado = new ArrayList<>();
	private boolean rta = false; 
	
	public boolean altaRol(Rol r) throws ApplicationException{
		if(dr.altaRol(r) == true) rta = true;
		return rta;
	}
	
	public boolean bajaRol(Rol r) throws ApplicationException{
		if(dr.eliminaRol(r) == true) rta = true;
		return true;
	}

	public boolean modificaRol(Rol r){
		if (dr.modificaRol(r) == true) rta = true;
		return rta;
	}

	public Rol consultaRol(Rol r){
		rol = dr.consultaRol(r);
		return rol;
	}

	public ArrayList<Rol> listarRol(Rol r){
		return listado;
	}
	
	public int ultimoID(){
		return dr.ultimoID();
	}

}
