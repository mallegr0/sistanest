package data;
import java.sql.*;
import java.util.*;
import utilidades.ApplicationException;
import entidades.Anestesista;


public class DataAnestesista {
	
	public DataAnestesista(){}
	
	private void cerrarConn(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null)stmt.close();
			if(rs != null)rs.close();
			Conector.getInstacia().cerrarConn();
		}catch(SQLException | ApplicationException e){e.printStackTrace();}
	}
	
	public void altaAnestesista(Anestesista a){
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlI = "INSERT INTO (idAnestesista, nombreAnestesista, apellidoAnestesista, "
				+ "matricula, grupo) VALUES (?, ?, ?, ?, ?)";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlI, PreparedStatement.RETURN_GENERATED_KEYS);
			
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
			
		}catch(SQLException | ApplicationException e){e.printStackTrace();}finally{cerrarConn(stmt, rs);}
	}

	public void bajaAnestesista(Anestesista a){
		
		PreparedStatement stmt = null;
		String sqlD ="DELETE FROM anestesistas WHERE idAnestesista = ?";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlD);
			
			stmt.setInt(1, a.getIdAnestesista());
			
			stmt.execute();
			
		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
	}

	public void modificaAnestesista(Anestesista a){
		PreparedStatement stmt = null;
		String sqlU = "UPDATE anestesistas SET (nombreAnestesista = ?, apellidoAnestesista = ?,"
				+ " matricula = ?, grupo = ?) WHERE idAnestesista = ?";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlU);
			
			stmt.setString(1, a.getNombreAnestesista());
			stmt.setString(2, a.getApellidoAnestesista());
			stmt.setInt(3, a.getMatricula());
			stmt.setInt(4, a.getGrupo());
			stmt.setInt(5, a.getIdAnestesista());
			
			stmt.execute();
		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
	}

	public Anestesista consultaAnestesista(Anestesista a){
		Anestesista anes = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlC = "SELECT * FROM anestesistas WHERE idAnestesista = ?";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlC);
			
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
		catch(SQLException | ApplicationException e){e.printStackTrace();}
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
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sql);
			
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
		catch(SQLException | ApplicationException e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return listado;
	}
}
