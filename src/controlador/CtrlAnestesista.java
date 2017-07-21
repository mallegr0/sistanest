package controlador;

import java.util.*;
import entidades.Anestesista;
import entidades.AnestesistaSanatorio;
import data.DataAnestesista;
import data.DataSanatoriosAnestesistas;
import utilidades.ApplicationException;

public class CtrlAnestesista {
	
	//CONSTRUCTOR
	public CtrlAnestesista(){}
	
	
	//VARIABLES
	private boolean rta = false; 
	private Anestesista anestesista = new Anestesista();
	private DataAnestesista da = new DataAnestesista();
	private ArrayList<Anestesista> listado = new ArrayList<>();
	private AnestesistaSanatorio anestesana = new AnestesistaSanatorio();
	private DataSanatoriosAnestesistas das = new DataSanatoriosAnestesistas();
	private ArrayList<AnestesistaSanatorio> listadoAS = new ArrayList<>();
	private ArrayList<Anestesista> l = new ArrayList<>();
	
	
	//METODOS
	
	public boolean altaAnestesista(Anestesista a, int idSanatorio) {
		if(da.consultaAnestesista(a) == null){
			int i = da.ultimoID()+1;
			System.out.println("Ultimo ID: "+i);
			anestesana.setIdAnestesista(i);
			anestesana.setIdSanatorio(idSanatorio);
			if(da.altaAnestesista(a) == true && das.altaSanatorioAnestesista(anestesana)) rta = true;
			}
		return rta;
	}
	
	public boolean bajaAnestesista(Anestesista a, int idSanatorio) {
		anestesana.setIdAnestesista(a.getIdAnestesista());
		anestesana.setIdSanatorio(idSanatorio);
		
		if(das.bajaSanatorioAnestesista(anestesana) == true){
			if(da.bajaAnestesista(a) == true) rta = true;
		}
		return rta;	
	}
	
	public boolean modificaAnestesista(Anestesista a) {
		if(da.modificaAnestesista(a) == true) rta = true;
		return rta;
	}
	
	public Anestesista consultaAnestesista(Anestesista a) {
		anestesista = da.consultaAnestesista(a);
		return anestesista;
	}
	
	public ArrayList<Anestesista> listarAnestesistas(int idSanatorio){
		listadoAS = das.listarSanatoriosAnestesistas();
		listado = da.listarAnestesista();
		if(listadoAS != null){
			for(AnestesistaSanatorio j: listadoAS){
				for(Anestesista k: listado){
					if(j.getIdAnestesista() == k.getIdAnestesista())
					{
						l.add(k);
					}
				}
			}
		}
		return l;
	}
	
}
