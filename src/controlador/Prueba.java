package controlador;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Date;
import data.DataFeriado;
import entidades.*;
import utilidades.ApplicationException;

public class Prueba {
	
	private static CtrlAnestesia ca = new CtrlAnestesia();
	private static Anestesia a = new Anestesia();
	private static Calendar c = Calendar.getInstance();
	private static java.util.Date fecha = new java.util.Date();
	private static Timestamp ts = new Timestamp(fecha.getTime());
	
	
	public static void main(String[] args){
/*
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
		
		f.setFecFeriado(parsearFecha("2018/01/01")); 
		
		if(cf.altaFeriado(f) == true){
			System.out.println("Alta ok");
		}else {System.out.println("Error en el alta");}
			
	}
	
	public static void baja(){

		f.setIdFeriado(2);
		
		if(cf.bajaFeriado(f) == true){
			System.out.println("Baja ok");
		}
		else {System.out.println("Error");}
		
	}
	
	public static void modificar(){
		
		f.setIdFeriado(1);
		f.setFecFeriado(parsearFecha("2018/07/09"));
		
		if(cf.modificaFeriado(f) == true){
			System.out.println("cambio ok");
		}else {System.out.println("Error");}
		
	}
	
	public static void consulta(){
		
		f.setIdFeriado(2);;
		
		f2 = cf.consultaFeriado(f);
		if(f2 != null){
			System.out.println(f2.getIdFeriado()+" "+f2.getFecFeriado());
			
		}else {System.out.println("Error");}
		
	}

	public static void listar(){
		
		listado = cf.listarFeriado();
		System.out.println("Feriados");
		if(!listado.isEmpty()){
			for(Feriado f: listado){
			System.out.println(f.getIdFeriado()+" -- "+f.getFecFeriado());
			}
		}
		else{System.out.println("No hay elementos para mostrar");}
	}
	
	private static java.util.Date parsearFecha(String fecha){
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date f = null;
		
		try{
			f = formato.parse(fecha);
		}
		catch(ParseException e){System.out.println(e);
		}
		return f;
		*/
		System.out.println("Se ingresa la fecha de prestacion y se valida automaticamente");
		System.out.println(" ");
		if(ca.validaFDS(ts) == true){
			System.out.println("Es finde semana :D");
		}
		else
		{
			System.out.println("No es finde :(");
		}
		System.out.println(" ");
		if(ca.validaNocturno(ts) == true){
			System.out.println("Es Nocturno :D");
		}
		else
		{
			System.out.println("No es nocturno :(");
		}
		System.out.println(" ");
		if(ca.validaFeriado(ts) == true){
			System.out.println("Es Feriado :D");
		}
		else
		{
			System.out.println("No es Feriado :(");
		}
	}
	
	
	
}


	

