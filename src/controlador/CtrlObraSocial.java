package controlador;

import java.util.*;
import entidades.ObraSocial;
import data.DataObrasSociales;
import utilidades.ApplicationException;

public class CtrlObraSocial {
	
	public CtrlObraSocial(){}
	
	ArrayList<ObraSocial> listado = new ArrayList<>();
	boolean rta = false;
	ObraSocial os = new ObraSocial();
	DataObrasSociales dos = new DataObrasSociales();
	
	public boolean altaObraSocial(ObraSocial os){
		if(dos.altaObraSocial(os) == true) rta = true;
		return rta;
	}
	
	public boolean bajaObraSocial(ObraSocial os){
		if(dos.eliminaObraSocial(os) == true) rta = true;
		return rta;
	}
	
	public boolean modificaObraSocial(ObraSocial os){
		if(dos.modificaObraSocial(os) == true) rta = true;
		return rta;
	}
	
	public ObraSocial consultaObraSocial(ObraSocial os){
		os = dos.consultaObraSocial(os);
		return os;
	}
	
	public ArrayList<ObraSocial> listarObraSocial(){
		listado = dos.listarObrasSociales();
		return listado;
	}

}
