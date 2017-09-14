package data;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import utilidades.ApplicationException;
import entidades.Anestesia;

public class DataAnestesia {
	
	public DataAnestesia(){}
	
	private Conexion conexion = new Conexion();
	private Connection conn = conexion.abrirConn();
	
	private void cerrarConn(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conexion.cerrarConn();
		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
	}

	public boolean altaAnestesia(Anestesia a){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlI = "INSERT INTO anestesias (idAnestesia, fecPrestacion, fecARA, "
				+ "fecRendicion, fecCarga, afiliado, nroAfiliado, nocturno, feriado, fds, "
				+ "nroTalon, nroVias, edad, user, idMedico, idAnestesista, idSanatorio,"
				+ "idOS, idTpoAnestesia) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
				+ "?, ?, ?, ?, ?, ?)";
		
		try{
			stmt = conn.prepareStatement(sqlI, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, a.getIdAnestesia());
			stmt.setTimestamp(2, (Timestamp)a.getFecPrestacion());
			stmt.setDate(3, cambioFecha((a.getFecAra())));
			stmt.setDate(4, cambioFecha(a.getFecRendicion()));
			stmt.setDate(5, cambioFecha(a.getFecCarga()));
			stmt.setString(6, a.getAfiliado());
			stmt.setInt(7, a.getNroAfiliado());
			stmt.setInt(8, a.getNocturno());
			stmt.setInt(9, a.getFeriado());
			stmt.setInt(10, a.getFds());
			stmt.setInt(11, a.getNroTalon());
			stmt.setInt(12, a.getNroVias());
			stmt.setString(13, a.getEdad());
			stmt.setString(14, a.getUser());
			stmt.setInt(15, a.getIdMedico());
			stmt.setInt(16, a.getIdAnestesista());
			stmt.setInt(17, a.getIdSanatorio());
			stmt.setInt(18, a.getIdOS());
			stmt.setInt(19, a.getIdTpoAnestesia());
			
			stmt.execute();
			
			rs = stmt.getGeneratedKeys();
			if(rs != null && rs.next()){
				a.setIdAnestesia(rs.getInt(1));
			}
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;}
		finally{cerrarConn(stmt, rs);}
	}

	public boolean bajaAnestesia(Anestesia a){
		PreparedStatement stmt = null;
		String sqlD = "DELETE FROM anestesias WHERE idAnestesia = ?";
		
		try{
			stmt = conn.prepareStatement(sqlD);
			
			stmt.setInt(1, a.getIdAnestesia());
			
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;}
		finally{cerrarConn(stmt, null);}
	}
	
	public boolean modificaAnestesia(Anestesia a){
		PreparedStatement stmt = null;
		String sqlU = "UPDATE anestesias SET fecPrestacion = ?, fecARA = ?, fecRendicion = ?, "
				+ "fecCarga = ?, afiliado = ?, nroAfiliado = ?, nocturno = ?, feriado = ?,"
				+ "fds = ?, nroTalon = ?, nroVias = ?, edad = ?, user = ?,"
				+ "idMedico = ?, idAnestesista = ?, idSanatorio = ?, idOS = ?, "
				+ "idTpoAnestesia = ? WHERE idAnestesia = ?";
		
		try{
			stmt = conn.prepareStatement(sqlU);
			
			stmt.setTimestamp(1, (Timestamp)a.getFecPrestacion());
			stmt.setDate(2, (Date)a.getFecAra());
			stmt.setDate(3, (Date)a.getFecRendicion());
			stmt.setDate(4, (Date)a.getFecCarga());
			stmt.setString(5, a.getAfiliado());
			stmt.setInt(6, a.getNroAfiliado());
			stmt.setInt(7, a.getNocturno());
			stmt.setInt(8, a.getFeriado());
			stmt.setInt(9, a.getFds());
			stmt.setInt(10, a.getNroTalon());
			stmt.setInt(11, a.getNroVias());
			stmt.setString(12, a.getEdad());
			stmt.setString(13, a.getUser());
			stmt.setInt(14, a.getIdMedico());
			stmt.setInt(15, a.getIdAnestesista());
			stmt.setInt(16, a.getIdSanatorio());
			stmt.setInt(17, a.getIdOS());
			stmt.setInt(18, a.getIdTpoAnestesia());
			stmt.setInt(19, a.getIdAnestesia());
			
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;}
		finally{cerrarConn(stmt, null);}
	}

