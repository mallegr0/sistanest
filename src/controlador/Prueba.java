package controlador;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import entidades.*;
import utilidades.ApplicationException;

public class Prueba {
	
	private static Anestesia rol = new Anestesia();
	private static Anestesia k = new Anestesia();
	private static CtrlAnestesia dr = new CtrlAnestesia();
	private static ArrayList<Anestesia> listado = new ArrayList<>();
	private static Procedimiento p = new Procedimiento();
	private static ArrayList<Procedimiento> procedimientos = new ArrayList<>();
	private static ArrayList<Integer> ids = new ArrayList<>();
	
	String fec;
	

	private static Date fecha = new Date();
	private static Date fecIni = new Date();
	private static Date fecFin = new Date();
	
	private static Timestamp ts = new Timestamp(fecha.getTime());

	
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
		rol.setFecPrestacion(ts);
		rol.setFecAra(parsearFecha("2017/07/20"));
		rol.setFecRendicion(parsearFecha("2017/08/01"));
		rol.setFecCarga(ts);
		rol.setAfiliado("Matias");
		rol.setNroAfiliado(202);
		rol.setNocturno(1);
		rol.setFeriado(1);
		rol.setFds(1);
		rol.setNroTalon(2030);
		rol.setNroVias(3);
		rol.setEdad(33);
		rol.setUser("Admin");
		rol.setIdMedico(2);
		rol.setIdAnestesista(15);
		rol.setIdSanatorio(1);
		rol.setIdOS(1);
		rol.setIdTpoAnestesia(1);
		p.setIdProcedimiento(0001);
		
		procedimientos.add(p);
		
		if(dr.altaAnestesia(rol, procedimientos) == true){
			System.out.println("Alta ok");
		}else {System.out.println("Error en el alta");}
			
	}
	
	public static void baja(){

		rol.setIdAnestesia(7);
		
		if(dr.bajaAnestesia(rol) == true){
			System.out.println("Baja ok");
		}
		else {System.out.println("Error");}
		
	}
	
	public static void modificar(){
		
		Anestesia r = new Anestesia();
		r.setIdAnestesia(8);
		rol = dr.consultaAnestesia(r);
		
		rol.setAfiliado("prueba1");
		ids.add(2);
		
		if(dr.modificaAnestesia(rol, ids)== true){
			System.out.println("cambio ok");
		}else {System.out.println("Error");}
		
	}
	
	public static void consulta(){
		
		rol.setIdAnestesia(5);
		
		k = dr.consultaAnestesia(rol);
		if(k !=null){
			System.out.println(k.getAfiliado()+" "+k.getNroAfiliado());
			
		}else {System.out.println("Error");}
		
	}

	public static void listar(){
		
		
		String paciente = "Matias";
		listado = dr.buscaPaciente(paciente);
		System.out.println("Nombre Paciente: "+paciente);
		if(!listado.isEmpty()){
			for(Anestesia rol: listado){
			System.out.println(rol.getIdAnestesia()+" -- "+rol.getFecPrestacion());
			}
		}
		else{System.out.println("No hay elementos para mostrar");}
	}
	
	private static Date parsearFecha(String fecha){
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
		Date f = null;
		
		try{
			f = formato.parse(fecha);
		}
		catch(ParseException e){System.out.println(e);
		}
		return f;
	}
}


	

