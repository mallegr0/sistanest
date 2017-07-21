package data;

import java.sql.*;
import java.util.*;
import utilidades.ApplicationException;
import entidades.AnestesiaProcedimiento;;

public class DataAnestesiaProcedimiento {
	
	// Constructor
	
	public DataAnestesiaProcedimiento(){}
	
	//--------------------------//

	private Conexion conexion = new Conexion();
	private Connection conn = conexion.abrirConn();
	
	
	//METODOS
	
	private void cerrarConn(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conexion.cerrarConn();
		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
	}
	
	
	//alta
	public boolean altaAnestesiaProcedimiento(AnestesiaProcedimiento ap) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlI = "INSERT INTO procedimientos_anestesias SET idProcedimiento = ?, idAnestesia = ?";
		
		try {
			stmt = conn.prepareStatement(sqlI);
			
			stmt.setInt(1, ap.getIdProcedimiento());
			stmt.setInt(2, ap.getIdAnestesia());
			
			stmt.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {cerrarConn(stmt, rs);}
		
	}

	// MODIFICAR -- Hago el metodo con el update en la BBDD
		
	public boolean modificaAnestesiaProcedimiento(AnestesiaProcedimiento ap) {
		//Declaro las variables
			
		PreparedStatement stmt = null;
		String sqlU = "UPDATE procedimientos_anestesias SET idProcedimiento = ? WHERE idAnestesia = ?";
			
		try{
			stmt = conn.prepareStatement(sqlU);
			
			stmt.setInt(1, ap.getIdProcedimiento());
			stmt.setInt(2, ap.getIdAnestesia());
				
			stmt.execute();
			return true;
		}
		catch (SQLException e) { 
			e.printStackTrace();
			return false;}
		finally{cerrarConn(stmt, null);}
	}
		
	// ELIMINAR -- Hago el metodo con el delete en la BBDD
		
	public boolean bajaAnestesiaProcedimiento(AnestesiaProcedimiento ap) {
			
		PreparedStatement stmt = null;
		String sqlD = "DELETE FROM procedimientos_anestesias WHERE idAnestesia = ? OR idProcedimiento = ?";
			
		try{
			stmt = conn.prepareStatement(sqlD);
			
			stmt.setInt(1, ap.getIdAnestesia());
			stmt.setInt(2, ap.getIdProcedimiento());
				
			stmt.execute();
			return true;
		}
		catch (SQLException e ){ 
			e.printStackTrace();
			return false;}
		finally{cerrarConn(stmt, null);}
	}
		
	// CONSULTAR -- Hago el metodo con la consulta a la BBDD
		
	public AnestesiaProcedimiento consultaAnestesiaProcedimiento(AnestesiaProcedimiento ap){
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		AnestesiaProcedimiento a = null;
		String sqlC = "SELECT * FROM procedimientos_anestesias "
				+ "WHERE idprocedimiento = ? OR idAnestesia = ?";
		
		try{
			stmt = conn.prepareStatement(sqlC);
			stmt.setInt(1, ap.getIdProcedimiento());
			stmt.setInt(2, ap.getIdAnestesia());
			
			rs = stmt.executeQuery();	
				
			if(rs!=null && rs.next()){
				a = new AnestesiaProcedimiento();
				a.setIdProcedimiento(rs.getInt(1));
				a.setIdAnestesia(rs.getInt(2));
			}
		}
		catch(SQLException e) {e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return a;
	}

	public ArrayList<AnestesiaProcedimiento>listarProcedimientosAnestesias(){
		AnestesiaProcedimiento ap = null;
		ArrayList<AnestesiaProcedimiento>listado = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM procedimientos ORDER BY idAnestesiaa";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				rs.beforeFirst();
				while(rs.next()){
					ap = new AnestesiaProcedimiento();
					ap.setIdProcedimiento(rs.getInt(1));
					ap.setIdAnestesia(rs.getInt(2));
					listado.add(ap);
				}
			}
		}
		catch(SQLException e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		
		return listado;
	}
}
