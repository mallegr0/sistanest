package data;
import java.sql.*;
import utilidades.ApplicationException;
import entidades.Saldo;

public class DataPagos {
	
	public DataPagos(){}
	
	private void cerrarConn(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			Conector.getInstacia().cerrarConn();
		}catch(SQLException | ApplicationException e){e.printStackTrace();}
		
	}
	
	private boolean rta = false;
	
	public boolean altaPago(Saldo s){
		PreparedStatement stmt = null;
		String sqlI = "INSERT INTO saldos (idAnestesia, mes, anio, monto, estado) "
				+ "VALUES(?, ?, ?, ?, ?)";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlI);
			
			stmt.setInt(1, s.getIdAnestesista());
			stmt.setInt(2, s.getMes());
			stmt.setInt(3, s.getAnio());
			stmt.setFloat(4, s.getMonto());
			stmt.setString(5, s.getEstado());
			
			rta = stmt.execute();
		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
		return rta;
	}
	
	public boolean bajaPago(Saldo s) {
		PreparedStatement stmt = null;
		String sqlD = "DELETE FROM saldo WHERE idAnestesista = ?, mes = ?, anio = ?";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlD);
			
			stmt.setInt(1, s.getIdAnestesista());
			stmt.setInt(2, s.getMes());
			stmt.setInt(3, s.getAnio());
			
			rta = stmt.execute();

		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
		return rta;
	}

	public boolean modificarPago(Saldo s){
		PreparedStatement stmt = null;
		String sqlU = "UPDATE saldos SET (monto = ?, estado = ?) WHERE idAnestesista = ?, "
				+ "mes = ?, anio = ?";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlU);
			
			stmt.setFloat(1, s.getMonto());
			stmt.setString(2, s.getEstado());
			stmt.setInt(3, s.getIdAnestesista());
			stmt.setInt(4, s.getMes());
			stmt.setInt(5, s.getAnio());
			
			rta = stmt.execute();
		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
		return rta;
	}

	public Saldo consultaPago(Saldo s){
		Saldo pago = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		String sqlC = "SELECT * FROM WHERE idAnestesista = ?, mes = ?, anio = ?";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlC);
			
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
		catch(SQLException | ApplicationException e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		
		
		return pago;
	}
}
