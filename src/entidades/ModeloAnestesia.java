package entidades;

import java.io.Serializable;
import java.util.Date;

public class ModeloAnestesia implements Serializable{
	
	/* 
	 * VARIABLES
	 * ----------
	 */
	private static final long serialVersionUID = 1L;
	public int idAnestesia, nroAfiliado, nroVias, nroTalon;
	public String afiliado, edad, usuario, medico, anestesista, sanatorio, osocial, tpoAnestesia;
	public Date fecPrestacion, fecARA, fecCarga, fecRendicion;
	public boolean nocturno, feriado, fds;
	
	/*
	 * CONSTRUCTORES
	 * -------------
	 */
	public ModeloAnestesia() {}
	
	public ModeloAnestesia(int idAnestesia, Date fp, Date fa, Date fc, Date fr, String afiliado, int nroAfiliado,
			boolean nocturno, boolean feriado, boolean fds, int nroVias, String edad, String usuario, String medico,
			String anestesista, String sanatorio, String OS, String tpoAnestesia, int nroTalon){
		this.idAnestesia = idAnestesia;
		this.fecPrestacion = fp;
		this.fecARA = fa;
		this.fecCarga = fc;
		this.fecRendicion = fr;
		this.afiliado = afiliado;
		this.nroAfiliado = nroAfiliado;
		this.nocturno = nocturno;
		this.feriado = feriado;
		this.fds = fds;
		this.nroVias = nroVias;
		this.edad = edad;
		this.usuario = usuario;
		this.medico = medico;
		this.anestesista = anestesista;
		this.sanatorio = sanatorio;
		this.osocial = OS;
		this.tpoAnestesia = tpoAnestesia;
		this.nroTalon = nroTalon;
	}
	
	/*
	 * METODOS
	 * -------
	*/
	public int getIdAnestesia() {
		return idAnestesia;
	}

	public void setIdAnestesia(int idAnestesia) {
		this.idAnestesia = idAnestesia;
	}

	public int getNroAfiliado() {
		return nroAfiliado;
	}

	public void setNroAfiliado(int nroAfiliado) {
		this.nroAfiliado = nroAfiliado;
	}

	public int getNroVias() {
		return nroVias;
	}

	public void setNroVias(int nroVias) {
		this.nroVias = nroVias;
	}

	public String getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(String afiliado) {
		this.afiliado = afiliado;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getAnestesista() {
		return anestesista;
	}

	public void setAnestesista(String anestesista) {
		this.anestesista = anestesista;
	}

	public String getSanatorio() {
		return sanatorio;
	}

	public void setSanatorio(String sanatorio) {
		this.sanatorio = sanatorio;
	}

	public String getOsocial() {
		return osocial;
	}

	public void setOsocial(String osocial) {
		this.osocial = osocial;
	}

	public String getTpoAnestesia() {
		return tpoAnestesia;
	}

	public void setTpoAnestesia(String tpoAnestesia) {
		this.tpoAnestesia = tpoAnestesia;
	}

	public Date getFecPrestacion() {
		return fecPrestacion;
	}

	public void setFecPrestacion(Date fecPrestacion) {
		this.fecPrestacion = fecPrestacion;
	}

	public Date getFecARA() {
		return fecARA;
	}

	public void setFecARA(Date fecARA) {
		this.fecARA = fecARA;
	}

	public Date getFecCarga() {
		return fecCarga;
	}

	public void setFecCarga(Date fecCarga) {
		this.fecCarga = fecCarga;
	}

	public Date getFecRendicion() {
		return fecRendicion;
	}

	public void setFecRendicion(Date fecRendicion) {
		this.fecRendicion = fecRendicion;
	}

	public boolean isNocturno() {
		return nocturno;
	}

	public void setNocturno(boolean nocturno) {
		this.nocturno = nocturno;
	}

	public boolean isFeriado() {
		return feriado;
	}

	public void setFeriado(boolean feriado) {
		this.feriado = feriado;
	}

	public boolean isFds() {
		return fds;
	}

	public void setFds(boolean fds) {
		this.fds = fds;
	}
	
	public int getNroTalon(){
		return nroTalon;
	}
	
	public void setNroTalon(int nroTalon){
		this.nroTalon = nroTalon;
	}

}
