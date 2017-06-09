package entidades;
import java.io.Serializable;



public class Procedimiento implements Serializable {
	
	//Declaro variables
	private static final long serialVersionUID = 2L;
	
	private int idProcedimiento, codProcedimiento, complejidad;
	private String descProcedimiento;
	
	//Creo el constructor
	public Procedimiento(){}
	
	public Procedimiento(int idProcedimiento, int codProcedimiento, 
			String descProcedimiento, int complejidad){
		this.idProcedimiento = idProcedimiento;
		this.codProcedimiento = codProcedimiento;
		this.descProcedimiento = descProcedimiento;
		this.complejidad = complejidad;
	}

	public int getCodProcedimiento() {
		return codProcedimiento;
	}

	public void setCodProcedimiento(int codProcedimiento) {
		this.codProcedimiento = codProcedimiento;
	}

	public int getComplejidad() {
		return complejidad;
	}

	public void setComplejidad(int complejidad) {
		this.complejidad = complejidad;
	}

	public String getDescProcedimiento() {
		return descProcedimiento;
	}

	public void setDescProcedimiento(String descProcedimiento) {
		this.descProcedimiento = descProcedimiento;
	}

	public int getIdProcedimiento() {
		return idProcedimiento;
	}

	public void setIdProcedimiento(int idProcedimiento) {
		this.idProcedimiento = idProcedimiento;
	}
	
}
