package data;

//Imports -- Agrego los que voy a usar en la clase

import java.sql.*; // Adentro esta el preparedStatement y el SQLException que voy a usar mas adelante
import java.util.ArrayList;
import entidades.ObraSocial; // importo la clase para usarlo como objeto
import utilidades.ApplicationException; // importo la clase para manejar excepcion



public class DataObrasSociales {
	
	//Constructor
	
	public DataObrasSociales() {}
	
	private Conexion conexion = new Conexion();
	private Connection conn = conexion.abrirConn();
	
	// ALTA -- Hago el metodo con el insert en la BBDD
	
	private void cerrarConn(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null)stmt.close();
			if(rs != null)rs.close();
			conexion.cerrarConn();
		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
	}
	
	public boolean altaObraSocial(ObraSocial os){
		// Declaro las variables a usar
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		String sqlI = "INSERT INTO obras_sociales (idOS, descOS, diasMax) VALUES(?,?,?)";
		
		// Creo la sentencia insert 
		try {
			stmt = conn.prepareStatement(sqlI,PreparedStatement.RETURN_GENERATED_KEYS);
			
			//Con este paso cambio los signos de pregunta por los datos del objeto en si
			stmt.setInt(1, os.getIdOS());
			stmt.setString(2, os.getDescOS());
			stmt.setInt(3, os.getDiasMax());
			
			//Ejecutamos la consulta
			
			stmt.execute();
			
			//Devuelvo el siguiente id de la tabla
			
			rs=stmt.getGeneratedKeys();
			if(rs != null && rs.next())
			{
				os.setIdOS(rs.getInt(1));
			}
			return true;
		}
		catch (SQLException e){ 
			e.printStackTrace();
			return false;} 
		finally{cerrarConn(stmt, rs);}
		
	}

	// MODIFICAR -- Hago el metodo con el update en la BBDD
	
	public boolean modificaObraSocial(ObraSocial os) {
		
		//Declaro las variables
		
		PreparedStatement stmt = null;
		String sqlU = "UPDATE obras_sociales SET descOS = ?, diasMax = ? WHERE idOS = ?";
		
		try{
			stmt = conn.prepareStatement(sqlU);
			
			stmt.setString(1, os.getDescOS());
			stmt.setInt(2, os.getDiasMax());
			stmt.setInt(3, os.getIdOS());
			
			stmt.execute();
			return true;
		}
		catch (SQLException  e) { 
			e.printStackTrace();
			return false;}
		finally{cerrarConn(stmt, null);}
			
	}
	
	// ELIMINAR -- Hago el metodo con el delete en la BBDD
	
	public boolean bajaObraSocial(ObraSocial os) {
		
		PreparedStatement stmt = null;
		String sqlD = "DELETE FROM obras_sociales where idOS = ?";
		
		try{
			stmt = conn.prepareStatement(sqlD);
			stmt.setInt(1, os.getIdOS());
			
			stmt.execute();
			return true;
		}
		catch (SQLException  e ){
			e.printStackTrace();
			return false;}
		finally{cerrarConn(stmt, null);}
		
	}
	
	// CONSULTAR -- Hago el metodo con la consulta a la BBDD
	
	public ObraSocial consultaObraSocial(ObraSocial os){
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ObraSocial OS = null;
		String sqlC = "SELECT * FROM obras_sociales WHERE idOS = ?";
		
		try{
			stmt = conn.prepareStatement(sqlC);
			stmt.setInt(1, os.getIdOS());
			
			rs = stmt.executeQuery();
			
			
			if(rs!=null && rs.next()){
				OS = new ObraSocial();
				OS.setIdOS(rs.getInt(1));
				OS.setDescOS(rs.getString(2));
				OS.setDiasMax(rs.getInt(3));
			}
		}
		catch(SQLException  e) {e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return OS;
	}
	
	public ArrayList<ObraSocial> listarObrasSociales(){
		ArrayList<ObraSocial> listado = new ArrayList<>();
		ObraSocial soc = null;
		PreparedStatement stmt = null;
		ResultSet rs = null; 
		String sql = "SELECT * FROM obras_sociales ORDER BY idOS";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				rs.beforeFirst();
				while(rs.next()){
					soc = new ObraSocial();
					soc.setIdOS(rs.getInt(1));
					soc.setDescOS(rs.getString(2));
					listado.add(soc);
				}
			}
		}
		catch(SQLException  e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return listado;
	}
		
}