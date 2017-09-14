package data;
import java.sql.*;
import java.util.*;
import utilidades.ApplicationException;
import entidades.Anestesista;


public class DataAnestesista {
	
	public DataAnestesista(){}
	
	private Conexion conexion = new Conexion();
	private Connection conn = conexion.abrirConn();
	
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
		String sqlI = "INSERT INTO anestesistas "
				+ "SET idAnestesista = ?, nombreAnestesista = ?, apellidoAnestesista = ?, matricula =? "
				+ ", grupo = ?, usuario = ?";
		
		try{
			stmt = conn.prepareStatement(sqlI, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, a.getIdAnestesista());
			stmt.setString(2, a.getNombreAnestesista());
			stmt.setString(3, a.getApellidoAnestesista());
			stmt.setInt(4, a.getMatricula());
			stmt.setInt(5, a.getGrupo());
			stmt.setString(6, a.getUser());
			
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
		String sqlU = "UPDATE anestesistas SET nombreAnestesista = ?, apellidoAnestesista = ?,"
				+ " matricula = ?, grupo = ? WHERE idAnestesista = ?";
		
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

	public boolean ActualizaAnestesista(Anestesista a){
		PreparedStatement stmt = null;
		String sqlU = "UPDATE anestesistas SET (user = ?) WHERE idAnestesista = ?";
		
		try{
			stmt = conn.prepareStatement(sqlU);
			
			stmt.setString(1, a.getUser());
			stmt.setInt(2, a.getIdAnestesista());
			
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
				anes.setUser(rs.getString(6));
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
		String sql = "SELECT * FROM anestesistas ORDER BY apellidoAnestesista, "
				+ "nombreAnestesista";
		Anestesista anes = null;
		
		try{
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				rs.beforeFirst();
				while(rs.next()){
					anes = new Anestesista();
					anes.setIdAnestesista(rs.getInt(1));
					anes.setNombreAnestesista(rs.getString(2));
					anes.setApellidoAnestesista(rs.getString(3));
					anes.setMatricula(rs.getInt(4));
					anes.setGrupo(rs.getInt(5));
					anes.setUser(rs.getString(6));
					listado.add(anes);
				}
			}
		}
		catch(SQLException e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return listado;
	}

	public int ultimoID(){
		int nro = 0; 
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM anestesistas";
		
		try {
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			if(rs.last()){
				nro = rs.getInt(1);
			}
			return nro; 
		}
		catch(SQLException e){
			e.printStackTrace();
			return nro;
		}
		finally{ cerrarConn(stmt, rs);}
	}
	
	public Anestesista buscarAnestesista(String user){
		Anestesista a = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM anestesistas WHERE usuario = ?";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user);
			
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				a = new Anestesista();
				a.setIdAnestesista(rs.getInt(1));
				a.setNombreAnestesista(rs.getString(2));
				a.setApellidoAnestesista(rs.getString(3));
				a.setMatricula(rs.getInt(4));
				a.setGrupo(rs.getInt(5));
				a.setUser(rs.getString(6));
			}
		}
		catch(SQLException e){ e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return a;
	}
}
