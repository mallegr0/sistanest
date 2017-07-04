package controlador;

import java.util.ArrayList;
import data.*;
import entidades.*;
import utilidades.ApplicationException;

public class Prueba {
	
	public static void main(String[] args){
		
		Usuario user = new Usuario();
		Usuario k = new Usuario();
		CtrlUsuario dos = new CtrlUsuario();
		ArrayList<Usuario> listado = new ArrayList<>();
		
		user.setUser("user");
		//user.setPassword("user");
		//user.setNombreUsuario("Matias");
		//user.setApellidoUsuario("Allegranza");
		//user.setMailUsuario("mallegr0@rosario.gov.ar");
		//user.setIdRol(2);

		
		
		if(dos.bajaUsuario(user) != false){
			System.out.println("OK");
		}
		else{System.out.println("error");};
		
	}
}

	

