package com.jey.productos;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.lang.*;

import javax.sql.DataSource;

public class ModeloProductos {

	private DataSource origenDatos;
	
	public ModeloProductos(DataSource origenDatos) {
		this.origenDatos=origenDatos;
	}
	
	public List<Producto> getProductos() throws Exception{
		
		List<Producto> productos=new ArrayList<>();
		
		Connection conexion=null;
		
		Statement statement=null;
		
		ResultSet rs=null;
		
		// Establecer la conexión
		
		conexion=origenDatos.getConnection();
		
		// Crear sentencia
		
		String sentencia="select * from Productos";
		
		statement=conexion.createStatement();
		
		// Ejecutar consulta
		
		rs=statement.executeQuery(sentencia);
		
		// Recorrer result set
		
		while(rs.next()) {
			
			String c_art=rs.getString("CODIGOARTICULO");
			String seccion=rs.getString("SECCION");
			String n_art=rs.getString("NOMBREARTICULO");
			double precio=rs.getDouble("PRECIO");
			Date fecha=rs.getDate("FECHA");
			String importado=rs.getString("IMPORTADO");
			String pOrigen=rs.getString("PAISORIGEN");
			
			Producto productoTemporal=new Producto(c_art, seccion, n_art, precio, fecha, importado, pOrigen);
			
			productos.add(productoTemporal);
			
		}
		
		return productos;
	}

	public void agregarElNuevoProducto(Producto nuevoProducto) throws Exception {
		
		// Obtener la conexión con la base
		
		Connection conexion=null;
		
		PreparedStatement statement=null;
		
		try {
			
			conexion=origenDatos.getConnection();
			
			// Crear instruccion SQL
			
			String updateBBDD="insert into Productos (CODIGOARTICULO,SECCION,NOMBREARTICULO,PRECIO,FECHA,IMPORTADO,PAISORIGEN)"+
			"values(?,?,?,?,?,?,?)";
			
			statement=conexion.prepareStatement(updateBBDD);
			
			// Establecer los parámetros para el producto
			
			statement.setString(1,nuevoProducto.getCodigoArticulo());
			
			statement.setString(2,nuevoProducto.getSeccion());
			
			statement.setString(3,nuevoProducto.getNombreArticulo());
			
			statement.setDouble(4,nuevoProducto.getPrecio());
			
			// Convertir a un tipo DATE de SQL - que solo devuelve la fecha
			
			java.util.Date utilDate=nuevoProducto.getFecha();
			
			java.sql.Date fechaConvertida=new java.sql.Date(utilDate.getTime());
			
			statement.setDate(5, fechaConvertida);
			
			statement.setString(6,nuevoProducto.getImportado());
			
			statement.setString(7,nuevoProducto.getPaisOrigen());
			
			// Ejecutar instruccion
		
			statement.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
			statement.close();
			
			conexion.close();
			
		}
	}

	public Producto getProducto(String codSeleccionado) throws Exception {
		
		Producto prod=null;
		
		Connection conexion=null;
		
		PreparedStatement statement=null;
		
		ResultSet rs=null;
		
		String cArt=codSeleccionado;
		
		
		
		try {
			
			// Establece conexión
			
			conexion=origenDatos.getConnection();
		
			// Crear consulta búsqueda
			
			String sql="select * from Productos where CODIGOARTICULO=?";
		
			// Consulta preparada
					
			statement=conexion.prepareStatement(sql);
		
			// Parámetros
			
			statement.setString(1, cArt);
		
			// Ejecuta consulta
			
			rs=statement.executeQuery();
		
			// Obtener rta
			
			if(rs.next()) {

				String c_art=rs.getString("CODIGOARTICULO");
				String seccion=rs.getString("SECCION");
				String n_art=rs.getString("NOMBREARTICULO");
				double precio=rs.getDouble("PRECIO");
				Date fecha=rs.getDate("FECHA");
				String importado=rs.getString("IMPORTADO");
				String pOrigen=rs.getString("PAISORIGEN");
				
				prod=new Producto(c_art, seccion, n_art, precio, fecha, importado, pOrigen);

			} else {
				
				throw new Exception("No se encontró producto con código artículo: " + codSeleccionado);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}	
		
		return prod;
	}

	public void actualizarProducto(Producto productoActualizado) throws Exception {
		
		Connection conexion=null;
		
		PreparedStatement statement=null; 
		
		
		
		// Establece conexión con la base
		try {
			conexion=origenDatos.getConnection();
			
			// Crear sentencia SQL
			
			String updateSQL = "update Productos set SECCION=?, NOMBREARTICULO=?, PRECIO=?, FECHA=?, IMPORTADO=?, PAISORIGEN=? where CODIGOARTICULO=?";
			
			// Crear consulta preparada
			
			statement = conexion.prepareStatement(updateSQL);
			
			// Establecer parametros
			
			statement.setString(1, productoActualizado.getSeccion());
			
			statement.setString(2, productoActualizado.getNombreArticulo());
			
			statement.setDouble(3, productoActualizado.getPrecio());
			
			java.util.Date utilDate=productoActualizado.getFecha();
			
			java.sql.Date fechaConvertida=new java.sql.Date(utilDate.getTime());
					
			statement.setDate(4, fechaConvertida);
			
			statement.setString(5, productoActualizado.getImportado());
			
			statement.setString(6, productoActualizado.getPaisOrigen());
	
			statement.setString(7, productoActualizado.getCodigoArticulo());
			
			// ejecutar instruccion
			
			statement.execute();
		} finally {
			
			statement.close();
			
			conexion.close();
			
		}
		
	}

	public void eliminarProducto(String codArticulo) throws Exception {
		// Establecer conexión
		
		Connection conexion=null;
		
		PreparedStatement statement=null; 
		
		try {
			conexion=origenDatos.getConnection();
			
			// Crear instruccion eliminación
			
			String deleteSQL="delete from Productos where CODIGOARTICULO=?";
			
			// Preparar consulta
			
			statement = conexion.prepareStatement(deleteSQL);
			
			// Establecer parámetros
			
			statement.setString(1, codArticulo);
			
			// Ejecutar sentencia
			
			statement.execute();
		} finally {
			
			statement.close();
			
			conexion.close();
			
		}
	}
	
}
