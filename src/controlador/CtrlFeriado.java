package controlador;

import java.util.*;
import java.sql.Date;
import entidades.Feriado;
import data.DataFeriado;
import utilidades.ApplicationException;

public class CtrlFeriado {
	//Variables 
	private boolean rta = false;
	private Feriado feriado = new Feriado();
	private DataFeriado df = new DataFeriado();
	private ArrayList<Feriado> listado = new ArrayList<>();
	
	//Constructor
	public CtrlFeriado(){}
	
	//Metodos
	
	//Alta
	public boolean altaFeriado(Feriado f){
		if(df.consultaFeriado(f) == null){
			if(df.altaFeriado(f) == true) rta = true;
		}
		return rta;
	}
	
	//Baja
	public boolean bajaFeriado(Feriado f){
		if(df.bajaFeriado(f) == true) rta = true;
		return rta;
	}
		
	//Modifica
	public boolean modificaFeriado(Feriado f){
		if(df.modificaFeriado(f) == true) rta = true;
		return rta;
	}
	
	//Consulta
	public Feriado consultaFeriado(Feriado f){
		return df.consultaFeriado(f);
	}
	
	//Listar feriados
	public ArrayList<Feriado> listarFeriado(){
		return df.listarFeriado();
	}
	

}
