package data;
import java.sql.*;
import utilidades.ManejoExcepciones;

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
	private Conector() throws ManejoExcepciones{
		try{
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e){
			throw new ManejoExcepciones("Error del Driver JDBC", e);
		}
		
	}
	
	//Creo una instancia del conector
	
	private static Conector instancia;
	
	public static Conector getInstacia() throws ManejoExcepciones {
		if (instancia == null){
			instancia = new Conector();
		}
		return instancia;
	}
	
	public Connection abrirConn() throws ManejoExcepciones, SQLException{
		try{
			if (conn == null || conn.isClosed()){
				conn = DriverManager.getConnection("jdbc: "+dbType+"://"+host+":"+port+"/" 
						+db+"?user="+user+"&password="+pass+"&useSSL="+useSSL);
				cantConn++;
			}
		}catch (SQLException e){
			throw new ManejoExcepciones("Error al abrir la conexion a BBDD", e);
		}
		return conn;
	}
	
	public void cerrarConn() throws ManejoExcepciones{
		cantConn--;
		if (cantConn == 0){
			try{
				conn.close();
			}catch (SQLException e){
				throw new ManejoExcepciones("Error al cerrar la conexion", e);
			}
		}
	}
	
	
}