package entidades;
import java.io.Serializable;


public class Medico implements Serializable{
	
	//Variables
	
	private static final long serialVersionUID = 1L;
	private int idMedico, idSanatorio;
	private String nombreMedico, apellidoMedico;
	
	//Constructores 
	
	public Medico(){}
	
	public Medico(int idMedico, String nombreMedico, String apellidoMedico, 
			int idSanatorio){
		this.idMedico = idMedico;
		this.nombreMedico = nombreMedico;
		this.apellidoMedico = apellidoMedico;
		this.idSanatorio = idSanatorio;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public int getIdSanatorio() {
		return idSanatorio;
	}

	public void setIdSanatorio(int idSanatorio) {
		this.idSanatorio = idSanatorio;
	}

	public String getNombreMedico() {
		return nombreMedico;
	}

	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}

	public String getApellidoMedico() {
		return apellidoMedico;
	}

	public void setApellidoMedico(String apellidoMedico) {
		this.apellidoMedico = apellidoMedico;
	}

}