	public Anestesia consultaAnestesia(Anestesia a){
		Anestesia anes = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlC = "SELECT * FROM anestesias WHERE idAnestesia = ?";
		
		try{
			stmt =conn.prepareStatement(sqlC);
			
			stmt.setInt(1, a.getIdAnestesia());
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				anes = new Anestesia();
				anes.setIdAnestesia(rs.getInt(1));
				anes.setFecPrestacion(rs.getTimestamp(2));
				anes.setFecAra(rs.getDate(3));
				anes.setFecRendicion(rs.getDate(4));
				anes.setFecCarga(rs.getDate(5));
				anes.setAfiliado(rs.getString(6));
				anes.setNroAfiliado(rs.getInt(7));
				anes.setNocturno(rs.getInt(8));
				anes.setFeriado(rs.getInt(9));
				anes.setFds(rs.getInt(10));
				anes.setNroTalon(rs.getInt(11));
				anes.setNroVias(rs.getInt(12));
				anes.setEdad(rs.getString(13));
				anes.setUser(rs.getString(14));
				anes.setIdMedico(rs.getInt(15));
				anes.setIdAnestesista(rs.getInt(16));
				anes.setIdSanatorio(rs.getInt(17));
				anes.setIdOS(rs.getInt(18));
				anes.setIdTpoAnestesia(rs.getInt(19));
			}
		}
		catch(SQLException e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return anes;
	}

