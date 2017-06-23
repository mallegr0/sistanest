package data;

import java.sql.*;
import java.util.ArrayList;

import utilidades.ApplicationException;
import entidades.Usuario;

public class DataUsuario {
	
	public DataUsuario(){}
	
	boolean rta = false;
	
	private void cerrarConn(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			Conector.getInstacia().cerrarConn();
		}catch(SQLException | ApplicationException e){e.printStackTrace();}
	}
	
	public boolean altaUsuario(Usuario u){
		
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
			
			rta = stmt.execute();
		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
		return rta;
	}

	public boolean borraUsuario(Usuario u){
		PreparedStatement stmt = null;
		String sqlD ="DELETE FROM usuarios WHERE user = ?";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlD);
			
			stmt.setString(1, u.getUser());
			
			rta = stmt.execute();
		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
		return rta;
	}
	
	public boolean modificaUsuario(Usuario u) {
		
		PreparedStatement stmt = null;
		String sqlU = "UPDATE usuarios SET (password = ?, nombreUsuario = ?, apellidoUsuario = ?,"
				+ "mailUSuario = ?, idRol = ?, grupo = ? WHERE user = ?)";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlU);
			
			stmt.setString(1, u.getPassword());
			stmt.setString(2, u.getNombreUsuario());
			stmt.setString(3, u.getApellidoUsuario());
			stmt.setString(4, u.getMailUsuario());
			stmt.setInt(5, u.getIdRol());
			stmt.setInt(6, u.getGrupo());
			stmt.setString(7, u.getUser());
			
			rta = stmt.execute();
			
		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
		return rta;
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
		catch(SQLException | ApplicationException e){e.printStackTrace();}
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
		catch(SQLException | ApplicationException e){e.printStackTrace();}
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
		catch(SQLException | ApplicationException e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return listado;
	}
	
}
