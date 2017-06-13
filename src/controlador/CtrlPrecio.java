package controlador;

import utilidades.ApplicationException;
import data.DataPrecio;
import entidades.Precio;

public class CtrlPrecio {
	public CtrlPrecio(){}
	
	boolean rta = false;
	Precio precio = new Precio();
	DataPrecio dp = new DataPrecio();
	
	public boolean altaPrecio(Precio p) {
		if(dp.altaPrecio(p) == true) rta = true;
		return rta;
	}

	public boolean bajaPrecio(Precio p) {
		if(dp.bajaPrecio(p) == true) rta = true;
		return rta;
	}

	public boolean modificaPrecio(Precio p) {
		if(dp.modificaPrecio(p) == true) rta = true;
		return rta;
	}

	public Precio consultaPrecio(Precio p) {
		precio = dp.consultaPrecio(p);
		return precio;
	}
}
