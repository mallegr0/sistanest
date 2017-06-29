package controlador;

import data.DataSanatorio;
import entidades.Sanatorio;

public class Prueba {
	public static void main(String[] args){
			Data d = new Data();
			Sanatorio s = new Sanatorio();
			boolean t;
			
			s.setRazonSocial("Los Alerces");
			
			if(d.alta(s) == false){
				System.out.println("no hizo nada");
			}
			else{
				//System.out.println(t);
				System.out.println("OK");
			}
	}
}
