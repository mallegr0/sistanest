package entidades;
import java.io.Serializable;

public class ESaldo implements Serializable{
	
	//Variables
	private static final long serialVersionUID = 1L;
	private int idAnestesia;
	private float monto;
	private String estado;
	
	//Constructores
	
	public ESaldo(){}
	
	public ESaldo(int idAnestesia, float monto, String estado){
		this.idAnestesia = idAnestesia;
		this.monto = monto;
		this.estado = estado;
	}

	public int getIdAnestesia() {
		return idAnestesia;
	}

	public void setIdAnestesia(int idAnestesia) {
		this.idAnestesia = idAnestesia;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	

}
