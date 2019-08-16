package ConectaBD;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;



public class Aplicacion_Consulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame mimarco=new Marco_Aplicacion();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class Marco_Aplicacion extends JFrame{
	
	public Marco_Aplicacion(){
		
		setTitle ("Consulta BBDD");
		
		setBounds(500,300,400,400);
		
		setLayout(new BorderLayout());
		
		JPanel menus=new JPanel();
		
		menus.setLayout(new FlowLayout());
		
		secciones=new JComboBox();
		
		secciones.setEditable(false);
		
		secciones.addItem("Todos");
		
		paises=new JComboBox();
		
		paises.setEditable(false);
		
		paises.addItem("Todos");
		
		resultado= new JTextArea(4,50);
		
		resultado.setEditable(false);
		
		add(resultado);
		
		menus.add(secciones);
		
		menus.add(paises);	
		
		add(menus, BorderLayout.NORTH);
		
		add(resultado, BorderLayout.CENTER);
		
		JButton botonConsulta=new JButton("Consulta");
		
		botonConsulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ejecutarConsulta();
				
			}
		});
		
		add(botonConsulta, BorderLayout.SOUTH);
		
		// CONEXIÓN CON BBDD
		
		try {
		
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/productos","root","root");
		
			Statement sentencia=conexion.createStatement();
			
			String consulta="select distinctrow SECCION from Productos";
			
			ResultSet rs=sentencia.executeQuery(consulta);
			
			while (rs.next()) {
				
				secciones.addItem(rs.getString(1));
				
			}
			
			rs.close();
			
			consulta="select distinctrow PAISORIGEN from Productos";
			
			rs=sentencia.executeQuery(consulta);
			
			while (rs.next()) {
				
				paises.addItem(rs.getString(1));
				
			}
			
			rs.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		
		}
		
	}
	
	// encapsulado para que no sea accesible desde afuera
	private void ejecutarConsulta() {
		
		ResultSet rs=null;
		
		 try {
			
			 resultado.setText("");
			 
			 String seccion=(String) secciones.getSelectedItem();
		
			 String pais=(String) paises.getSelectedItem();
			 
			 if (!seccion.equals("Todos") && pais.equals("Todos")) {
				 
				 enviaConsultaSeccion=conexion.prepareStatement(consultaSeccion);
				 
				 enviaConsultaSeccion.setString(1, seccion);
				 
				 rs=enviaConsultaSeccion.executeQuery();
				 
			 } else if (seccion.equals("Todos") && !pais.equals("Todos")) {
				 
				 enviaConsultaPais=conexion.prepareStatement(consultaPais);
				 
				 enviaConsultaPais.setString(1, pais);
				 
				 rs=enviaConsultaPais.executeQuery();
				 
			 } else if (!seccion.equals("Todos") && !pais.equals("Todos")) {
				 
				 enviaConsultaTodos=conexion.prepareStatement(consultaTodos);
				 
				 enviaConsultaTodos.setString(1, seccion);
				 
				 enviaConsultaTodos.setString(2, pais);
				 
				 rs=enviaConsultaTodos.executeQuery();
				 
			 }
			 
			 while (rs.next()) {
				
				 resultado.append(rs.getString(1));
				 
				 resultado.append(", ");
				 
				 resultado.append(rs.getString(2));
				 
				 resultado.append(", ");
				 
				 resultado.append(rs.getString(3));
				 
				 resultado.append(", ");
				 
				 resultado.append(rs.getString(4));
				 
				 resultado.append("\n");
				 
			}
		
		 } catch (Exception e) {
			 e.printStackTrace();
		}
		
		 
		 
	}
		
	private PreparedStatement enviaConsultaSeccion;
	
	private PreparedStatement enviaConsultaPais;
	
	private PreparedStatement enviaConsultaTodos;
	
	private final String  consultaSeccion="select NOMBREARTICULO, SECCION, PRECIO, PAISORIGEN from Productos where SECCION=?";
	
	private final String  consultaPais="select NOMBREARTICULO, SECCION, PRECIO, PAISORIGEN from Productos where PAISORIGEN=?";
	
	private final String  consultaTodos="select NOMBREARTICULO, SECCION, PRECIO, PAISORIGEN from Productos where SECCION=? and PAISORIGEN=?";
	
	private Connection conexion;
	
	private JComboBox secciones;
	
	private JComboBox paises;
	
	private JTextArea resultado;	
	

	
}

