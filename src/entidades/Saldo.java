package entidades;
import java.io.Serializable;

public class Saldo implements Serializable{
	
	//Variables
	private static final long serialVersionUID = 1L;
	private int idAnestesista, mes, anio;
	private float monto;
	private String estado;
	
	//Constructores
	
	public Saldo(){}
	
	public Saldo(int idAnestesista, int mes, int anio, float monto, String estado){
		this.idAnestesista = idAnestesista;
		this.mes = mes;
		this.anio = anio;
		this.monto = monto;
		this.estado = estado;
	}

	public int getIdAnestesista() {
		return idAnestesista;
	}

	public void setIdAnestesista(int idAnestesia) {
		this.idAnestesista = idAnestesia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public int getAnio() {
		return anio;
	}
	
	public void setAnio(int anio) {
		this.anio = anio;
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
