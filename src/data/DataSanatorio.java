package data;
import java.sql.*;
import java.util.ArrayList;
import utilidades.ApplicationException;
import entidades.Sanatorio;

public class DataSanatorio {
	
	public DataSanatorio(){}
	
	private void cerrarConn(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null)stmt.close();
			if(rs != null)rs.close();
			Conector.getInstacia().cerrarConn();}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
	}
	
	boolean rta = false;
	
	public boolean altaSanatorio(Sanatorio s){
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		String sqlI = "INSERT INTO sanatorios (idSanatorio, razonSocial) VALUES (?, ?)";
		
		try {
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlI, PreparedStatement.RETURN_GENERATED_KEYS );
			
			stmt.setInt(1, s.getIdSanatorio());
			stmt.setString(2, s.getRazonSocial());
			
			stmt.execute();
			
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()){
				s.setIdSanatorio(rs.getInt(1));
			}
			rta = true;
		} catch (SQLException | ApplicationException e ) { e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return rta;
	}
	
	public boolean bajaSanatorio(Sanatorio s){
		
		PreparedStatement stmt = null;
		String sqlD = "DELETE FROM sanatorios WHERE idSanatorio = ?";
		
		try{
		stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlD);
		stmt.setInt(1, s.getIdSanatorio());
		stmt.execute();
		rta = true;
		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
		return rta;
 	}
	
	public boolean modificaSanatorio(Sanatorio s){
		
		PreparedStatement stmt = null;
		String sqlU = "UPDATE sanatorios SET razonSocial = ? WHERE idSanatorio = ?";
		
		try {
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlU);
			
			stmt.setString(1, s.getRazonSocial());
			stmt.setInt(2, s.getIdSanatorio());
			
			stmt.execute();
			
			rta = true;
		}
		catch (SQLException | ApplicationException e){ e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
		
		return rta;
	}
	
	public Sanatorio consultaSanatorio(Sanatorio s){
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		String sqlC = "SELECT * FROM sanatorios WHERE idSanatorio = ?";
		Sanatorio san = null;
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlC, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, s.getIdSanatorio());
			rs = stmt.executeQuery();
			
			san = new Sanatorio();
			
			san.setIdSanatorio(rs.getInt(1));
			san.setRazonSocial(rs.getString(2));	
		}
		catch(SQLException | ApplicationException e){ e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return san;
	}
	
	public ArrayList<Sanatorio> listarSanatorios(){
		ArrayList<Sanatorio> listado = new ArrayList<>();
		Sanatorio sana = null;
		PreparedStatement stmt = null;
		ResultSet rs = null; 
		String sql = "SELECT * FROM sanatorios";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				while(rs.next()){
					sana = new Sanatorio();
					sana.setIdSanatorio(rs.getInt(1));
					sana.setRazonSocial(rs.getString(2));
					listado.add(sana);
				}
			}
		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return listado;
	}
}
