package entidades;

import java.io.Serializable;

public class AnestesiaProcedimiento implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idAnestesia, idProcedimiento;
	
	public AnestesiaProcedimiento(){}
	
	public AnestesiaProcedimiento(int idAnestesia, int idProcedimiento){
		this.idAnestesia = idAnestesia;
		this.idProcedimiento = idProcedimiento;
	}

	public int getIdAnestesia() {
		return idAnestesia;
	}

	public void setIdAnestesia(int idAnestesia) {
		this.idAnestesia = idAnestesia;
	}

	public int getIdProcedimiento() {
		return idProcedimiento;
	}

	public void setIdProcedimiento(int idProcedimiento) {
		this.idProcedimiento = idProcedimiento;
	}
	
	
	
}
