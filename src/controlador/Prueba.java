package controlador;

import java.sql.Date;
import java.util.*;
import data.*;
import entidades.*;
import jdk.nashorn.internal.parser.DateParser;
import utilidades.ApplicationException;

public class Prueba {
	
	private static Saldo rol = new Saldo();
	private static Saldo k = new Saldo();
	private static CtrlSaldo dr = new CtrlSaldo();
	private static ArrayList<Saldo> listado = new ArrayList<>();
	private static java.sql.Date fecha = new Date(1);
	private static int id;
	
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
		
		rol.setIdAnestesista(1);
		rol.setAnio(2017);
		rol.setMes(1);
		rol.setMonto(1400);
		rol.setEstado("Debe");
		
		if(dr.altaSaldo(rol) == true){
			System.out.println("Alta ok");
		}else {System.out.println("Error en el alta");}
	}
	
	public static void baja(){
				
		rol.setIdAnestesista(1);
		rol.setAnio(2017);
		rol.setMes(1);
		
		if(dr.bajaSaldo(rol) == true){
			System.out.println("Baja ok");
		}else {System.out.println("Error");}
	}
	
	public static void modificar(){
		rol.setIdAnestesista(1);
		rol.setAnio(2017);
		rol.setMes(1);

		rol.setEstado("Pago");
		
		if(dr.modificaSaldo(rol)== true){
			System.out.println("cambio ok");
		}else {System.out.println("Error");}
	}
	
	public static void consulta(){
		
		rol.setIdAnestesista(1);
		rol.setAnio(2017);
		rol.setMes(1);

		
		k = dr.consultaSaldo(rol);
		if(k !=null){
			System.out.println(k.getIdAnestesista()+" -- "+k.getMonto()+" -- "+k.getEstado());
			
		}else {System.out.println("Error");}
		
	}

	public static void listar(){
		
		rol.setIdAnestesista(1);
		rol.setAnio(2017);
		listado = dr.listarSaldo(rol);
		if(listado != null){
		for(Saldo r: listado){
			System.out.println(r.getAnio()+" -- "+r.getMes()+" -- "+r.getMonto()+" -- "+r.getEstado());
		}}
		else{System.out.println("No hay elementos para mostrar");}
	}
}

	

