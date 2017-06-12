package data;

import java.sql.*;
import java.util.*;
import utilidades.ManejoExcepciones;
import entidades.AnestesiaProcedimiento;;

public class DataAnestesiaProcedimiento {
	// Constructor
	
	public DataAnestesiaProcedimiento(){}
	
	//--------------------------//
	
	//METODOS
	
	private void cerrarConn(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			Conector.getInstacia().cerrarConn();
		}
		catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
	}
	
	
	//alta
	public void altaAnestesiaProcedimiento(AnestesiaProcedimiento ap) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlI = "INSERT INTO procedimietos_anestesias (idProcedimiento, idAnestesias) "
				+ "VALUES (?, ?)";
		
		try {
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlI,PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, ap.getIdProcedimiento());
			stmt.setInt(2, ap.getIdAnestesia());
			
			stmt.execute();
			
		} catch (SQLException | ManejoExcepciones e) {
			e.printStackTrace();
		} finally {cerrarConn(stmt, rs);}
		
	}

	// MODIFICAR -- Hago el metodo con el update en la BBDD
		
	public void modificaAnestesiaProcedimiento(AnestesiaProcedimiento ap) {
			
		//Declaro las variables
			
		PreparedStatement stmt = null;
		String sqlU = "UPDATE procedimientos_anestesias SET (idProcedimiento = ? , "
				+ "idAnestesia = ? WHERE idProcedimiento = ? OR idAnestesia = ?";
			
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlU);
			
			stmt.setInt(1, ap.getIdProcedimiento());
			stmt.setInt(2, ap.getIdAnestesia());
			stmt.setInt(3, ap.getIdProcedimiento());
			stmt.setInt(4, ap.getIdAnestesia());
				
			stmt.execute();
		}
		catch (SQLException | ManejoExcepciones e) { e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
			
	}
		
	// ELIMINAR -- Hago el metodo con el delete en la BBDD
		
	public void eliminaAnestesiaProcedimiento(AnestesiaProcedimiento ap) {
			
		PreparedStatement stmt = null;
		String sqlD = "DELETE FROM procedimientos_anestesias where "
				+ "idProcedimiento = ? or idAnestesia = ?";
			
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlD);
			
			stmt.setInt(1, ap.getIdProcedimiento());
			stmt.setInt(2, ap.getIdAnestesia());
				
			stmt.execute();
		}
		catch (SQLException | ManejoExcepciones e ){ e.printStackTrace();}
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
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlC, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, ap.getIdProcedimiento());
			stmt.setInt(2, ap.getIdAnestesia());
			
			rs = stmt.executeQuery();	
				
			if(rs!=null && rs.next()){
				a = new AnestesiaProcedimiento();
				a.setIdProcedimiento(rs.getInt(1));
				a.setIdAnestesia(rs.getInt(2));
			}
		}
		catch(SQLException | ManejoExcepciones e) {e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return a;
	}

	public ArrayList<AnestesiaProcedimiento>listarProcedimientosAnestesias(){
		AnestesiaProcedimiento ap = null;
		ArrayList<AnestesiaProcedimiento>listado = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM procedimientos ORDER BY idAnestesia GROUP BY idAnestesia";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				while(rs.next()){
					ap = new AnestesiaProcedimiento();
					ap.setIdProcedimiento(rs.getInt(1));
					ap.setIdAnestesia(rs.getInt(2));
					listado.add(ap);
				}
			}
		}
		catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		
		return listado;
	}
}
