package data;
import java.sql.*;
import utilidades.ApplicationException;

public class Conector {
	
	//Declaro las variables necesarias para la conexion con la BBDD
	private String dbDriver = "com.mysql.jdbc.Driver";
	private String host = "sistanest";
	private String port = "3306";
	private String user = "root";
	private String pass = "root";
	private String db = "sistanest";
	private String dbType = "mysql";
	private boolean useSSL = false;
	
	//Declaro el cbjeto conn y la cantidad de conexiones permitidas
	private Connection conn;
	private int cantConn = 0;
	
	
	//Constructor del conector a BBDD -- es Singleton para que no haya mas de una conexion
	//al mismo tiempo.
	private Conector() throws ApplicationException{
		try{
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e){
			throw new ApplicationException("Error del Driver JDBC", e);
		}
		
	}
	
	//Creo una instancia del conector
	
	private static Conector instancia;
	
	public static Conector getInstacia() throws ApplicationException {
		if (instancia == null){
			instancia = new Conector();
		}
		return instancia;
	}
	
	public Connection abrirConn() throws ApplicationException, SQLException{
		try{
			if (conn == null || conn.isClosed()){
				conn = DriverManager.getConnection("jdbc: "+dbType+"://"+host+":"+port+"/" 
						+db+"?user="+user+"&password="+pass+"&useSSL="+useSSL);
				cantConn++;
			}
		}catch (SQLException e){
			throw new ApplicationException("Error al abrir la conexion a BBDD", e);
		}
		return conn;
	}
	
	public void cerrarConn() throws ApplicationException{
		cantConn--;
		if (cantConn == 0){
			try{
				conn.close();
			}catch (SQLException e){
				throw new ApplicationException("Error al cerrar la conexion", e);
			}
		}
	}
	
	
}