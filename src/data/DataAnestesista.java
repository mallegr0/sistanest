package data;
import java.sql.*;
import java.util.*;
import utilidades.ApplicationException;
import entidades.Anestesista;


public class DataAnestesista {
	
	public DataAnestesista(){}
	
	Conexion conexion = new Conexion();
	Connection conn = conexion.abrirConn();
	
	private void cerrarConn(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null)stmt.close();
			if(rs != null)rs.close();
			conexion.cerrarConn();
		}catch(SQLException | ApplicationException e){e.printStackTrace();}
	}
	
	public boolean altaAnestesista(Anestesista a){
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlI = "INSERT INTO (idAnestesista, nombreAnestesista, apellidoAnestesista, "
				+ "matricula, grupo) VALUES (?, ?, ?, ?, ?)";
		
		try{
			stmt = conn.prepareStatement(sqlI, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, a.getIdAnestesista());
			stmt.setString(2, a.getNombreAnestesista());
			stmt.setString(3, a.getApellidoAnestesista());
			stmt.setInt(4, a.getMatricula());
			stmt.setInt(5, a.getGrupo());
			
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			if(rs != null && rs.next()){
				a.setIdAnestesista(rs.getInt(1));
			}
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;}
		finally{cerrarConn(stmt, rs);}
		 
	}

	public boolean bajaAnestesista(Anestesista a){
		
		PreparedStatement stmt = null;
		String sqlD ="DELETE FROM anestesistas WHERE idAnestesista = ?";
		
		try{
			stmt = conn.prepareStatement(sqlD);
			
			stmt.setInt(1, a.getIdAnestesista());
			
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;}
		finally{cerrarConn(stmt, null);}
		 
	}

	public boolean modificaAnestesista(Anestesista a){
		PreparedStatement stmt = null;
		String sqlU = "UPDATE anestesistas SET (nombreAnestesista = ?, apellidoAnestesista = ?,"
				+ " matricula = ?, grupo = ?) WHERE idAnestesista = ?";
		
		try{
			stmt = conn.prepareStatement(sqlU);
			
			stmt.setString(1, a.getNombreAnestesista());
			stmt.setString(2, a.getApellidoAnestesista());
			stmt.setInt(3, a.getMatricula());
			stmt.setInt(4, a.getGrupo());
			stmt.setInt(5, a.getIdAnestesista());
			
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;}
		finally{cerrarConn(stmt, null);} 
		 
	}

	public Anestesista consultaAnestesista(Anestesista a){
		Anestesista anes = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlC = "SELECT * FROM anestesistas WHERE idAnestesista = ?";
		
		try{
			stmt = conn.prepareStatement(sqlC);
			
			stmt.setInt(1, a.getIdAnestesista());
			
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				anes = new Anestesista();
				anes.setIdAnestesista(rs.getInt(1));
				anes.setNombreAnestesista(rs.getString(2));
				anes.setApellidoAnestesista(rs.getString(3));
				anes.setMatricula(rs.getInt(4));
				anes.setGrupo(rs.getInt(5));
			}
		}
		catch(SQLException e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return anes;
	}

	public ArrayList<Anestesista> listarAnestesista(){
		ArrayList<Anestesista> listado = new ArrayList<>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM anestesistas order by apellidoAnestesista, "
				+ "nombreAnestesista";
		Anestesista anes = null;
		
		try{
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				while(rs.next()){
					anes = new Anestesista();
					anes.setIdAnestesista(rs.getInt(1));
					anes.setNombreAnestesista(rs.getString(2));
					anes.setApellidoAnestesista(rs.getString(3));
					anes.setMatricula(rs.getInt(4));
					anes.setGrupo(rs.getInt(5));
					listado.add(anes);
				}
			}
		}
		catch(SQLException e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return listado;
	}
}
