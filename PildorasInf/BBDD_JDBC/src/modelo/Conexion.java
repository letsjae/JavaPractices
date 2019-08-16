package modelo;

import java.sql.*;

public class Conexion {
	public Conexion() {
		
	}
	
	public Connection getConnection() {
		
		try {
			
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/productos","root","root");
		
		} catch (Exception e) {
		
		}
		
		return conexion;
		
		
	}
	
	Connection conexion=null;
}
