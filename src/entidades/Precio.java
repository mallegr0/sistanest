package entidades;

import java.io.Serializable;
import java.util.Date;

public class Precio implements Serializable{
	
	//Variables
	
	private static final long serialVersionUID = 2L;
	private int idSanatorio, idTpoAnestesia;
	private Date fecha;
	private float precio;
	
	//Constructores
	
	public Precio(){}
	
	public Precio(Date fecha, int idSanatorio, int idTpoAnestesia, float precio){
		this.fecha = fecha;
		this.idSanatorio = idSanatorio;
		this.idTpoAnestesia = idTpoAnestesia;
		this.precio = precio;
	}

	public int getIdSanatorio() {
		return idSanatorio;
	}

	public void setIdSanatorio(int idSanatorio) {
		this.idSanatorio = idSanatorio;
	}

	public int getIdTpoAnestesia() {
		return idTpoAnestesia;
	}

	public void setIdTpoAnestesia(int idTpoAnestesia) {
		this.idTpoAnestesia = idTpoAnestesia;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

}
