package entidades;
import java.io.Serializable;

public class ETpoAnestesia implements Serializable {
	
	//Declaro las variables de la clase
	
	private static final long serialVersionUID = 1L;
	
	private int idTpoAnestesia;
	private String descTpoAnestesia;
	
	//Declaro los constructores
	public ETpoAnestesia(){}
	
	public ETpoAnestesia(int idTpoAnestesia, String descTpoAnestesia){
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
