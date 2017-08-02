package data;

import entidades.UsuarioSanatorio;
import utilidades.ApplicationException;
import java.util.*;
import java.sql.*;


public class DataUsuarioSanatorio {
	
	//Variables
	private Conexion  conexion = new Conexion();
	private Connection conn = conexion.abrirConn();
	
	//Constructor
	public DataUsuarioSanatorio(){}
	
	//Metodos
	private void cerrarConn(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conexion.cerrarConn();
		}
		catch(SQLException | ApplicationException e){ e.printStackTrace();}
	}
	
	public boolean altaUsuarioSanatorio(UsuarioSanatorio us){
		PreparedStatement stmt = null;
		String sql = "INSERT INTO usuarios_sanatorios SET usr=?, sanatorio =?";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, us.getUsuario());
			stmt.setInt(2, us.getSanatorio());
			
			return stmt.execute();
		}
		catch(SQLException e){ 
			e.printStackTrace();
			return false;
		}
		finally{cerrarConn(stmt, null);}
	}
	
	public boolean bajaUsuarioSanatorio(String usuario){
		PreparedStatement stmt = null;
		String sql = "DELETE FROM usuarios_sanatorios WHERE usr=?";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, usuario);
			
			return stmt.execute();
		}
		catch(SQLException e){ 
			e.printStackTrace();
			return false;
		}
		finally{cerrarConn(stmt, null);}
	}
	
	public boolean modificaUsuarioSanatorio(UsuarioSanatorio us){
		PreparedStatement stmt = null;
		String sql = "UPDATE usuarios_sanatorios SET sanatorio = ? WHERE usr = ?";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, us.getSanatorio());
			stmt.setString(2, us.getUsuario());

			
			return stmt.execute();
		}
		catch(SQLException e){ 
			e.printStackTrace();
			return false;
		}
		finally{cerrarConn(stmt, null);}
	}
	
	public UsuarioSanatorio consultaUsuarioSanatorio(String usuario){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		UsuarioSanatorio us = null;
		String sql = "SELECT * FROM usuarios_sanatorios WHERE usr = ?";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, usuario);

			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				us = new UsuarioSanatorio();
				us.setUsuario(rs.getString(1));
				us.setSanatorio(rs.getInt(2));
			}
			
		}
		catch(SQLException e){ 
			e.printStackTrace();
		}
		finally{cerrarConn(stmt, rs);}
		return us;
	}
	
	public ArrayList<UsuarioSanatorio> listarUsuarioSanatorio(){
		ArrayList<UsuarioSanatorio> listados = new ArrayList<>();
		UsuarioSanatorio us = null;
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		String sql = "SELECT * FROM usuarios_sanatorios GROUP BY usr";
	 
		try{
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				rs.beforeFirst();
				us = new UsuarioSanatorio();
				while(rs.next()){
					us.setUsuario(rs.getString(1));
					us.setSanatorio(rs.getInt(2));
					listados.add(us);
				}
			}
		}
		catch(SQLException e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return listados;
	}
	
	
}
