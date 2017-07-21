package data;
import java.sql.*;
import java.util.*;
import utilidades.ApplicationException;
import entidades.Saldo;

public class DataPagos {
	
	public DataPagos(){}
	
	private Conexion conexion = new Conexion();
	private Connection conn = conexion.abrirConn();
	
	private void cerrarConn(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conexion.cerrarConn();
		}catch(SQLException | ApplicationException e){e.printStackTrace();}
		
	}
	
	
	public boolean altaPago(Saldo s){
		PreparedStatement stmt = null;
		String sqlI = "INSERT INTO saldos (idAnestesista, mes, anio, monto, estado) "
				+ "VALUES(?, ?, ?, ?, ?)";
		
		try{
			stmt = conn.prepareStatement(sqlI);
			
			stmt.setInt(1, s.getIdAnestesista());
			stmt.setInt(2, s.getMes());
			stmt.setInt(3, s.getAnio());
			stmt.setFloat(4, s.getMonto());
			stmt.setString(5, s.getEstado());
			
			stmt.execute();
			return true;
		}
		catch(SQLException  e){
			e.printStackTrace();
			return false;}
		finally{cerrarConn(stmt, null);}
		
	}
	
	public boolean bajaPago(Saldo s) {
		PreparedStatement stmt = null;
		String sqlD = "DELETE FROM saldos WHERE idAnestesista = ? AND mes = ? AND anio = ?";
		
		try{
			stmt = conn.prepareStatement(sqlD);
			
			stmt.setInt(1, s.getIdAnestesista());
			stmt.setInt(2, s.getMes());
			stmt.setInt(3, s.getAnio());
			
			stmt.execute();
			return true;
		}
		catch(SQLException  e){
			e.printStackTrace();
			return false;}
		finally{cerrarConn(stmt, null);}
		
	}

	public boolean modificarPago(Saldo s){
		PreparedStatement stmt = null;
		String sqlU = "UPDATE saldos SET monto = ?, estado = ? WHERE idAnestesista = ? AND "
				+ "mes = ? AND anio = ?";
		
		try{
			stmt = conn.prepareStatement(sqlU);
			
			stmt.setFloat(1, s.getMonto());
			stmt.setString(2, s.getEstado());
			stmt.setInt(3, s.getIdAnestesista());
			stmt.setInt(4, s.getMes());
			stmt.setInt(5, s.getAnio());
			
			stmt.execute();
			return true;
		}
		catch(SQLException  e){
			e.printStackTrace();
			return false;}
		finally{cerrarConn(stmt, null);}
		
	}

	public Saldo consultaPago(Saldo s){
		Saldo pago = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		String sqlC = "SELECT * FROM saldos WHERE idAnestesista = ? AND mes = ? AND anio = ?";
		
		try{
			stmt = conn.prepareStatement(sqlC);
			
			stmt.setInt(1, s.getIdAnestesista());
			stmt.setInt(2, s.getMes());
			stmt.setInt(3, s.getAnio());
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				pago = new Saldo();
				pago.setIdAnestesista(rs.getInt(1));
				pago.setMes(rs.getInt(2));
				pago.setAnio(rs.getInt(3));
				pago.setMonto(rs.getFloat(4));
				pago.setEstado(rs.getString(5));
			}
		}
		catch(SQLException  e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		
		
		return pago;
	}
	
	public ArrayList<Saldo> ListarPago(Saldo s){
		Saldo pago = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		ArrayList<Saldo> listado = new ArrayList<>();
		String sqlC = "SELECT * FROM saldos WHERE idAnestesista = ? AND anio = ?";
		
		try{
			stmt = conn.prepareStatement(sqlC);
			
			stmt.setInt(1, s.getIdAnestesista());
			stmt.setInt(2, s.getAnio());
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				rs.beforeFirst();
				while(rs.next()){
					pago = new Saldo();
					pago.setIdAnestesista(rs.getInt(1));
					pago.setMes(rs.getInt(2));
					pago.setAnio(rs.getInt(3));
					pago.setMonto(rs.getFloat(4));
					pago.setEstado(rs.getString(5));
					listado.add(pago);
				}
			}
		}
		catch(SQLException  e){
			e.printStackTrace();
			return null;
		}
		
		finally{cerrarConn(stmt, rs);}
		return listado;
	}
}
