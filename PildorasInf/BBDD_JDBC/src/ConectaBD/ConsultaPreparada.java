package ConectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ConsultaPreparada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		    // 1- Crear conexcion
			
			Connection coneccion=DriverManager.getConnection("jdbc:mysql://localhost:3306/productos","root","root");
		
			// 2- Preparar consulta
			
			PreparedStatement sentencia=coneccion.prepareStatement("select NOMBREARTICULO, SECCION, PAISORIGEN from Productos where SECCION=? and PAISORIGEN=?");
			
			// 3- Establecer parámetros de consulta
			
			sentencia.setString(1, "DEPORTES");
			
			sentencia.setString(2, "USA");
			
			// 4- Ejecutar y recorrer la consulta
			
			ResultSet rs=sentencia.executeQuery();
			
			while (rs.next()) {
				
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
				
			}
			
			rs.close();
			
			System.out.println("\nEjecucion segunda consulta:\n");
			
			sentencia.setString(1, "CONFECCION");
			
			sentencia.setString(2, "ITALIA");
			
			rs=sentencia.executeQuery();
			
			while (rs.next()) {
				
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
