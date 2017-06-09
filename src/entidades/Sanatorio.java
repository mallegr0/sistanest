package entidades;

import java.io.Serializable;

public class Sanatorio implements Serializable{
	
	//Variables
	
	private static final long serialVersionUID = 1L;
	private int idSanatorio;
	private String razonSocial;
	
	//Constructores
	
	public Sanatorio(){}
	
	public Sanatorio(int idSanatorio, String razonSocial){
		this.idSanatorio = idSanatorio;
		this.razonSocial = razonSocial;
	}

	public int getIdSanatorio() {
		return idSanatorio;
	}

	public void setIdSanatorio(int idSanatorio) {
		this.idSanatorio = idSanatorio;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	
}
