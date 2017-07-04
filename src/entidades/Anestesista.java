package entidades;
import java.io.Serializable;


public class Anestesista implements Serializable{
	
	//Variables
	private static final long serialVersionUID = 2L;
	private int idAnestesista, matricula, grupo;
	private String nombreAnestesista, apellidoAnestesista, user;
	
	//Constructores
	
	public Anestesista(){}
	
	public Anestesista(int idAnestesista, String nombreAnestesista, String apellidoAnestesista,
			int matricula, int grupo, String user){
		this.idAnestesista = idAnestesista;
		this.nombreAnestesista = nombreAnestesista;
		this.apellidoAnestesista = apellidoAnestesista;
		this.matricula = matricula;
		this.grupo = grupo;
		this.user = user;
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
	
	public String getUser(){
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}

}
