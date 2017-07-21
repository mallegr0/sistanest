package data;

import java.sql.*;
import java.util.*;
import utilidades.ApplicationException;
import entidades.AnestesistaSanatorio;

public class DataSanatoriosAnestesistas {
	// Constructor
	
	public DataSanatoriosAnestesistas(){}
	
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
	public boolean altaSanatorioAnestesista(AnestesistaSanatorio as) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlI = "INSERT INTO sanatorios_anestesistas "
				+ "SET idsanatorio = ?, idAnestesista = ?";
		
		try {
			stmt = conn.prepareStatement(sqlI);
			
			stmt.setInt(1, as.getIdSanatorio());
			stmt.setInt(2, as.getIdAnestesista());
			
			stmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {cerrarConn(stmt, rs);}
		
	}

	// MODIFICAR -- Hago el metodo con el update en la BBDD
		
	//MODIFICO EL ANESTESISTA SEGUN EL SANATORIO
	public boolean modificaSanatorioAnestesistaA(AnestesistaSanatorio as) {
			
		//Declaro las variables
			
		PreparedStatement stmt = null;
		String sqlU = "UPDATE sanatorios_anestesistas SET idAnestesista = ? WHERE idSanatorio = ?"
				+ "ON DUPLICATE KEY UPDATE idSanatario = ?";
			
		try{
			stmt = conn.prepareStatement(sqlU);
			
			stmt.setInt(1, as.getIdAnestesista());
			stmt.setInt(2, as.getIdSanatorio());
			stmt.setInt(3, as.getIdSanatorio());
			
			stmt.execute();
			return true;
		}
		catch (SQLException e) { 
			e.printStackTrace();
			return false;}
		finally{cerrarConn(stmt, null);}
		 
			
	}
	
	
	//ACTUALIZO EL SANATORIO SEGUN EL ANESTESISTA
	public boolean modificaSanatorioAnestesistaS(AnestesistaSanatorio as) {
		
		//Declaro las variables
			
		PreparedStatement stmt = null;
		String sqlU = "UPDATE sanatorios_anestesistas SET idSanatorio = ? WHERE idAnestesista = ?";
			
		try{
			stmt = conn.prepareStatement(sqlU);
			
			stmt.setInt(1, as.getIdSanatorio());
			stmt.setInt(2, as.getIdAnestesista());

			
			stmt.execute();
			return true;
		}
		catch (SQLException e) { 
			e.printStackTrace();
			return false;}
		finally{cerrarConn(stmt, null);}
		 
			
	}
		
	// ELIMINAR -- Hago el metodo con el delete en la BBDD
		
	public boolean	bajaSanatorioAnestesista(AnestesistaSanatorio as) {
			
		PreparedStatement stmt = null;
		String sqlD = "DELETE FROM sanatorios_anestesistas WHERE idSanatorio = ? AND idAnestesista = ?";
			
		try{
			stmt = conn.prepareStatement(sqlD);
			
			stmt.setInt(1, as.getIdSanatorio());
			stmt.setInt(2, as.getIdAnestesista());
				
			stmt.execute();
			return true;
		}
		catch (SQLException  e ){	
			e.printStackTrace();
			return false;}
		finally{cerrarConn(stmt, null);}
		
	}
		
	// CONSULTAR -- Hago el metodo con la consulta a la BBDD
		
	public AnestesistaSanatorio consultaSanatorioAnestesista(AnestesistaSanatorio as){
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		AnestesistaSanatorio a = null;
		String sqlC = "SELECT * FROM sanatorios_anestesistas "
				+ "WHERE idSanatorio = ? OR idAnestesista = ?";
		
		try{
			stmt = conn.prepareStatement(sqlC);
			stmt.setInt(1, as.getIdSanatorio());
			stmt.setInt(2, as.getIdAnestesista());
			
			rs = stmt.executeQuery();	
				
			if(rs!=null && rs.next()){
				a = new AnestesistaSanatorio();
				a.setIdSanatorio(rs.getInt(1));
				a.setIdAnestesista(rs.getInt(2));
			}
		}
		catch(SQLException  e) {e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return a;
	}

	public ArrayList<AnestesistaSanatorio>listarSanatoriosAnestesistas(){
		AnestesistaSanatorio as = null;
		ArrayList<AnestesistaSanatorio>listado = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM sanatorios_anestesistas ORDER BY idSanatorio";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				rs.beforeFirst();
				while(rs.next()){
					as = new AnestesistaSanatorio();
					as.setIdSanatorio(rs.getInt(1));
					as.setIdAnestesista(rs.getInt(2));
					listado.add(as);
				}
			}
		}
		catch(SQLException  e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		
		return listado;
	}
}
