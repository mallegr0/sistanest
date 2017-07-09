package data;
import java.sql.*;
import utilidades.ApplicationException;
import entidades.Medico;
import java.util.*;

public class DataMedico {
	
	public DataMedico(){}
	
	Conexion conexion = new Conexion();
	Connection conn = conexion.abrirConn();
	
	private void cerrarConn(PreparedStatement stmt, ResultSet rs) {
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conexion.cerrarConn();
		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
	}

	public boolean altaMedico(Medico m){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlI = "INSERT INTO medicos (idMedico, nombreMedico, apellidoMedico, idSanatorio)"
				+ " VALUES(?, ?, ?, ?)";
		
		try{
			stmt = conn.prepareStatement(sqlI, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, m.getIdMedico());
			stmt.setString(2, m.getNombreMedico());
			stmt.setString(3, m.getApellidoMedico());
			stmt.setInt(4, m.getIdSanatorio());
			
			stmt.execute();
			
			rs = stmt.getGeneratedKeys();
			if(rs != null && rs.next())
			{
				m.setIdMedico(rs.getInt(1));
			}
			return true;
		}
		catch(SQLException  e){
			e.printStackTrace();
			//return false;
			}
		finally{cerrarConn(stmt, rs);}
		return false;
	}

	public boolean bajaMedico(Medico m){
		PreparedStatement stmt = null;
		String sqlD ="DELETE FROM medicos WHERE idMedico = ?";
		
		try {
			stmt = conn.prepareStatement(sqlD);
			stmt.setInt(1, m.getIdMedico());
			stmt.execute();
			return true;
		}
		catch(SQLException  e){
			e.printStackTrace();
			return false; 
		}
		finally{cerrarConn(stmt, null);}
	}
	
	public boolean modificaMedico(Medico m){
		PreparedStatement stmt = null;
		String sqlU = "UPDATE medicos SET nombreMedico = ?,apellidoMedico = ?, idSanatorio = ? "
				+ "WHERE idMedico = ?";
		
		try{
			stmt = conn.prepareStatement(sqlU);
			stmt.setString(1, m.getNombreMedico());
			stmt.setString(2, m.getApellidoMedico());
			stmt.setInt(3, m.getIdSanatorio());
			stmt.setInt(4, m.getIdMedico());
			
			stmt.execute();
			return true;
		}
		catch(SQLException  e){
			e.printStackTrace();
			return false;}
		finally{cerrarConn(stmt, null);}
	}

	public Medico consultaMedico(Medico m){
		Medico med = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlC = "SELECT * FROM medicos WHERE idMedico = ?";
		
		try{
			stmt = conn.prepareStatement(sqlC);
			
			stmt.setInt(1, m.getIdMedico());
			
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				med = new Medico();
				med.setIdMedico(rs.getInt(1));
				med.setNombreMedico(rs.getString(2));
				med.setApellidoMedico(rs.getString(3));
				med.setIdSanatorio(rs.getInt(4));
			}
		}
		catch(SQLException  e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		
		return med;
	}

	public ArrayList<Medico> listarMedicos(){
		ArrayList<Medico> listado = new ArrayList<>();
		Medico med = null;
		PreparedStatement stmt = null;
		ResultSet rs = null; 
		String sql = "SELECT * FROM medicos ORDER BY apellidoMedico, nombreMedico";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				rs.beforeFirst();
				while(rs.next()){
					med = new Medico();
					med.setIdMedico(rs.getInt(1));
					med.setNombreMedico(rs.getString(2));
					med.setApellidoMedico(rs.getString(3));
					med.setIdSanatorio(rs.getInt(4));
					listado.add(med);
				}
			}
		}
		catch(SQLException  e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return listado;
	}
}
