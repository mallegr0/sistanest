package controlador;

import java.sql.*;
import entidades.Sanatorio;
import utilidades.ApplicationException;
import data.Conexion;

public class Data {
	
	public Data(){}
	Conexion conexion = new Conexion();
	Connection conn = conexion.abrirConn();
	
	
	public boolean alta(Sanatorio s){
		ResultSet rs = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO sanatorios (idSanatorio, razonSocial) VALUES(?, ?)";
		
		try{
			stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, s.getIdSanatorio());
			stmt.setString(2, s.getRazonSocial());
			
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			s.setIdSanatorio(rs.getInt(1));
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally {
			try{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				conexion.cerrarConn();
			}catch(SQLException | ApplicationException e){e.printStackTrace();}
		}
			}

}
