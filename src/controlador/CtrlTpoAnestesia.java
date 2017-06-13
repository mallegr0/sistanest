package controlador;

import java.util.*;
import entidades.TpoAnestesia;
import data.DataTpoAnestesia;
import utilidades.ApplicationException;

public class CtrlTpoAnestesia {
	
	public CtrlTpoAnestesia() {}
	
	boolean rta = false;
	TpoAnestesia proceso = new TpoAnestesia();
	DataTpoAnestesia dta = new DataTpoAnestesia();
	ArrayList<TpoAnestesia> listado = new ArrayList<>();
	
	public boolean altaTpoAnestesia(TpoAnestesia ta) {
		if(dta.altaTpoAnestesia(ta) == true) rta = true;
		return rta;
	}

	public boolean bajaTpoAnestesia(TpoAnestesia ta) {
		if(dta.bajaTpoAnestesia(ta) == true) rta = true;
		return rta;
	}

	public boolean modificaTpoAnestesia(TpoAnestesia ta) {
		if(dta.modificaTpoAnestesia(ta) == true) rta = true;
		return rta;
	}

	public TpoAnestesia consultaTpoAnestesia(TpoAnestesia ta) {
		proceso = dta.consultaTpoAnestesia(ta);
		return proceso;
	}

	public ArrayList<TpoAnestesia> listarTpoAnestesia() {
		listado = dta.listarTpoAnestesia();
		return listado;
	}

}





