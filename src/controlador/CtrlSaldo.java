package controlador;

import utilidades.ApplicationException;
import entidades.Saldo;

import java.util.ArrayList;

import data.DataPagos;

public class CtrlSaldo {
	
	public CtrlSaldo() {}
	
	private boolean rta = false;
	private Saldo saldo = new Saldo();
	private DataPagos ds = new DataPagos();
	
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
	
	public ArrayList<Saldo> listarSaldo(Saldo s) {
		return ds.ListarPago(s);
	}

}
