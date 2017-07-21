package data;

import java.util.*;
import java.sql.Date;
import java.sql.*;
import entidades.Feriado;
import utilidades.ApplicationException;

public class DataFeriado {
	
	//Constructor
	
	public DataFeriado(){}
	
	//Variables
	private Conexion conexion = new Conexion();
	private Connection conn = conexion.abrirConn();

	
	//Metodos
	//Cierro la conexion
	private void cerrarConn(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conexion.cerrarConn();
		}catch(SQLException | ApplicationException e){e.printStackTrace();}
	}
	
	//Alta
	
	public boolean altaFeriado(Feriado f){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO feriados SET fecFeriado = ?";
		
		try{
			stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);//Creo el statement y recupero el ultimo id que se genero,
																					   //solo con autoinvcremental
			stmt.setDate(1, f.getFecFeriado()); // Seteo la fecha que quiero guardar.
			stmt.execute(); //Ejecuto la consulta sql
			rs = stmt.getGeneratedKeys(); //Obtengo el ultimo ID
			
			if(rs != null && rs.next()) // Mientras que haya algun objeto en el rs leo
			{
				f.setIdFeriado(rs.getInt(1)); // Asigno el ultimo ID
			}
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally { cerrarConn(stmt, rs);}
	}
	
	//Baja
	
	public boolean bajaFeriado(Feriado f){
		PreparedStatement stmt = null;
		String sql = "DELETE FROM feriados WHERE idFeriado = ?";
		
		try{
			stmt = conn.prepareStatement(sql);//Creo el statement 
			
			stmt.setInt(1, f.getIdFeriado()); // Seteo el ID que quiero eliminar.
			stmt.execute(); //Ejecuto la consulta sql
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally { cerrarConn(stmt, null);}
	}
	
	//Modificacion
	
	public boolean modificaFeriado(Feriado f){
		PreparedStatement stmt = null;
		String sql = "UPDATE feriados SET fecFeriado = ? WHERE idFeriado = ?";
		
		try{
			stmt = conn.prepareStatement(sql);//Creo el statement
			
			stmt.setDate(1, f.getFecFeriado()); // Seteo la fecha que quiero modificar.
			stmt.setInt(2, f.getIdFeriado()); // Seteo el ID de la fecha a modificar
			
			stmt.execute(); //Ejecuto la consulta sql
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally { cerrarConn(stmt, null);}
	}
	
	//Consulta
	
	public Feriado consultaFeriado(Feriado f){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Feriado feriados = null;
		String sql = "SELECT * FROM feriados WHERE fecFeriado = ?";
		
		try{
			stmt = conn.prepareStatement(sql);//Creo el statement 
			
			stmt.setDate(1, f.getFecFeriado()); // Seteo la fecha que quiero consultar.
			
			rs = stmt.executeQuery(); //Ejecuto la consulta sql
			
			if(rs != null && rs.next()) // Mientras que haya algun objeto en el rs leo
			{
				feriados = new Feriado();
				feriados.setIdFeriado(rs.getInt(1)); // Asigno el ID
				feriados.setFecFeriado(rs.getDate(2));
			}
			return feriados;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return feriados;
		}
		finally { cerrarConn(stmt, rs);}
	}
	
	
	//Listar
	
	public ArrayList<Feriado> listarFeriado(){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Feriado> listado = new ArrayList<>();
		Feriado feriados = null; 
		String sql = "SELECT * FROM feriados ORDER BY idFeriado";
		
		try{
			stmt = conn.prepareStatement(sql);//Creo el statement
			
			rs = stmt.executeQuery(); //Ejecuto la consulta sql
			
			if(rs != null && rs.next()) // Mientras que haya algun objeto en el rs leo
			{
				rs.beforeFirst(); // vuelvo al primer elemento recuperado
				while(rs.next()){
					feriados = new Feriado();
					feriados.setIdFeriado(rs.getInt(1)); // Asigno el ID
					feriados.setFecFeriado(rs.getDate(2)); // Asigno la Fecha
					listado.add(feriados);
				}
			}
			return listado;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return listado;
		}
		finally { cerrarConn(stmt, rs);}
	}
	
	//Ultimo ID
	
}
