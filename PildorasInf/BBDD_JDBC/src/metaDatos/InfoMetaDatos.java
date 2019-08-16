package metaDatos;

import java.sql.*;

public class InfoMetaDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		mostrarInfoBBDD();
		mostrarInfoTabla();
		
	}
	
	static void mostrarInfoBBDD() {
		Connection conexion=null; 
		
		try {
			
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/productos", "root", "root");
			
			// obtención de metadatos
			
			DatabaseMetaData datosBBDD=conexion.getMetaData();
			
			// Mostramos la información de BBDD
			
			System.out.println("Gestor de BBDD " + datosBBDD.getDatabaseProductName());
			
			System.out.println("Version del gestor " + datosBBDD.getDatabaseProductVersion());
			
			System.out.println("Nombre del driver " + datosBBDD.getDriverName());
			
			System.out.println("Version del driver " + datosBBDD.getDriverVersion());
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	static void mostrarInfoTabla() {
		
		Connection conexion=null; 
		
		ResultSet rs=null;
		
		try {
			
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/productos", "root", "root");
			
			// obtención de metadatos
			
			DatabaseMetaData datosBBDD=conexion.getMetaData();
			
			// Lista de tablas
			
			System.out.println("Lista de tablas en la BBDD");
			
			rs=datosBBDD.getTables(null, null, null, null);
			
			while(rs.next()) {
				
				System.out.println(rs.getString("TABLE_NAME"));			
				
			}
			
			// Lista de columnas de productos
			
			System.out.println("\n");
			
			System.out.println("Campos de Productos");
			
			rs=datosBBDD.getColumns(null, null, "Productos", null);
			
			while(rs.next()) {
				
				System.out.println(rs.getString("COLUMN_NAME"));			
				
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
