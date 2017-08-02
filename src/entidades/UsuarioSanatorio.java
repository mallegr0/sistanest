package entidades;

import java.io.Serializable;

public class UsuarioSanatorio implements Serializable{
	
	//Declaro Variables
	
	private static final long serialVersionUID = 1L;
	private String usuario;
	private int sanatorio;
	
	//Constructores
	public UsuarioSanatorio(){}
	
	public UsuarioSanatorio(String usuario, int idSanatorio){
		this.usuario = usuario;
		this.sanatorio = idSanatorio;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getSanatorio() {
		return sanatorio;
	}

	public void setSanatorio(int idSanatorio) {
		this.sanatorio = idSanatorio;
	}
	
}
