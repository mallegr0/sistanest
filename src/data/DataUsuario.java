package data;

import java.sql.*;
import java.util.ArrayList;

import utilidades.ManejoExcepciones;
import entidades.Usuario;

public class DataUsuario {
	
	public DataUsuario(){}
	
	private void cerrarConn(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			Conector.getInstacia().cerrarConn();
		}catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
	}
	
	public void altaUsuario(Usuario u){
		
		PreparedStatement stmt = null;
		String sqlI = "INSERT INTO usuarios (user, password, nombreUsuario, apellidoUsuario,"
				+ " mailUsuario, grupo, idRol) VALUES(???????)";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlI);
			
			stmt.setString(1, u.getUser());
			stmt.setString(2, u.getPassword());
			stmt.setString(3, u.getNombreUsuario());
			stmt.setString(4, u.getApellidoUsuario());
			stmt.setString(5, u.getMailUsuario());
			stmt.setInt(6, u.getGrupo());
			stmt.setInt(7, u.getIdRol());
			
			stmt.execute();
			
		}
		catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
	}

	public void borraUsuario(Usuario u){
		PreparedStatement stmt = null;
		String sqlD ="DELETE FROM usuarios WHERE user = ?";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlD);
			
			stmt.setString(1, u.getUser());
			
			stmt.execute();
		}
		catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
	}
	
	public Usuario consultaUsuario(Usuario u){
		Usuario user = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlC = "SELECT * FROM usuarios user = ?";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlC);
			
			stmt.setString(1, u.getUser());
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				user = new Usuario();
				user.setUser(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setNombreUsuario(rs.getString(3));
				user.setApellidoUsuario(rs.getString(4));
				user.setMailUsuario(rs.getString(5));
				user.setGrupo(rs.getInt(6));
				user.setIdRol(rs.getInt(7));
			}
		}
		catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return user;
	}
	
	public ArrayList<Usuario>listarUsuario(){
		Usuario user = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Usuario>listado = new ArrayList<>();
		String sqla = "SELECT * FROM usuarios ORDER BY user";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqla);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				while(rs.next()){
					user = new Usuario();
					user.setUser(rs.getString(1));
					user.setPassword(rs.getString(2));
					user.setNombreUsuario(rs.getString(3));
					user.setApellidoUsuario(rs.getString(4));
					user.setMailUsuario(rs.getString(5));
					user.setGrupo(rs.getInt(6));
					user.setIdRol(rs.getInt(7));
					listado.add(user);
				}
			}
		}
		catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return listado;
	}
	
	public ArrayList<Usuario>listarPendientes(){
		Usuario user = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Usuario>listado = new ArrayList<>();
		String sqla = "SELECT * FROM usuarios WHERE grupo = 'NULL' ORDER BY user";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqla);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				while(rs.next()){
					user = new Usuario();
					user.setUser(rs.getString(1));
					user.setPassword(rs.getString(2));
					user.setNombreUsuario(rs.getString(3));
					user.setApellidoUsuario(rs.getString(4));
					user.setMailUsuario(rs.getString(5));
					user.setGrupo(rs.getInt(6));
					user.setIdRol(rs.getInt(7));
					listado.add(user);
				}
			}
		}
		catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return listado;
	}
	
}