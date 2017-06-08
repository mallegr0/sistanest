package entidades;

import java.io.Serializable;
import java.util.Date;

public class EAnestesia implements Serializable{
	
	//Variables
	private static final long serialVersionUID = 2L;
	private int idAnestesia, nroAfiliado, nocturno, feriado, fds, nroTalon, nroVias, hora;
	private int edad, idMedico, idAnestesista, idSanatorio, codProcedimiento, idOS, idTpoAnestesia;
	private Date fecPrestacion, fecAra, FecRendicion, fecCarga;
	private String afiliado, user;
	//private Time hora;
	
	
	//Constructores
	public EAnestesia(){}
	
	public EAnestesia(int idAnestesia, Date fecPrestacion, Date fecARA, Date fecRendicion,
			Date fecCarga, String afiliado, int nroAfiliado, int nocturno, int feriado,
			int fds, int nroTalon, int nroVias, int edad, int hora, String user, int idMedico,
			int idAnestesista, int idSanatorio, int codProcedimiento, int idOS,
			int idTpoAnestesia){
		this.idAnestesia = idAnestesia;
		this.fecPrestacion = fecPrestacion;
		this.fecAra = fecARA;
		this.FecRendicion = fecRendicion;
		this.fecCarga = fecCarga;
		this.afiliado = afiliado;
		this.nroAfiliado = nroAfiliado;
		this.nocturno = nocturno;
		this.feriado = feriado;
		this.fds = fds;
		this.nroTalon = nroTalon;
		this.nroVias = nroVias;
		this.edad = edad;
		this.hora = hora;
		this.user = user;
		this.idMedico = idMedico;
		this.idAnestesista = idAnestesista;
		this.idSanatorio = idSanatorio;
		this.codProcedimiento = codProcedimiento;
		this.idOS = idOS;
		this.idTpoAnestesia = idTpoAnestesia;
	}

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

	public int getNocturno() {
		return nocturno;
	}

	public void setNocturno(int nocturno) {
		this.nocturno = nocturno;
	}

	public int getFeriado() {
		return feriado;
	}

	public void setFeriado(int feriado) {
		this.feriado = feriado;
	}

	public int getFds() {
		return fds;
	}

	public void setFds(int fds) {
		this.fds = fds;
	}

	public int getNroTalon() {
		return nroTalon;
	}

	public void setNroTalon(int nroTalon) {
		this.nroTalon = nroTalon;
	}

	public int getNroVias() {
		return nroVias;
	}

	public void setNroVias(int nroVias) {
		this.nroVias = nroVias;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
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

	public int getCodProcedimiento() {
		return codProcedimiento;
	}

	public void setCodProcedimiento(int codProcedimiento) {
		this.codProcedimiento = codProcedimiento;
	}

	public int getIdOS() {
		return idOS;
	}

	public void setIdOS(int idOS) {
		this.idOS = idOS;
	}

	public int getIdTpoAnestesia() {
		return idTpoAnestesia;
	}

	public void setIdTpoAnestesia(int idTpoAnestesia) {
		this.idTpoAnestesia = idTpoAnestesia;
	}

	public Date getFecPrestacion() {
		return fecPrestacion;
	}

	public void setFecPrestacion(Date fecPrestacion) {
		this.fecPrestacion = fecPrestacion;
	}

	public Date getFecAra() {
		return fecAra;
	}

	public void setFecAra(Date fecAra) {
		this.fecAra = fecAra;
	}

	public Date getFecRendicion() {
		return FecRendicion;
	}

	public void setFecRendicion(Date fecRendicion) {
		FecRendicion = fecRendicion;
	}

	public Date getFecCarga() {
		return fecCarga;
	}

	public void setFecCarga(Date fecCarga) {
		this.fecCarga = fecCarga;
	}

	public String getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(String afiliado) {
		this.afiliado = afiliado;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}
	
	
}
