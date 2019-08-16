package aplicacionFinal;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AplicacionUniversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoBBDD mimarco=new MarcoBBDD();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class MarcoBBDD extends JFrame{

	public MarcoBBDD(){
		
		setBounds(300,300,700,700);
		
		LaminaBBDD milamina=new LaminaBBDD();
		
		add(milamina);
		
	}	
	
}

class LaminaBBDD extends JPanel{
	
	public LaminaBBDD(){
		
		setLayout(new BorderLayout());
		
		comboTablas=new JComboBox();
		
		areaInformacion=new JTextArea();
		
		add(areaInformacion,BorderLayout.CENTER);	
		
		conectarBBDD();
		
		obtenerTablas();
		
		comboTablas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nombreTabla = (String) comboTablas.getSelectedItem();
				
				mostrarInfoTabla(nombreTabla);
				
			}
		});
		
		add(comboTablas, BorderLayout.NORTH);

	}
	
	
	public void conectarBBDD() {
		
		conexion=null;
		
		String datos[]=new String[3];
		
		try {
			
			entrada=new FileReader("src/aplicacionFinal/inputdata");
			
			
		} catch (IOException e) {
			
		
		    JFileChooser chooser = new JFileChooser();
		    
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "JPG & GIF Images", "jpg", "gif");
		    
		    chooser.setFileFilter(filter);
		    
		    int returnVal = chooser.showOpenDialog(this);
		    
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
//		       System.out.println("You chose to open this file: " +
//		            chooser.getSelectedFile().getAbsolutePath());
		    	
		    	try {
					entrada=new FileReader(chooser.getSelectedFile().getAbsolutePath());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	
		    	
		    }
		    
		}
		
		
		try {
			
		
			BufferedReader buffer=new BufferedReader(entrada);
			
			for (int i = 0; i <= 2; i++) {
				
				datos[i]=buffer.readLine();
				
			}
			
//			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/productos", "root", "root");
			
			conexion=DriverManager.getConnection(datos[0],datos[1],datos[2]);
			
			entrada.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	} 
		
	
	
	public void obtenerTablas() {
		
		ResultSet rs=null;
		
		try {
			
			DatabaseMetaData datosBBDD=conexion.getMetaData();
			
			rs=datosBBDD.getTables("productos", null, null, null);
			
			while(rs.next()) {
				
				comboTablas.addItem(rs.getString("TABLE_NAME"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}

	
	}
	
	public void mostrarInfoTabla(String tabla) {
		
		// codigo capaz de leer la información que hay dentro de una tabla
	
		ArrayList<String> campos=new ArrayList<String>();
		
		String consulta="select * from " + tabla;
		
		try {
			
			areaInformacion.setText("");
			
			Statement statement=conexion.createStatement();
			
			ResultSet rs=statement.executeQuery(consulta);
			
			ResultSetMetaData rsBBDD=rs.getMetaData();
			
			for (int i = 1; i < rsBBDD.getColumnCount(); i++) {
				
				campos.add(rsBBDD.getColumnLabel(i));
				
			}
			
			while(rs.next()) {
				
				for (String nombreCampo : campos) {
					
					areaInformacion.append(rs.getString(nombreCampo)+" ");
					
				}
				
				areaInformacion.append("\n");
				
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}

	
	private JComboBox comboTablas;

	private JTextArea areaInformacion;
	
	private Connection conexion;
	
	private FileReader entrada;
	
}


		