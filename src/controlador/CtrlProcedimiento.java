package controlador;

import java.util.*;
import entidades.Procedimiento;
import data.DataProcedimientos;
import utilidades.ApplicationException;

public class CtrlProcedimiento {
	
	public CtrlProcedimiento(){}
	
	private boolean rta = false;
	private Procedimiento proceso = new Procedimiento();
	private DataProcedimientos dp = new DataProcedimientos();
	private ArrayList<Procedimiento> listado = new ArrayList<>();
	
	public boolean altaProcedimiento(Procedimiento p) {
		if(dp.altaProcedimiento(p) == true) rta = true;
		return rta;
	}

	public boolean bajaProcedimiento(Procedimiento p) {
		if(dp.bajaProcedimiento(p) == true) rta = true;
		return rta;
	}

	public boolean modificaProcedimiento(Procedimiento p) {
		if(dp.modificaProcedimiento(p) == true) rta = true;
		return rta;
	}

	public Procedimiento consultaProcedimiento(Procedimiento p) {
		proceso = dp.consultaProcedimiento(p);
		return proceso;
	}

	public ArrayList<Procedimiento> listarProcedimiento() {
		listado = dp.listarProcedimientos();
		return listado;
	}

}
