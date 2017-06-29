package data;
import java.sql.*;
import utilidades.ApplicationException;
import entidades.Precio;

public class DataPrecio {
	
	public DataPrecio(){}
	
	Conexion conexion = new Conexion();
	Connection conn = conexion.abrirConn();
	
	private void cerrarConn(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conexion.cerrarConn();
		}catch(SQLException | ApplicationException e){e.printStackTrace();}
	}
	

	public boolean altaPrecio(Precio p){
		
		PreparedStatement stmt = null;
		String sqlU = "INSERT INTO precios (fecha, idSanatorio, idTpoAnestesia, valor) "
				+ "VALUES (?,?,?,?)";
		
		try{
			stmt = conn.prepareStatement(sqlU);
			
			stmt.setDate(1, (Date) p.getFecha());
			stmt.setInt(1, p.getIdSanatorio());
			stmt.setInt(2, 3);
			stmt.setFloat(4, p.getValor());
			
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
			
			stmt.setDate(1, (Date)p.getFecha());
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
		String sqlU = "UPDATE precios SET valor = ? WHERE fecha = ?, idSanatorio = ?, "
				+ "idTpoAnestesia = ?";
		
		try{
			stmt = conn.prepareStatement(sqlU);
			
			stmt.setFloat(1, p.getValor());
			stmt.setDate(2, (Date)p.getFecha());
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
		String sqlC = "SELECT * FROM precios WHERE fecha = ?, idSanatorio = ?, "
				+ "idTpoAnestesia = ?";
		
		try{
			
			stmt = conn.prepareStatement(sqlC, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setDate(1, (Date)p.getFecha());
			stmt.setInt(2, p.getIdSanatorio());
			stmt.setInt(3, p.getIdTpoAnestesia());
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				precio = new Precio();
				precio.setFecha(rs.getDate(1));
				precio.setIdSanatorio(rs.getInt(2));
				precio.setIdTpoAnestesia(3);
				precio.setValor(rs.getFloat(4));
			}
		}
		catch(SQLException  e) {e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return precio;
	}

}
