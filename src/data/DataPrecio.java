package data;
import java.sql.*;
import java.util.ArrayList;

import utilidades.ApplicationException;
import entidades.Precio;

public class DataPrecio {
	
	public DataPrecio(){}
	
	private Conexion conexion = new Conexion();
	private Connection conn = conexion.abrirConn();
	
	private void cerrarConn(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conexion.cerrarConn();
		}catch(SQLException | ApplicationException e){e.printStackTrace();}
	}
	
	public boolean altaPrecio(Precio p){
		
		PreparedStatement stmt = null;
		String sqlU = "INSERT INTO precios (fecha, idSanatorio, idTpoAnestesia, precio) "
				+ "VALUES (?,?,?,?)";
		
		try{
			stmt = conn.prepareStatement(sqlU);
			
			stmt.setTimestamp(1, (Timestamp) p.getFecha());
			stmt.setInt(2, p.getIdSanatorio());
			stmt.setInt(3, p.getIdTpoAnestesia());
			stmt.setFloat(4, p.getPrecio());
			
			stmt.execute();
			return true;
		}
		catch(SQLException  e){
			e.printStackTrace();
			return false;}
		finally{ cerrarConn(stmt, null);}
		
	}
	
	public boolean bajaPrecio(Precio p){
		
		PreparedStatement stmt = null;
		String sqlD = "DELETE FROM precios WHERE fecha = ? AND idSanatorio = ? "
				+ "AND idTpoAnestesia = ?";
		
		try{
			
			stmt = conn.prepareStatement(sqlD);
			
			stmt.setTimestamp(1, (Timestamp)p.getFecha());
			stmt.setInt(2, p.getIdSanatorio());
			stmt.setInt(3, p.getIdTpoAnestesia());
			
			stmt.execute();
			return true;
		}
		catch(SQLException  e){
			e.printStackTrace();
			return false;}
		finally{ cerrarConn(stmt, null);}
		
	}
	
	public boolean modificaPrecio(Precio p){
		
		PreparedStatement stmt = null;
		String sqlU = "UPDATE precios SET precio = ? WHERE fecha = ? AND idSanatorio = ? AND "
				+ "idTpoAnestesia = ?";
		
		try{
			stmt = conn.prepareStatement(sqlU);
			
			stmt.setFloat(1, p.getPrecio());
			stmt.setTimestamp(2, (Timestamp)p.getFecha());
			stmt.setInt(3, p.getIdSanatorio());
			stmt.setInt(4, p.getIdTpoAnestesia());
			
			stmt.execute();
			return true;
		}
		catch(SQLException  e){
			e.printStackTrace();
			return false;}
		finally{cerrarConn(stmt, null);}
		
	}
	
	public Precio consultaPrecio(Precio p) {
		
		Precio precio = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		String sqlC = "SELECT * FROM precios WHERE fecha = ? AND idSanatorio = ? AND "
				+ "idTpoAnestesia = ?";
		
		try{
			
			stmt = conn.prepareStatement(sqlC);
			
			stmt.setTimestamp(1, (Timestamp)p.getFecha());
			stmt.setInt(2, p.getIdSanatorio());
			stmt.setInt(3, p.getIdTpoAnestesia());
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				precio = new Precio();
				precio.setFecha(rs.getDate(1));
				precio.setIdSanatorio(rs.getInt(2));
				precio.setIdTpoAnestesia(3);
				precio.setPrecio(rs.getFloat(4));
			}
		}
		catch(SQLException  e) {e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return precio;
	}

	public ArrayList<Precio> listarPrecio(Precio p) {
		Precio precio = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		ArrayList<Precio> listado = new ArrayList<>();
		String sqlC = "SELECT * FROM precios WHERE idSanatorio = ? ORDER BY fecha desc, idTpoAnestesia";
		
		try{
			
			stmt = conn.prepareStatement(sqlC);
			
			stmt.setInt(1, p.getIdSanatorio());
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				rs.beforeFirst();
				while(rs.next()){
					precio = new Precio();
					precio.setFecha(rs.getDate(1));
					precio.setIdSanatorio(rs.getInt(2));
					precio.setIdTpoAnestesia(3);
					precio.setPrecio(rs.getFloat(4));
					listado.add(precio);
				}
			}
			else{listado = null;}
		}
		catch(SQLException  e) {e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return listado;
	}

}
