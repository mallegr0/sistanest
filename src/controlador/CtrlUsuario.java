package controlador;

import java.sql.Array;
import java.util.*;
import entidades.Usuario;
import data.DataUsuario;
import utilidades.ApplicationException;

public class CtrlUsuario {
	
	public CtrlUsuario() {}
	
	private ArrayList<Usuario> listado = new ArrayList<>();
	private DataUsuario du = new DataUsuario();
	private Usuario usuario = new Usuario();
	private boolean rta = false;
	
	public boolean altaUsuario(Usuario u) {
		if( du.consultaUsuario(u) != null){
				if(du.altaUsuario(u) == true) rta = true;
		}
		return rta;
	}
	
	public boolean bajaUsuario(Usuario u) {
		if(du.borraUsuario(u) == true) rta = true;
		return rta;
	}
	
	public boolean modificaUsuario(Usuario u) {
		if(du.modificaUsuario(u) == true) rta = true;
		return rta;
	}
	
	public Usuario consultaUsuario(Usuario u) {
		usuario = du.consultaUsuario(u);
		return usuario;
	}
	
	public ArrayList<Usuario> listarUsuarios(){
		listado = du.listarUsuario();
		return listado;
	}
	
	public ArrayList<Usuario> listarPendientes(){
		listado = du.listarPendientes();
		return listado;
	}
}
