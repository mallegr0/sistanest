package controlador;

import java.util.*;
import entidades.Usuario;
import entidades.UsuarioSanatorio;
import data.DataUsuario;
import data.DataUsuarioSanatorio;
import utilidades.ApplicationException;

public class CtrlUsuario {
	
	public CtrlUsuario() {}
	
	private ArrayList<Usuario> listado = new ArrayList<>();
	private DataUsuario du = new DataUsuario();
	private Usuario usuario = new Usuario();
	private DataUsuarioSanatorio dus = new DataUsuarioSanatorio();
	private UsuarioSanatorio usuarioSanatorio = new UsuarioSanatorio();
	private boolean rta = false;
	
	public boolean altaUsuario(Usuario u, ArrayList<Integer> sanatorios) throws ApplicationException {
		
		if(du.consultaUsuario(u) == null ){
			if(du.altaUsuario(u) == true && cargaUsuarioSanatorio(u.getUser(), sanatorios) == true) rta = true;
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
	
	public boolean actualizaUsuario(Usuario u){
		if(du.actualizaUsuario(u) == true) rta = true;
		return rta;
	}
	
	public boolean cambiaPassword(Usuario u){
		if(du.cambiaPassword(u) == true) rta = true;
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
	
	public boolean validaUsuario(String usr, String psw){
		usuario.setUser(usr);
		usuario = du.consultaUsuario(usuario);
		if(usuario != null){
			if(usuario.getUser().equals(usr) && usuario.getPassword().equals(psw))	return true;
		}
		return false;	
	}
	
	private boolean cargaUsuarioSanatorio(String usuario, ArrayList<Integer> sanatorios){
		int aux = 0;
		usuarioSanatorio.setUsuario(usuario);
		for(int s: sanatorios){
			usuarioSanatorio.setSanatorio(s);
			if(dus.altaUsuarioSanatorio(usuarioSanatorio)==true) aux++;
		}
		if(aux == sanatorios.size()) return true;
		return false;
	}
	
}
