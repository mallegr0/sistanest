package data;

//Imports -- Agrego los que voy a usar en la clase

import java.sql.*; // Adentro esta el preparedStatement y el SQLException que voy a usar mas adelante
import java.util.ArrayList;
import entidades.Procedimiento; // importo la clase para usarlo como objeto
import utilidades.ManejoExcepciones; // importo la clase para manejar excepcion



public class DataProcedimientos {
	
	//Constructor
	
	public DataProcedimientos(){}
	
	private void cerrarConn(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			Conector.getInstacia().cerrarConn();
		}
		catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
	}
	// ALTA -- Hago el metodo con el insert en la BBDD
	
	public void altaProcedimiento(Procedimiento p){
		// Declaro las variables a usar
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		String sqlI = "INSERT INTO procedimientos (idProcedimiento, codProcedimiento, "
				+ "descProcedimiento, complejidad) VALUES(?,?,?,?)";
		
		// Creo la sentencia insert 
		try {
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlI,PreparedStatement.RETURN_GENERATED_KEYS);
			
			//Con este paso cambio los signos de pregunta por los datos del objeto en si
			stmt.setInt(1, p.getIdProcedimiento());
			stmt.setInt(2, p.getCodProcedimiento());
			stmt.setString(3, p.getDescProcedimiento());
			stmt.setInt(4, p.getComplejidad());
			
			//Ejecutamos la consulta
			
			stmt.execute();
			
			//Devuelvo el siguiente id de la tabla
			
			rs=stmt.getGeneratedKeys();
			if(rs != null && rs.next())
			{
				p.setIdProcedimiento(rs.getInt(1));
			}
		}
		catch (SQLException | ManejoExcepciones e){ e.printStackTrace();} 
		finally{cerrarConn(stmt, rs);}
	}

	// MODIFICAR -- Hago el metodo con el update en la BBDD
	
	public void modificaProcedimiento(Procedimiento p) {
		
		//Declaro las variables
		
		PreparedStatement stmt = null;
		String sqlU = "UPDATE procedimientos SET codProcedimiento=?, descProcedimiento = ?, "
				+ "complejidad = ? WHERE codProcedimiento = ?";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlU);
			
			stmt.setInt(1, p.getCodProcedimiento());
			stmt.setString(2, p.getDescProcedimiento());
			stmt.setInt(3, p.getComplejidad());
			stmt.setInt(4, p.getIdProcedimiento());
			
			stmt.execute();
		}
		catch (SQLException | ManejoExcepciones e) { e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
			
	}
	
	// ELIMINAR -- Hago el metodo con el delete en la BBDD
	
	public void eliminaProcedimiento(Procedimiento p) {
		
		PreparedStatement stmt = null;
		String sqlD = "DELETE FROM procedimientos where idProcedimiento = ?";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlD);
			stmt.setInt(1, p.getIdProcedimiento());
			
			stmt.execute();
		}
		catch (SQLException | ManejoExcepciones e ){ e.printStackTrace();}
		finally{cerrarConn(stmt, null);}
	}
	
	// CONSULTAR -- Hago el metodo con la consulta a la BBDD
	
	public Procedimiento consultaProcedimiento(Procedimiento p){
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Procedimiento procedimiento = null;
		String sqlC = "SELECT * FROM procedimientos WHERE idProcedimiento = ?";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sqlC, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, p.getIdProcedimiento());
			
			rs = stmt.executeQuery();
			
			
			if(rs!=null && rs.next()){
				procedimiento = new Procedimiento();
				procedimiento.setIdProcedimiento(rs.getInt(1));
				procedimiento.setCodProcedimiento(rs.getInt(2));
				procedimiento.setDescProcedimiento(rs.getString(3));
				procedimiento.setComplejidad(rs.getInt(4));
			}
		}
		catch(SQLException | ManejoExcepciones e) {e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return procedimiento;
	}
	
	public ArrayList<Procedimiento> listarProcedimientos(){
		ArrayList<Procedimiento> listado = new ArrayList<>();
		Procedimiento proceso = null;
		PreparedStatement stmt = null;
		ResultSet rs = null; 
		String sql = "SELECT * FROM sanatorios";
		
		try{
			stmt = Conector.getInstacia().abrirConn().prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				while(rs.next()){
					proceso = new Procedimiento();
					proceso.setIdProcedimiento(rs.getInt(1));
					proceso.setCodProcedimiento(rs.getInt(2));
					proceso.setDescProcedimiento(rs.getString(3));
					proceso.setComplejidad(rs.getInt(4));
					listado.add(proceso);
				}
			}
		}
		catch(SQLException | ManejoExcepciones e){e.printStackTrace();}
		finally{cerrarConn(stmt, rs);}
		return listado;
	}
		
}


