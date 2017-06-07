package data;
import java.sql.*;
import java.util.*;

//import 

public class DProcedimientos {

}
/*
import entidades.Personaje;
import utilidades.ApplicationException;

public class DataPersonaje {
	
	public DataPersonaje(){
		
	}
	
	public void altaPersonaje(Personaje p){
		
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		try {
			stmt=Conexion.getInstancia().getConn().prepareStatement("INSERT INTO personajes" +
					"(id, nombre, puntos, vida, energia, defensa, evasion) "
					+ "VALUES(?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, p.getId());
			stmt.setString(2, p.getNombre());
			stmt.setInt(3, p.getPtosTotales());
			stmt.setInt(4, p.getVida());
			stmt.setInt(5, p.getEnergia());
			stmt.setInt(6, p.getDefensa());
			stmt.setInt(7, p.getEvasion());
			
			stmt.execute();
			
			//DEVUELVE EL SIGUIENTE ID EN LA FILA DE LA TABLA DE LA BD
			rs=stmt.getGeneratedKeys();
			if(rs!=null && rs.next()){
				p.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();
				Conexion.getInstancia().releaseConn();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void modificaPersonaje(Personaje p){
		PreparedStatement stmt=null;
		try {
			stmt= Conexion.getInstancia().getConn().prepareStatement("update personajes set " +
					"nombre = ?, puntos = ?, vida = ?, " +
					"energia = ?, defensa = ?, evasion = ? " +
					"WHERE id = ?");
			
			stmt.setString(1, p.getNombre());
			stmt.setInt(2, p.getPtosTotales());
			stmt.setInt(3, p.getVida());
			stmt.setInt(4, p.getEnergia());
			stmt.setInt(5, p.getDefensa());
			stmt.setInt(6, p.getEvasion());
			stmt.setInt(7, p.getId());
			stmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null)stmt.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void eliminaPersonaje(Personaje p){
		PreparedStatement stmt=null;
		try {
			stmt = Conexion.getInstancia().getConn().prepareStatement("delete from personajes where id=?");
			stmt.setInt(1, p.getId());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public Personaje consultaPersonaje(Personaje per){
		Personaje p = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = Conexion.getInstancia().getConn().prepareStatement(
					"SELECT * FROM personajes WHERE id = ?;", PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, per.getId());
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				p = new Personaje();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setVida(rs.getInt("vida"));
				p.setDefensa(rs.getInt("defensa"));
				p.setPtosTotales(rs.getInt("puntos"));
				p.setEvasion(rs.getInt("evasion"));
				p.setEnergia(rs.getInt("energia"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}

	public Personaje buscaPersonaje(Personaje per){
		Personaje p = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = Conexion.getInstancia().getConn().prepareStatement(
					"SELECT * FROM personajes WHERE nombre = ?;", PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, per.getNombre());
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				p = new Personaje();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setVida(rs.getInt("vida"));
				p.setDefensa(rs.getInt("defensa"));
				p.setPtosTotales(rs.getInt("puntos"));
				p.setEvasion(rs.getInt("evasion"));
				p.setEnergia(rs.getInt("energia"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}
	
	public ArrayList<String> listarPersonajes(){
		ArrayList<String> listado = new ArrayList<>();
		PreparedStatement decPrep = null;
		ResultSet conjResult = null;
		
		try {
			decPrep = Conexion.getInstancia().getConn().prepareStatement("SELECT * FROM personajes", PreparedStatement.RETURN_GENERATED_KEYS);
			conjResult = decPrep.executeQuery();
			if(conjResult!=null && conjResult.next()){
				while(conjResult.next()){
					String p = new String();
					p = conjResult.getString("nombre");
					listado.add(p);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(conjResult!=null)conjResult.close();
				if(decPrep!=null)decPrep.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Problemas de conexión con la Base de Datos al intentar listar los personajes");
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listado;
	}
	
}*/