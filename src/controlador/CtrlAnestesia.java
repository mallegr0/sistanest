package controlador;

import java.util.*;
import entidades.Anestesia;
import entidades.AnestesiaProcedimiento;
import data.DataAnestesia;
import data.DataAnestesiaProcedimiento;
import utilidades.ApplicationException;


public class CtrlAnestesia {
	
	//CONSTRUCTOR
	public CtrlAnestesia() {}
	
	//VARIABLES 
	private boolean rta = false;
	//Variables de Anestesia
	private ArrayList<Anestesia> listado = new ArrayList<>();
	private Anestesia anestesia = new Anestesia();
	private DataAnestesia da = new DataAnestesia();
	//Variables combinadas Anestesia - Procedimiento
	private ArrayList<AnestesiaProcedimiento> listadoAP = new ArrayList<>();
	private AnestesiaProcedimiento ap = new AnestesiaProcedimiento();
	private DataAnestesiaProcedimiento dap = new DataAnestesiaProcedimiento();
	private ArrayList<Boolean> oks = new ArrayList<>();
	//METODOS
	
	public boolean altaAnestesia(Anestesia a, ArrayList<Integer> ids) {
		int j = a.getIdAnestesia();
		for(int i = 0; i <= ids.size(); i++){
			ap.setIdAnestesia(j);
			ap.setIdProcedimiento(ids.get(i));
			if(dap.altaAnestesiaProcedimiento(ap) == true) oks.set(i, true); 
		}
		if(ids.size() == oks.size() && da.altaAnestesia(a) == true) rta = true;
		return rta;
	}
	
	public boolean bajaAnestesia(Anestesia a) {
		ap.setIdAnestesia(a.getIdAnestesia());
		if(da.bajaAnestesia(a) == true && dap.bajaAnestesiaProcedimiento(ap) == true) rta = true;
		return rta;
	}
	
	public boolean modificaAnestesia(Anestesia a, ArrayList<Integer> ids) {
		int j = a.getIdAnestesia();
		for(int i = 0; i <= ids.size(); i++){
			ap.setIdAnestesia(j);
			ap.setIdProcedimiento(ids.get(i));
			if(dap.modificaAnestesiaProcedimiento(ap) == true) oks.set(i, true);
		}
		if(ids.size() == oks.size() && da.modificaAnestesia(a) == true) rta = true;
		return rta;
	}
	
	public Anestesia consultaAnestesia(){
		return anestesia;
	}
}
