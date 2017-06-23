package controlador;

import java.util.*;
import entidades.Anestesista;
import entidades.AnestesistaSanatorio;
import data.DataAnestesista;
import data.DataSanatoriosAnestesistas;
import utilidades.ApplicationException;

public class CtrlAnestesistas {
	
	//CONSTRUCTOR
	public CtrlAnestesistas(){}
	
	
	//VARIABLES
	private boolean rta = false; 
	private Anestesista anestesista = new Anestesista();
	private DataAnestesista da = new DataAnestesista();
	private ArrayList<Anestesista> listado = new ArrayList<>();
	private AnestesistaSanatorio anestesana = new AnestesistaSanatorio();
	private DataSanatoriosAnestesistas das = new DataSanatoriosAnestesistas();
	private ArrayList<AnestesistaSanatorio> listadoAS = new ArrayList<>();
	
	//METODOS
	
	public boolean altaAnestesista(Anestesista a, int idSanatorio) {
		if(da.consultaAnestesista(a) == null){
			anestesana.setIdAnestesista(a.getIdAnestesista());
			anestesana.setIdSanatorio(idSanatorio);
			if(da.altaAnestesista(a) == true && das.altaSanatorioAnestesista(anestesana)) rta = true;
			}
		return rta;
	}
	
	public boolean bajaAnestesista(Anestesista a, int idSanatorio) {
		anestesana.setIdAnestesista(a.getIdAnestesista());
		if(da.bajaAnestesista(a) == true && das.bajaSanatorioAnestesista(anestesana) == true) rta = true;
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
		for(int i = 0; i<= listadoAS.size(); i++){
			if(listadoAS.get(i).getIdSanatorio() == idSanatorio){
				anestesista.setIdAnestesista(listadoAS.get(i).getIdAnestesista());
				anestesista = da.consultaAnestesista(anestesista);
				listado.add(anestesista);
			}
		}
		return listado;
	}
	
}