	public ArrayList<Anestesia> listarAnestesias(){
		ArrayList<Anestesia>listado = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Anestesia anes = null;
		String sql = "SELECT * FROM anestesias ORDER BY fecPrestacion";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				rs.beforeFirst();
				while(rs.next()){
					anes = new Anestesia();
					anes.setFecPrestacion(rs.getTimestamp(2));
					anes.setFecAra(rs.getDate(3));
					anes.setFecRendicion(rs.getDate(4));
					anes.setFecCarga(rs.getDate(5));
					anes.setAfiliado(rs.getString(6));
					anes.setNroAfiliado(rs.getInt(7));
					anes.setNocturno(rs.getInt(8));
					anes.setFeriado(rs.getInt(9));
					anes.setFds(rs.getInt(10));
					anes.setNroTalon(rs.getInt(11));
					anes.setNroVias(rs.getInt(12));
					anes.setEdad(rs.getString(13));
					anes.setUser(rs.getString(14));
					anes.setIdMedico(rs.getInt(15));
					anes.setIdAnestesista(rs.getInt(16));
					anes.setIdSanatorio(rs.getInt(17));
					anes.setIdOS(rs.getInt(18));
					anes.setIdTpoAnestesia(rs.getInt(19));
					listado.add(anes);
				}
			}
		}
		catch(SQLException e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		
		return listado;
	}
		
	public ArrayList<Anestesia>listarPorFecha(Date fecIni, Date fecFin){
		ArrayList<Anestesia>listado = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Anestesia anes = null;
		String sql = "SELECT * FROM anestesias WHERE fecPrestacion BETWEEN ? AND ?"
				+ "ORDER BY fecPrestacion";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setDate(1, (Date) fecIni);
			stmt.setDate(2, (Date) fecFin);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				rs.beforeFirst();
				while(rs.next()){
					anes = new Anestesia();
					anes.setIdAnestesia(rs.getInt(1));
					anes.setFecPrestacion(rs.getTimestamp(2));
					anes.setFecAra(rs.getDate(3));
					anes.setFecRendicion(rs.getDate(4));
					anes.setFecCarga(rs.getDate(5));
					anes.setAfiliado(rs.getString(6));
					anes.setNroAfiliado(rs.getInt(7));
					anes.setNocturno(rs.getInt(8));
					anes.setFeriado(rs.getInt(9));
					anes.setFds(rs.getInt(10));
					anes.setNroTalon(rs.getInt(11));
					anes.setNroVias(rs.getInt(12));
					anes.setEdad(rs.getString(13));
					anes.setUser(rs.getString(14));
					anes.setIdMedico(rs.getInt(15));
					anes.setIdAnestesista(rs.getInt(16));
					anes.setIdSanatorio(rs.getInt(17));
					anes.setIdOS(rs.getInt(18));
					anes.setIdTpoAnestesia(rs.getInt(19));
					listado.add(anes);
				}
			}
		}
		catch(SQLException e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return listado;
	}

	public ArrayList<Anestesia>listarPorAnestesista(int id, Date fecIni, Date fecFin){
		ArrayList<Anestesia>listado = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Anestesia anes = null;
		String sql;
		
		if (fecIni != null && fecFin != null){
			sql = "SELECT * FROM anestesias WHERE idAnestesista = ? AND "
					+ "fecPrestacion BETWEEN ? AND ? ORDER BY fecPrestacion";
		}
		else
		{
			sql = "SELECT * FROM anestesias WHERE idAnestesista = ? "
					+ "ORDER BY idAnestesista, fecPrestacion";
		}
		
		try{
			stmt = conn.prepareStatement(sql);
			
			if(fecIni != null && fecFin != null){
				stmt.setInt(1, id);
				stmt.setDate(2, (Date) fecIni);
				stmt.setDate(3, (Date) fecFin);
			}
			else
			{
				stmt.setInt(1, id);
			}
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				rs.beforeFirst();
				while(rs.next()){
					anes = new Anestesia();
					anes.setIdAnestesia(rs.getInt(1));
					anes.setFecPrestacion(rs.getDate(2));
					anes.setFecAra(rs.getDate(3));
					anes.setFecRendicion(rs.getDate(4));
					anes.setFecCarga(rs.getDate(5));
					anes.setAfiliado(rs.getString(6));
					anes.setNroAfiliado(rs.getInt(7));
					anes.setNocturno(rs.getInt(8));
					anes.setFeriado(rs.getInt(9));
					anes.setFds(rs.getInt(10));
					anes.setNroTalon(rs.getInt(11));
					anes.setNroVias(rs.getInt(12));
					anes.setEdad(rs.getString(13));
					anes.setUser(rs.getString(14));
					anes.setIdMedico(rs.getInt(15));
					anes.setIdAnestesista(rs.getInt(16));
					anes.setIdSanatorio(rs.getInt(17));
					anes.setIdOS(rs.getInt(18));
					anes.setIdTpoAnestesia(rs.getInt(19));
					listado.add(anes);
					
				}
			}
		}
		catch(SQLException e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return listado;
	}

	public ArrayList<Anestesia>listarPorOS(int id, Date fecIni, Date fecFin){
		ArrayList<Anestesia>listado = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Anestesia anes = null;
		String sql;
		
		if (fecIni != null && fecFin != null){
			sql = "SELECT * FROM anestesias WHERE idOS = ? AND "
					+ "fecPrestacion BETWEEN ? AND ? ORDER BY idAnestesista, fecPrestacion";
		}
		else
		{
			sql = "SELECT * FROM anestesias WHERE idOS = ? "
					+ "ORDER BY idAnestesista, fecPrestacion";
		}
		
		try{
			stmt = conn.prepareStatement(sql);
			
			if(fecIni != null && fecFin != null){
				stmt.setInt(1, id);
				stmt.setDate(2, (Date) fecIni);
				stmt.setDate(3, (Date) fecFin);
			}
			else
			{
				stmt.setInt(1, id);
			}
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				rs.beforeFirst();
				while(rs.next()){
					anes = new Anestesia();
					anes.setIdAnestesia(rs.getInt(1));
					anes.setFecPrestacion(rs.getTimestamp(2));
					anes.setFecAra(rs.getDate(3));
					anes.setFecRendicion(rs.getDate(4));
					anes.setFecCarga(rs.getDate(5));
					anes.setAfiliado(rs.getString(6));
					anes.setNroAfiliado(rs.getInt(7));
					anes.setNocturno(rs.getInt(8));
					anes.setFeriado(rs.getInt(9));
					anes.setFds(rs.getInt(10));
					anes.setNroTalon(rs.getInt(11));
					anes.setNroVias(rs.getInt(12));
					anes.setEdad(rs.getString(13));
					anes.setUser(rs.getString(14));
					anes.setIdMedico(rs.getInt(15));
					anes.setIdAnestesista(rs.getInt(16));
					anes.setIdSanatorio(rs.getInt(17));
					anes.setIdOS(rs.getInt(18));
					anes.setIdTpoAnestesia(rs.getInt(19));
					listado.add(anes);
					
				}
			}
		}
		catch(SQLException e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return listado;
	}

	public ArrayList<Anestesia> listarPaciente(String paciente){
		ArrayList<Anestesia> listado = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Anestesia anes = null;
		String sql = "SELECT * FROM anestesias WHERE afiliado LIKE CONCAT('%', ?, '%') ORDER BY fecPrestacion, afiliado";
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, paciente);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				rs.beforeFirst();
				while(rs.next())
				{
					anes = new Anestesia();
					anes.setIdAnestesia(rs.getInt(1));
					anes.setFecPrestacion(rs.getTimestamp(2));
					anes.setFecAra(rs.getTimestamp(3));
					anes.setFecRendicion(rs.getTimestamp(4));
					anes.setFecCarga(rs.getTimestamp(5));
					anes.setAfiliado(rs.getString(6));
					anes.setNroAfiliado(rs.getInt(7));
					anes.setNocturno(rs.getInt(8));
					anes.setFeriado(rs.getInt(9));
					anes.setFds(rs.getInt(10));
					anes.setNroTalon(rs.getInt(11));
					anes.setNroVias(rs.getInt(12));
					anes.setEdad(rs.getString(13));
					anes.setUser(rs.getString(14));
					anes.setIdMedico(rs.getInt(15));
					anes.setIdAnestesista(rs.getInt(16));
					anes.setIdSanatorio(rs.getInt(17));
					anes.setIdOS(rs.getInt(18));
					anes.setIdTpoAnestesia(rs.getInt(19));
					listado.add(anes);
				}
			}
		}
		catch(SQLException e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return listado;
	}

	public static java.sql.Date cambioFecha(
            java.util.Date fecha) {
        java.sql.Date sqlDate = null;
        if (fecha != null) {
            sqlDate = new Date(fecha.getTime());
        }
        return sqlDate;
    }

	public int ultimoID(){
		int nro = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM anestesias";
		try{
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.last()){
				nro = rs.getInt(1);
			}
			return nro;
		}
		catch(SQLException e){
			e.printStackTrace();
			return nro;
		}
		finally{cerrarConn(stmt, rs);}
	}
}
