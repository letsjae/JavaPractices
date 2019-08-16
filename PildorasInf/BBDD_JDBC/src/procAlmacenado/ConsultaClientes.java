package procAlmacenado;

import java.sql.*;

public class ConsultaClientes {

	public static void main(String[] args) {
		
		try {
			
			Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/productos","root","root");
			
			CallableStatement sentencia=conexion.prepareCall("{call MUESTRA_CLIENTE}");
			
			ResultSet rs=sentencia.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
