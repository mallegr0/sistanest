package data;

import java.sql.*;
import java.util.*;
import utilidades.ManejoExcepciones;
import entidades.Rol;

public class DataRol {
	// Constructor
	
	public DataRol(){}
	
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
	public void altaRol(Rol r) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlI = "INSERT INTO roles (idRol, descRol) VALUES (?, ?)";
		
		try {
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlI,PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, r.getIdRol());
			stmt.setString(2, r.getDescRol());
			
			stmt.execute();
			
			rs = stmt.getGeneratedKeys();
			if(rs != null && rs.next()) r.setIdRol(rs.getInt(1));
			
		} catch (SQLException | ManejoExcepciones e) {
			e.printStackTrace();
		} finally {cerrarConn(stmt, rs);}
		
	}

	// MODIFICAR -- Hago el metodo con el update en la BBDD
		
	public void modificaRol(Rol r) {
			
		//Declaro las variables
			
		PreparedStatement stmt = null;
		String sqlU = "UPDATE roles SET descRol = ? WHERE idRol = ?";
			
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlU);
			
			stmt.setString(1, r.getDescRol());
			stmt.setInt(2, r.getIdRol());
				
			stmt.execute();
		}
		catch (SQLException | ManejoExcepciones e) { e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
			
	}
		
	// ELIMINAR -- Hago el metodo con el delete en la BBDD
		
	public void eliminaRol(Rol r) {
			
		PreparedStatement stmt = null;
		String sqlD = "DELETE FROM roles where idRol = ?";
			
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlD);
			stmt.setInt(1, r.getIdRol());
				
			stmt.execute();
		}
		catch (SQLException | ManejoExcepciones e ){ e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
	}
		
	// CONSULTAR -- Hago el metodo con la consulta a la BBDD
		
	public Rol consultaRol(Rol r){
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Rol rol = null;
		String sqlC = "SELECT * FROM roles WHERE idRol = ?";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlC, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, r.getIdRol());
			
			rs = stmt.executeQuery();	
				
			if(rs!=null && rs.next()){
				rol = new Rol();
				rol.setIdRol(rs.getInt(1));
				rol.setDescRol(rs.getString(3));
			}
		}
		catch(SQLException | ManejoExcepciones e) {e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return rol;
	}

	public ArrayList<Rol>listarRoles(){
		Rol r = null;
		ArrayList<Rol>listado = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM roles ORDER BY descRol";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				while(rs.next()){
					r = new Rol();
					r.setIdRol(rs.getInt(1));
					r.setDescRol(rs.getString(2));
					listado.add(r);
				}
			}
		}
		catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		
		return listado;
	}
}
