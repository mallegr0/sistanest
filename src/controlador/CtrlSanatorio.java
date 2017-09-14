package controlador;

import utilidades.ApplicationException;
import entidades.Sanatorio;
import data.DataSanatorio;
import java.util.*;

public class CtrlSanatorio {
	
	public CtrlSanatorio(){};
	
	private boolean rta = false;
	private Sanatorio san = null;
	private ArrayList<Sanatorio> listado = new ArrayList<>();
	private DataSanatorio ds = new DataSanatorio();
	
	public boolean altaSanatorio(Sanatorio s){
		if (ds.altaSanatorio(s) == true) rta = true;
		return rta;
	}
	
	public boolean bajaSanatorio(Sanatorio s){
		if (ds.bajaSanatorio(s) == true) rta = true;
		return rta;
	}
	
	public boolean modificaSanatorio(Sanatorio s){
		if (ds.modificaSanatorio(s) == true) rta = true;
		return rta;
	}
	
	
	public Sanatorio consultaSanatorio(Sanatorio s){
		return ds.consultaSanatorio(s);
	}
	
	public  ArrayList<Sanatorio>listarSanatorio(){
		return ds.listarSanatorios();
	}
	
	public Sanatorio buscaSanatorio(String nombre){
		return ds.buscaSanatorio(nombre);
	}
}
