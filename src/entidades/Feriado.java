package entidades;

import java.io.Serializable;
import java.sql.Date;

public class Feriado implements Serializable{
	
	//Variables
	private static final long SerialVersionUID = 1L;
	private int idFeriado;
	private Date fecFeriado;
	
	//Constructores
	public Feriado(){}
	
	public Feriado(int idFeriado, Date fecFeriado){
		this.idFeriado = idFeriado;
		this.fecFeriado = fecFeriado;
	}

	public int getIdFeriado() {
		return idFeriado;
	}

	public void setIdFeriado(int idFeriado) {
		this.idFeriado = idFeriado;
	}

	public Date getFecFeriado() {
		return fecFeriado;
	}

	public void setFecFeriado(Date fecFeriado) {
		this.fecFeriado = fecFeriado;
	}
}
