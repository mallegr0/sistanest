package entidades;

import java.io.Serializable;

public class AnestesistaSanatorio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idAnestesista, idSanatorio;
	
	public AnestesistaSanatorio(){}
	
	public AnestesistaSanatorio(int idAnestesista, int idSanatorio){
		this.idAnestesista = idAnestesista;
		this.idSanatorio = idSanatorio;
	}

	public int getIdAnestesista() {
		return idAnestesista;
	}

	public void setIdAnestesista(int idAnestesista) {
		this.idAnestesista = idAnestesista;
	}

	public int getIdSanatorio() {
		return idSanatorio;
	}

	public void setIdSanatorio(int idSanatorio) {
		this.idSanatorio = idSanatorio;
	}

}
