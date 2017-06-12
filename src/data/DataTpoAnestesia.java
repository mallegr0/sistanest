package data;

import java.sql.*;
import java.util.*;
import utilidades.ManejoExcepciones;
import entidades.TpoAnestesia;

public class DataTpoAnestesia {
	
	public DataTpoAnestesia(){}
	
	private void cerrarConn(PreparedStatement stmt, ResultSet rs){
		try{
			if(rs != null) rs.close();
			if(stmt != null)stmt.close();
			Conector.getInstacia().cerrarConn();
		}catch(SQLException | ManejoExcepciones e) {e.printStackTrace();}		
	}
	
	
	public void altaTpoAnestesia(TpoAnestesia tpoa){
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		String sqlI = "INSER INTO tpoanestesias (idTpoAnestesia, descTpoAnestesia) "
				+ "VALUES(?, ?)";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlI, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, tpoa.getIdTpoAnestesia());
			stmt.setString(2, tpoa.getDescTpoAnestesia());
			
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			
			if(rs != null && rs.next()) 
			{
				tpoa.setIdTpoAnestesia(rs.getInt(1));
			}
		}
		catch (SQLException | ManejoExcepciones e){ e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
	}

	public void bajaTpoAnestesia(TpoAnestesia tpoa) {
		
		PreparedStatement stmt = null;
		String sqlD = "DELETE FROM tpoanestesias WHERE idTpoAnestesia = ?";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlD);
			stmt.setInt(1, tpoa.getIdTpoAnestesia());
			stmt.execute();			
		}
		catch( SQLException | ManejoExcepciones e){e.printStackTrace();}
		finally{ cerrarConn(stmt, null); }
	}
	
	public void modificaTpoAnestesia(TpoAnestesia tpoa) {
		
		PreparedStatement stmt = null;
		String sqlU ="UPDATE tpoAnestesia SET descTpoAnestesia = ? WHERE idTpoAnestesia = ?";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlU);
			
			stmt.setString(1, tpoa.getDescTpoAnestesia());
			stmt.setInt(2, tpoa.getIdTpoAnestesia());
			
			stmt.execute();
			
		}catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		finally{ cerrarConn(stmt, null);}
	}
	
	public TpoAnestesia consultaTpoAnestesia(TpoAnestesia tpoa){
		
		TpoAnestesia tipoA = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		String sqlC = "SELECT * FROM tpoAnestesia WHERE idTpoAnestesia = ?";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlC, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, tpoa.getIdTpoAnestesia());
			
			rs = stmt.executeQuery();
			tipoA = new TpoAnestesia();
			tipoA.setIdTpoAnestesia(rs.getInt(1));
			tipoA.setDescTpoAnestesia(rs.getString(2));
			
		}catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		finally{ cerrarConn(stmt, rs);
		}
		return tipoA;
	}
	
	public ArrayList<TpoAnestesia>listarTpoAnestesia(){
		TpoAnestesia tpo = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<TpoAnestesia> listado = new ArrayList<>();
		String sql = "SELECT * FROM tpoAnestesias ORDER BY descTpoAnestesia";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				while(rs.next()){
					tpo = new TpoAnestesia();
					tpo.setIdTpoAnestesia(rs.getInt(1));
					tpo.setDescTpoAnestesia(rs.getString(2));
					listado.add(tpo);
				}
			}
		}
		catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return listado;
	}
	
}
