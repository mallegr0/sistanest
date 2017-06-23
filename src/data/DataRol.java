package data;

import java.sql.*;
import java.util.*;
import utilidades.ApplicationException;
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
		catch(SQLException | ApplicationException e){e.printStackTrace();}
	}
	
	private boolean rta = false;
	
	//alta
	public Boolean altaRol(Rol r) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlI = "INSERT INTO roles (idRol, descRol) VALUES (?, ?)";
		
		try {
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlI,PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, r.getIdRol());
			stmt.setString(2, r.getDescRol());
			
			rta = stmt.execute();
			
			rs = stmt.getGeneratedKeys();
			if(rs != null && rs.next()) r.setIdRol(rs.getInt(1));

			
		} catch (SQLException | ApplicationException e) {
			e.printStackTrace();
		} finally {cerrarConn(stmt, rs);}
		
		return rta;
	}

	// MODIFICAR -- Hago el metodo con el update en la BBDD
		
	public boolean modificaRol(Rol r) {
			
		//Declaro las variables
			
		PreparedStatement stmt = null;
		String sqlU = "UPDATE roles SET descRol = ? WHERE idRol = ?";
			
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlU);
			
			stmt.setString(1, r.getDescRol());
			stmt.setInt(2, r.getIdRol());
				
			rta = stmt.execute();
			
		}
		catch (SQLException | ApplicationException e) { e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
		return rta;
	}
		
	// ELIMINAR -- Hago el metodo con el delete en la BBDD
		
	public boolean bajaRol(Rol r) {
			
		PreparedStatement stmt = null;
		String sqlD = "DELETE FROM roles where idRol = ?";

		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlD);
			stmt.setInt(1, r.getIdRol());
				
			rta = stmt.execute();
		}
		catch (SQLException | ApplicationException e ){ e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
		return rta;
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
		catch(SQLException | ApplicationException e) {e.printStackTrace();}
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
		catch(SQLException | ApplicationException e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		
		return listado;
	}
	
	public int ultimoID(){
		int a = 1;
		String sql = "SELECT MAX(idRol) FROM roles";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sql);
			
			rs = stmt.executeQuery();
			a = rs.getInt(1);
		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
		finally {cerrarConn(stmt, rs);}
		return a;
	}
}

