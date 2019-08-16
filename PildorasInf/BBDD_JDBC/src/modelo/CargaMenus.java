package modelo;

import java.sql.*;

import controlador.*;

public class CargaMenus {
	
	public CargaMenus() {
		
		conexion=new Conexion();
		
	}
	
	public String ejecutaConsultas() {
		
		Productos producto=null;
		
		Connection accesoBBDD=conexion.getConnection();
		
		try {
			Statement secciones=accesoBBDD.createStatement();
			
			Statement paises=accesoBBDD.createStatement();
			
			rs=secciones.executeQuery("select distinctrow SECCION from Productos");
			
			rs2=paises.executeQuery("select distinctrow PAISORIGEN from Productos");
			
//			while(rs.next()) {
				
				rs.previous(); // Volver el cursor una posición hacia atrás
				
// Concepto o regla a seguir en MVC: los datos del modelo deben estar encapsulados,
// por eso crea la clase, pero podemos presindir de su uso.
			
			producto=new Productos();
				
			producto.setSeccion(rs.getString(1));
			
			producto.setpOrigen(rs2.getString(1));			
				
//				return producto.getSeccion();
//			}
			
			rs.close();
			
			rs2.close();
			
			accesoBBDD.close();
			
		} catch (Exception e) {
			
		}
		
		return producto.getSeccion();
	}
	
//	public ResultSet ejecutaConsultas() {
//		
//		Connection accesoBBDD=conexion.getConnection();
//		
//		try {
//			
//			Statement secciones=accesoBBDD.createStatement();
//			
//			return rs=secciones.executeQuery("select distinctrow SECCION from Productos");
//			
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//			
//		}
//		
//		return null;
//		
//	}
	
	
	
	public Conexion conexion;
	
	public ResultSet rs, rs2;
	
	
}
