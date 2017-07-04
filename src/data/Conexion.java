package data;

import java.sql.*;

import utilidades.ApplicationException;

public class Conexion {
	private static String servidor = "jdbc:mysql://localhost/sistanest";
	private static String user = "root";
	private static String pass = "root";
	private static String driver = "com.mysql.jdbc.Driver";
	private static Connection conexion;
	private int cantConn = 0;
	
	public Conexion() {
		try{
			Class.forName(driver);
			conexion = DriverManager.getConnection(servidor, user, pass);
			//System.out.println("Conexion realizada con exito!!");
		}
		catch(ClassNotFoundException | SQLException e){
			System.out.println("Conexion fallida !!");
			e.printStackTrace();
		}
	}

	public Connection abrirConn(){
		try {
			if( conexion == null || conexion.isClosed()){
				cantConn++;
			}
		} catch (SQLException e) {
			new ApplicationException("Error al conectar a la BBDD",e);
		}
		return conexion;
	}
	
	public void cerrarConn() throws ApplicationException {
		try {
			cantConn--;
			if(cantConn == 0) conexion.close();
		} catch (SQLException e) {
			throw new ApplicationException("Error al cerrar la conexión",e);
		}
		
	}
}
