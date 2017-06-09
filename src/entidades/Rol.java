package entidades;
import java.io.Serializable;

public class Rol implements Serializable {
	
	//Declaro las variables de la clase
	
	private static final long serialVersionUID = 1L;
	private int idRol;
	private String descRol;
	
	//Declaro los constructores
	public Rol() {}
	
	public Rol(int idRol, String descRol){
		this.idRol = idRol;
		this.descRol = descRol;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getDescRol() {
		return descRol;
	}

	public void setDescRol(String descRol) {
		this.descRol = descRol;
	}
	
	

}
