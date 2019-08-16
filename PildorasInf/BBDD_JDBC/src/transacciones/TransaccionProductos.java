package transacciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class TransaccionProductos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection miConexion=null;
		
		try{					
				
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/productos", "root", "root");				
			
			miConexion.setAutoCommit(false);
			
			Statement miStatement =miConexion.createStatement();
			
		    String instruccionSql_1="delete from Productos where PAISORIGEN='ITALIA'";
			    
		    String instruccionSql_2="delete from Productos where PRECIO>300";
		    
		    String instruccionSql_3="update Productos set PRECIO=PRECIO*1.15";
		    
		    boolean ejecutar=ejecutarTransaccion();
		    
		    if (ejecutar) {
		    	
		    	miStatement.executeUpdate(instruccionSql_1);
			
		    	miStatement.executeUpdate(instruccionSql_2);
		    	
		    	miStatement.executeUpdate(instruccionSql_3);
		    	
		    	miConexion.commit();
		    	
		    	System.out.println("Se ejecutó la transacción correctamente");
		    	
		    } else {
		    	
		    	System.out.println("No se realizó cambio alguno en la BBDD");
		    	
			}
			    
		    
		} catch(Exception e) {
			
			try {
				miConexion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println("Algo salió mal, sin cambios en BBDD");
			
		}
	}
	
	
	static boolean ejecutarTransaccion() {
		
		String ejecucion=JOptionPane.showInputDialog("Ejecutamos la transacción?");
		
		if(ejecucion.equals("Y")) return true;
		else return false;
		
	}
	
	
	
	
	
	
	
	
	
	

}
