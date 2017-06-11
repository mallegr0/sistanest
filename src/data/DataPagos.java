package data;
import java.sql.*;
import utilidades.ManejoExcepciones;
import entidades.Saldo;

public class DataPagos {
	
	public DataPagos(){}
	
	private void cerrarConn(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			Conector.getInstacia().cerrarConn();
		}catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		
	}
	
	public void altaPago(Saldo s){
		PreparedStatement stmt = null;
		String sqlI = "INSERT INTO saldos (idAnestesia, mes, monto, estado) VALUES(?, ?, ?, ?)";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlI);
			
			stmt.setInt(1, s.getIdAnestesista());
			stmt.setInt(2, s.getMes());
			stmt.setFloat(2, s.getMonto());
			stmt.setString(3, s.getEstado());
			
			stmt.execute();
		}
		catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
	}
	
	public void bajaPago(Saldo s) {
		PreparedStatement stmt = null;
		String sqlD = "DELETE FROM saldo WHERE idAnestesista = ?, mes = ?";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlD);
			
			stmt.setInt(1, s.getIdAnestesista());
			stmt.setInt(2, s.getMes());
			
			stmt.execute();
		}
		catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
		
	}

	public void modificarPago(Saldo s){
		PreparedStatement stmt = null;
		String sqlU = "UPDATE saldos SET (monto = ?, estado = ?) WHERE idAnestesista = ?, mes = ?";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlU);
			
			stmt.setFloat(1, s.getMonto());
			stmt.setString(2, s.getEstado());
			stmt.setInt(3, s.getIdAnestesista());
			stmt.setInt(4, s.getMes());
			
			stmt.execute();
		}
		catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
	}

	public Saldo consultaPago(Saldo s){
		Saldo pago = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		String sqlC = "SELECT * FROM WHERE idAnestesista = ?, mes = ?";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlC);
			
			stmt.setInt(1, s.getIdAnestesista());
			stmt.setInt(2, s.getMes());
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				pago = new Saldo();
				pago.setMonto(rs.getFloat(3));
				pago.setEstado(rs.getString(4));
			}
		}
		catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		
		
		return pago;
	}
}
