package controlador;

import entidades.UsuarioSanatorio;
import data.DataUsuarioSanatorio;
import java.util.*;
import utilidades.ApplicationException;

public class CtrlUsuarioSanatorio {
	//Variables
	UsuarioSanatorio us = new UsuarioSanatorio();
	DataUsuarioSanatorio dus = new DataUsuarioSanatorio();
	
	//Constructor
	
	public CtrlUsuarioSanatorio() {	}
	
	//metodos
	
	public boolean altaUsuarioSanatorio(UsuarioSanatorio u){
		if(dus.altaUsuarioSanatorio(u) == true) return true;
		return false;
	}
	
	public boolean bajaUsuarioSanatorio(String usr){
		if(dus.bajaUsuarioSanatorio(usr) == true) return true;
		return false;
	}
	
	public boolean modificaUsuarioSanatorio(UsuarioSanatorio u){
		if(dus.modificaUsuarioSanatorio(u) == true) return true;
		return false;
	}
	
	public UsuarioSanatorio consultaUsuarioSanatorio(String usr){
		us = dus.consultaUsuarioSanatorio(usr);
		if(us != null) return us;
		return null;
	}
	
	public ArrayList<UsuarioSanatorio> listarUsuarioSanatorio(){
		return dus.listarUsuarioSanatorio();
	}

}
