package procAlmacenado;

import java.sql.*;

import javax.swing.JOptionPane;

public class ActualizaProductos {

	public static void main(String[] args) {
		
		double n_precio=Double.parseDouble(JOptionPane.showInputDialog("Introducir nuevo precio:"));
		
		String articulo=JOptionPane.showInputDialog("Introduce nombre artículo");
		
		try {
			
			Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/productos","root","root");
			
			CallableStatement sentencia=conexion.prepareCall("{call ACTUALIZA_PROC(?, ?)}");
			
			 sentencia.setDouble(1, n_precio);
			 
			 sentencia.setString(2, articulo);
			
			 sentencia.execute();			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
