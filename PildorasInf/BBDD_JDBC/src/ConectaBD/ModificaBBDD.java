package ConectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ModificaBBDD {
	
	public static void main(String[] args) {
		try {
			
			// 1- Crear conexión
			
			Connection coneccion=DriverManager.getConnection("jdbc:mysql://localhost:3306/productos","root","root");
			
			// 2- Crear objeto statemen
			
			Statement statement=coneccion.createStatement();
	
			String instruccionINSERTSQL="insert into Productos (CODIGOARTICULO,SECCION,NOMBREARTICULO,PRECIO,FECHA,IMPORTADO,PAISORIGEN) values ('AR07','CONFECCION','SERRUCHO', 30.20, 2001-03-23,'VERDADERO','FRANCIA')";
			
			String instruccionUPDATESQL="update Productos set FECHA='2001-03-23' where CODIGOARTICULO='AR07'";
			
			String instruccionDELETESQL="delete from Productos where CODIGOARTICULO='AR07'";
			
			statement.executeUpdate(instruccionINSERTSQL);
			
			System.out.println("Datos insertados ok!"); 
			
		} catch (Exception e) {
			
			System.out.println("Error en la conexión a la base");
			e.printStackTrace();
			
		}
	}
}
