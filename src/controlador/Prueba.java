package controlador;

import java.sql.Timestamp;
import java.util.*;

import data.DataSanatoriosAnestesistas;
import entidades.*;
import utilidades.ApplicationException;

public class Prueba {
	
	private static Anestesista rol = new Anestesista();
	private static Anestesista k = new Anestesista();
	private static CtrlAnestesistas dr = new CtrlAnestesistas();
	private static ArrayList<Anestesista> listado = new ArrayList<>();
	
	
	private static Date fecha = new Date();
	private static Timestamp ts = new Timestamp(fecha.getTime());
	private static Calendar c = Calendar.getInstance();
	
	public static void main(String[] args){

		Scanner s = new Scanner(System.in);
		int op;
		
		do{
			s.nextLine();
			System.out.println("1- alta");
			System.out.println("2- baja");
			System.out.println("3- modificar");
			System.out.println("4- consultar");
			System.out.println("5- listar");
			System.out.println("6- Salir");
			op = s.nextInt();
			
			switch (op) {
			case 1:
				alta();
				break;
			case 2:
				baja();
				break;
			case 3:
				modificar();
				break;
			case 4:
				consulta();
				break;
			case 5:
				listar();
				break;
			default:
				break;
			}
			s.nextLine();
		}while(op != 6);
		s.close();
	}

	public static void alta(){
		
		rol.setNombreAnestesista("prueba1");
		rol.setApellidoAnestesista("prueba2");
		rol.setMatricula(1);
		rol.setGrupo(2);
		
		
		if(dr.altaAnestesista(rol, 1) == true){
			System.out.println("Alta ok");
		}else {System.out.println("Error en el alta");}
			
	}
	
	public static void baja(){
				/*
		rol.setIdAnestesista(1);
		
		if(dr.bajaAnestesista(rol, 1) == true){
			System.out.println("Baja ok");
		}else {System.out.println("Error");}*/
		
	}
	
	public static void modificar(){/*
		rol.setIdAnestesista(1);
		rol.setNombreAnestesista("prueba1");
		rol.setApellidoAnestesista("prueba2");

		
		if(dr.modificaAnestesista(rol)== true){
			System.out.println("cambio ok");
		}else {System.out.println("Error");}*/
		
	}
	
	public static void consulta(){
		/*
		rol.setIdAnestesista(1);
		
		k = dr.consultaAnestesista(rol);
		if(k !=null){
			System.out.println(k.getNombreAnestesista()+" "+k.getApellidoAnestesista());
			
		}else {System.out.println("Error");}*/
		
	}

	public static void listar(){
		/*
		listado = dr.listarAnestesistas(1);
		if(listado != null){
		for(Anestesista r: listado){
			System.out.println("Sanatorio: 1");
			System.out.println("");
			System.out.println("------ ** -----");
			System.out.println(r.getNombreAnestesista()+" -- "+r.getApellidoAnestesista());
		}}
		else{System.out.println("No hay elementos para mostrar");}*/
	}
}


	

