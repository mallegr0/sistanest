package controlador;

import java.util.*;
import entidades.Anestesista;
import entidades.AnestesistaSanatorio;
import entidades.Usuario;
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
	
	public boolean altaAnestesista(Anestesista a, ArrayList<Integer> sanatorios) {
		//Consulto si el anestesista esta de alta
		if(da.consultaAnestesista(a) == null){
			/*
			 * Recurpero el ultimo id y le sumo 1 para hacer la carga correspondiente  a la tabla
			 * Anestesista - Sanatorio
			 */
			int i = da.ultimoID()+1;
			//Valido que ambas cargas de realicen para devolver true, de caso contrario devuelvo false
			if(da.altaAnestesista(a) == true && cargaAnestesistaSanatorio(i, sanatorios)) rta = true;
			}
		return rta;
	}
	
	public boolean bajaAnestesista(Anestesista a, int idSanatorio) {
		//Seteo los valores para hacer la baja en la tabla Anestesistas - Sanatorios
		anestesana.setIdAnestesista(a.getIdAnestesista());
		anestesana.setIdSanatorio(idSanatorio);
		/*
		 * Primero hago la baja en la relacion para no tener problemas de integridad, y luego elimino al
		 * anestesistas.
		 */
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
		//En este apartado listo los anestesistas que estan en un sanatorio determinado
		//Devuelvo todos los datos de la tabla Sanatorios-Anestesistas
		listadoAS = das.listarSanatoriosAnestesistas();
		//Devuelvo todos los anestesistas
		listado = da.listarAnestesista();
		//Valido que ambos listados no sean nulos
		if(listadoAS != null && listado != null){
			//Recorro el listado de los sanatorios y anestesistas
			for(AnestesistaSanatorio j: listadoAS){
				//Valido que para cada item sea igual que el valor que ingrese
				if(j.getIdSanatorio() == idSanatorio){
					//recorro el listado de los anestesistas 
					for(Anestesista k: listado){
						//comparro que los id sean los mismos para agregarlos a un array que devuelvo.
						if(j.getIdAnestesista() == k.getIdAnestesista())
						{
							l.add(k);
						}
					}
				}	
			}
		}
		return l;
	}
	
	public Anestesista buscarAnestesista(String user){
		return da.buscarAnestesista(user);
	}
	
	private boolean cargaAnestesistaSanatorio(int i, ArrayList<Integer> sanatorios){
		//Instancio las variables que voy a usar
		int aux = 0; 
		boolean r = false;		
		anestesana.setIdAnestesista(i);
		//recorro el array para hacer las cargas.
		for(int a: sanatorios){
			//Para cada item del array lo instancio para luego hacer el alta.
			anestesana.setIdSanatorio(a);
			if(das.altaSanatorioAnestesista(anestesana)== true) aux++; //Si el metodo me devuelve true aumento el contador
		}
		//Valido que la cantidad de elementos en el array fueron ingresados correctamente, si es asi devuelvo true.
		if(sanatorios.size() == aux) r = true;
		
		return r;
	}
}
