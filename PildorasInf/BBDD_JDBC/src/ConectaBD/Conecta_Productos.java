package ConectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Conecta_Productos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			// 1- Crear conexión
			
			Connection coneccion=DriverManager.getConnection("jdbc:mysql://localhost:3306/productos","root","root");
			
			// 2- Crear objeto statemen
			
			Statement statement=coneccion.createStatement();
			
			// 3- Ejecutar sentencia
			
			ResultSet resultSet=statement.executeQuery("SELECT * FROM Productos");
			
			// 4- Recorrer el result set
			
			while(resultSet.next()) { // mienstras haya un registro más de donde está el cursor
				
				System.out.println( resultSet.getString("CODIGOARTICULO") + " " + resultSet.getString("NOMBREARTICULO") + " " + resultSet.getString("PRECIO") + " " + resultSet.getDate("FECHA"));
				
			}
			
		} catch (Exception e) {
			
			System.out.println("Error en la conexión a la base");
			e.printStackTrace();
			
		}
	}

}
