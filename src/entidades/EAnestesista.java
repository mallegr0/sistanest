package entidades;
import java.io.Serializable;


public class EAnestesista implements Serializable{
	
	//Variables
	private static final long serialVersionUID = 1L;
	private int idAnestesista, matricula, grupo;
	private String nombreAnestesista, apellidoAnestesista;
	
	//Constructores
	
	public EAnestesista(){}
	
	public EAnestesista(int idAnestesista, String nombreAnestesista, String apellidoAnestesista,
			int matricula, int grupo){
		this.idAnestesista = idAnestesista;
		this.nombreAnestesista = nombreAnestesista;
		this.apellidoAnestesista = apellidoAnestesista;
		this.matricula = matricula;
		this.grupo = grupo;
	}

	public int getIdAnestesista() {
		return idAnestesista;
	}

	public void setIdAnestesista(int idAnestesista) {
		this.idAnestesista = idAnestesista;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	public String getNombreAnestesista() {
		return nombreAnestesista;
	}

	public void setNombreAnestesista(String nombreAnestesista) {
		this.nombreAnestesista = nombreAnestesista;
	}

	public String getApellidoAnestesista() {
		return apellidoAnestesista;
	}

	public void setApellidoAnestesista(String apellidoAnestesista) {
		this.apellidoAnestesista = apellidoAnestesista;
	}
	
	

}
