package entidades;
import java.io.Serializable;

public class TpoAnestesia implements Serializable {
	
	//Declaro las variables de la clase
	
	private static final long serialVersionUID = 1L;
	
	private int idTpoAnestesia;
	private String descTpoAnestesia;
	
	//Declaro los constructores
	public TpoAnestesia(){}
	
	public TpoAnestesia(int idTpoAnestesia, String descTpoAnestesia){
		this.idTpoAnestesia = idTpoAnestesia;
		this.descTpoAnestesia = descTpoAnestesia;
	}

	public int getIdTpoAnestesia() {
		return idTpoAnestesia;
	}

	public void setIdTpoAnestesia(int idTpoAnestesia) {
		this.idTpoAnestesia = idTpoAnestesia;
	}

	public String getDescTpoAnestesia() {
		return descTpoAnestesia;
	}

	public void setDescTpoAnestesia(String descTpoAnestesia) {
		this.descTpoAnestesia = descTpoAnestesia;
	}

}
