package entidades;
import java.io.Serializable;


public class EObraSocial implements Serializable{
	
	//Variables
	
	private static final long serialVersionUID = 1L;
	private int idOS, diasMax;
	private String descOS;
	
	//Constructores
	
	public EObraSocial(){}
	
	public EObraSocial(int idOS, String descOS, int diasMax){
		this.idOS = idOS;
		this.descOS = descOS;
		this.diasMax = diasMax;
	}

	public int getIdOS() {
		return idOS;
	}

	public void setIdOS(int idOS) {
		this.idOS = idOS;
	}

	public int getDiasMax() {
		return diasMax;
	}

	public void setDiasMax(int diasMax) {
		this.diasMax = diasMax;
	}

	public String getDescOS() {
		return descOS;
	}

	public void setDescOS(String descOS) {
		this.descOS = descOS;
	}

	
	
}
