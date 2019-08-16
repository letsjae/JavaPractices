package swingAvanzado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.sql.*;

public class TablaProductos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame marco=new MarcoProductos();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
	}

}

class MarcoProductos extends JFrame{
	
	public MarcoProductos() {
		
		setTitle("Productos");
		
		setBounds(500, 300, 800, 400);
		
		JPanel superior=new JPanel();
		
		nombresDeTablas=new JComboBox(); 
		
		try {
			
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/productos", "root", "root");
			
			datosBBDD=conexion.getMetaData();
			
			rs=datosBBDD.getTables("productos", null, null, null);
			
			while(rs.next()) {
				
				nombresDeTablas.addItem(rs.getString("TABLE_NAME"));
			}
			
		} catch (Exception e) {
			
		}
		
		nombresDeTablas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String tablaSeleccionada=(String)nombresDeTablas.getSelectedItem();
				
				String consulta="select * from " + tablaSeleccionada;
				
				try {
				
				sentencia=conexion.createStatement();
				
				rs=sentencia.executeQuery(consulta);
				
//				while(rs.next()) {
//					
//					System.out.println(rs.getString("NOMBREARTICULO"));
//					
//				}
				
				modelo=new ResultSetModeloTabla(rs);
				
				JTable tabla=new JTable(modelo);
				
				add(new JScrollPane(tabla), BorderLayout.CENTER);
				
				validate();
				
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				
			}
		});
		
		superior.add(nombresDeTablas);
		
		add(superior, BorderLayout.NORTH);

	}
	
	private JComboBox nombresDeTablas;
	
	private DatabaseMetaData datosBBDD;
	
	private ResultSet rs=null;
	
	private Connection conexion;
	
	private Statement sentencia; 
	
	private ResultSetModeloTabla modelo;
	
}


class ResultSetModeloTabla extends AbstractTableModel {

	public ResultSetModeloTabla(ResultSet rs) {
		this.rsRegistros=rs;	
		
		try {
			rsmd=rsRegistros.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int getColumnCount() {
		try {
			
			return rsmd.getColumnCount();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return 0;
		}
	}

	@Override
	public int getRowCount() {
		
		try {
			// El cursor se va al final
			rsRegistros.last();
			
			return rsRegistros.getRow();
			
		} catch (SQLException e) {

			e.printStackTrace();
			
			return 0;
		}
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		System.out.println(arg0);
		
		try {
			// Moves the cursor to the given row number in this ResultSet object.
			rsRegistros.absolute(arg0 + 1);
			
			return rsRegistros.getObject(arg1 + 1);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return null;
			
		}
	}
	
	public String getColumnName(int c) {
		
		try {
			
			return rsmd.getColumnName(c+1);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return null;
		}
		
	}
	
	private ResultSet rsRegistros;
	
	private ResultSetMetaData rsmd;
}
















