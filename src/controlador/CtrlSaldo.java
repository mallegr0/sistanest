package controlador;

import utilidades.ApplicationException;
import entidades.Saldo;
import data.DataPagos;

public class CtrlSaldo {
	
	public CtrlSaldo() {}
	
	boolean rta = false;
	Saldo saldo = new Saldo();
	DataPagos ds = new DataPagos();
	
	public boolean altaSaldo(Saldo s) {
		if(ds.altaPago(s) == true) rta = true;
		return rta;
	}
	
	public boolean bajaSaldo(Saldo s) {
		if(ds.bajaPago(s) == true) rta = true;
		return rta;
	}
	
	public boolean modificaSaldo(Saldo s) {
		if(ds.modificarPago(s) == true) rta = true;
		return rta;
	}
	
	public Saldo consultaSaldo(Saldo s) {
		saldo = ds.consultaPago(s);
		return saldo;
	}


}
