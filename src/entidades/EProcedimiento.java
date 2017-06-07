package entidades;
import java.io.Serializable;



public class EProcedimiento implements Serializable {
	
	//Declaro variables
	private static final long serialVersionUID = 1L;
	
	private int codProcedimiento, complejidad;
	private String descProcedimiento;
	
	//Creo el constructor
	public EProcedimiento(){}
	
	public EProcedimiento(int codProcedimiento, String descProcedimiento, int complejidad){
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
	
	
	

}
