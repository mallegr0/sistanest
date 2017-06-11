package entidades;
import java.io.Serializable;

public class Usuario implements Serializable {
	
	//Declaro las variables de la clase
	private static final long serialVersionUID = 1L;
	private String user, password, nombreUsuario, apellidoUsuario, mailUsuario;
	private int grupo, idRol;
	
	//Declaro los constructores
	public Usuario(){}
	
	public Usuario(String user, String password, String nombreUsuario, String apellidoUsuario,
			String mailUsuario, int grupo, int idRol){
		this.user = user;
		this.password = password;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.mailUsuario = mailUsuario;
		this.grupo = grupo;
		this.idRol = idRol;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getMailUsuario() {
		return mailUsuario;
	}

	public void setMailUsuario(String mailUsuario) {
		this.mailUsuario = mailUsuario;
	}
	

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	
	

}
