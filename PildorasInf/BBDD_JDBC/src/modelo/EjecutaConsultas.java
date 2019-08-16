package modelo;

import java.sql.*;

public class EjecutaConsultas {
	
	public EjecutaConsultas() {
		
		conexion=new Conexion();
	}
	
	public ResultSet filtraBBDD(String seccion, String pais) {
		
		Connection conecta=conexion.getConnection();
		
		rs=null;
		
		try {
			
			if(!seccion.equals("Todos") && pais.equals("Todos")) {
				
				enviaConsultaSeccion=conecta.prepareStatement(consultaSeccion);
				
				enviaConsultaSeccion.setString(1, seccion);
			
				rs=enviaConsultaSeccion.executeQuery();
				
				
				
			} else if(seccion.equals("Todos") && !pais.equals("Todos")) {
				
				enviaConsultaPais=conecta.prepareStatement(consultaPais);
				
				enviaConsultaPais.setString(1, pais);
			
				rs=enviaConsultaPais.executeQuery();
				
			} else {
				
				enviaConsultaTodos=conecta.prepareStatement(consultaTodos);
				
				enviaConsultaTodos.setString(1, seccion);
				
				enviaConsultaTodos.setString(2, pais);
			
				rs=enviaConsultaTodos.executeQuery();
				
			}
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		
		return rs;
		

	}
	
	private Conexion conexion;
	
	private ResultSet rs;
	
	private PreparedStatement enviaConsultaSeccion;
	
	private PreparedStatement enviaConsultaPais;
	
	private PreparedStatement enviaConsultaTodos;
	
	private final String consultaSeccion="select NOMBREARTICULO, SECCION, PRECIO, PAISORIGEN from Productos where SECCION=?";
	
	private final String consultaPais="select NOMBREARTICULO, SECCION, PRECIO, PAISORIGEN from Productos where PAISORIGEN=?";
	
	private final String consultaTodos="select NOMBREARTICULO, SECCION, PRECIO, PAISORIGEN from Productos where SECCION=? and PAISORIGEN=?";
	
}
