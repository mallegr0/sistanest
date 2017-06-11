package data;
import java.sql.*;
import utilidades.ManejoExcepciones;
import entidades.Medico;
import java.util.*;

public class DataMedico {
	
	public DataMedico(){}
	
	private void cerrarConn(PreparedStatement stmt, ResultSet rs) {
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			Conector.getInstacia().cerrarConn();
		}
		catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		
	}

	public void altaMedico(Medico m){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlI = "INSERT INTO medicos (idMedico, nombreMedico, apellidoMedico, idSanatorio) VALUES(?, ?, ?, ?)";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlI, PreparedStatement.RETURN_GENERATED_KEYS);
			
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
		}
		catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
	}

	public void bajaMedico(Medico m){
		PreparedStatement stmt = null;
		String sqlD ="DELETE FROM medicos WHERE idMedico = ?";
		
		try {
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlD);
			stmt.setInt(1, m.getIdMedico());
			stmt.execute();
		}
		catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
	}
	
	public void modificaMedico(Medico m){
		PreparedStatement stmt = null;
		String sqlU = "UPDATE medicos SET (nombreMedico = ?,apellidoMedico = ?, idSanatorio = ?) WHERE idMEdico = ?";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlU);
			stmt.setString(1, m.getNombreMedico());
			stmt.setString(2, m.getApellidoMedico());
			stmt.setInt(3, m.getIdSanatorio());
			
			stmt.execute();
			
		}
		catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
	}

	public Medico consultaMedico(Medico m){
		Medico med = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlC = "SELECT * FROM medicos WHERE idMedico = ?";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlC);
			
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
		catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		
		return med;
	}

	public ArrayList<Medico> listarMedicos(){
		ArrayList<Medico> listado = new ArrayList<>();
		Medico med = null;
		PreparedStatement stmt = null;
		ResultSet rs = null; 
		String sql = "SELECT * FROM medicos";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				med = new Medico();
				while(rs.next()){
					med.setIdMedico(rs.getInt(1));
					med.setNombreMedico(rs.getString(2));
					med.setApellidoMedico(rs.getString(3));
					med.setIdSanatorio(rs.getInt(4));
					listado.add(med);
				}
			}
		}
		catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return listado;
	}
}
