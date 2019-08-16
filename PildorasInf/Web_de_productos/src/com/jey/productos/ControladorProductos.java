package com.jey.productos;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorProductos
 */
@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet {
	
	// Lo principal que tiene que hacer es comunicarse con el modelo para intercambiar información
	
	private static final long serialVersionUID = 1L;

	private ModeloProductos modeloProductos;
	
	@Resource(name="jdbc/Productos")
	
	private DataSource pool;
	
	// método desde el cual arranca la aplicacion
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			
			modeloProductos=new ModeloProductos(pool);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			throw new ServletException();
			
		}
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Leer el parámetro que le llega desde el formulario
		
		String comando=request.getParameter("instruccion");
		
		// si no se envía el parámetro, listar productos
		
		if (comando==null) comando="listar";
		
		// Redirigir el flujo de ejecución
		switch(comando) {
		
		case "listar":
		
			obtenerProductos(request,response);
			
			break;
		
		case "insertarBBDD":
		
			agregarProductos(request,response);
			
			break;
			
		case "cargar":
			
			try {
				
				cargarProductos(request,response);
			
			} catch (Exception e) {
			
				e.printStackTrace();
			
			}
			
			break;
			
		case "actualizarBBDD":
			
			try {
				
				actualizaProducto(request, response);
			
			} catch (Exception e) {
			
				e.printStackTrace();

			}
			
			break;
			
		case "eliminar":
			
			try {
				
				eliminarProducto(request, response);
			
			} catch (Exception e) {
			
				e.printStackTrace();

			}
			
			break;
			
		default:
			
			obtenerProductos(request,response);
		
		}
		
		
		

	}


	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// Capturar el codigo articulo, el campo clave
		String codArticulo=request.getParameter("codArticulo");
		
		// Borrar productos de la BBDD
		modeloProductos.eliminarProducto(codArticulo);
		
		// Volver a la lista de productos
		obtenerProductos(request, response);
		
		
	}


	private void actualizaProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// Leer los datos que le vienen del formulario
		
		String codArticulo=request.getParameter("CArt");
		
		String seccion=request.getParameter("seccion");
		
		String nombreArticulo=request.getParameter("NArt");
		
		SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
		
		Date fecha=null;
		
		try {
		
			fecha=formatoFecha.parse(request.getParameter("fecha"));

		} catch (ParseException e) {
			
			e.printStackTrace();
			
		}
		
		double precio=Double.parseDouble(request.getParameter("precio"));
		
		String importado=request.getParameter("importado");
		
		String paisOrigen=request.getParameter("POrig");
		
		// Crear un objeto Producto con la info del formulario
		
		Producto productoActualizado= new Producto(codArticulo, seccion, nombreArticulo, precio, fecha, importado, paisOrigen);
		
		// Actualizar BBDD
		
		modeloProductos.actualizarProducto(productoActualizado);
		
		// Volver al listado
		
		obtenerProductos(request, response);
	}


	private void cargarProductos(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// Leer el códifo artículo que viene del listado
		
		String codSeleccionado=request.getParameter("codArticulo");
		
		// Comunicar con el modelo para que haga una consulta a la base con ese producto
		// Enviar código artículo a modelo
		
		Producto prodSeleccionado=modeloProductos.getProducto(codSeleccionado);
		
		// Colocar atributo correspondiente al código artículo
		
		request.setAttribute("ProductoActualizado", prodSeleccionado);
		
		// Enviar la info al formulario de ACTUALIZAR
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/actualizarProducto.jsp");
		
		dispatcher.forward(request, response);
		
	}


	private void agregarProductos(HttpServletRequest request, HttpServletResponse response) {
		
		// Leer la informacion del producto que viene del formulario
		
		String codArticulo=request.getParameter("CArt");
		
		String seccion=request.getParameter("seccion");
		
		String nombreArticulo=request.getParameter("NArt");
		
		SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
		
		Date fecha=null;
		
		try {
		
			fecha=formatoFecha.parse(request.getParameter("fecha"));

		} catch (ParseException e) {
			
			e.printStackTrace();
			
		}
		
		double precio=Double.parseDouble(request.getParameter("precio"));
		
		String importado=request.getParameter("importado");
		
		String paisOrigen=request.getParameter("POrig");
		
		// Crear un objeto del tipo producto
		
		Producto nuevoProducto= new Producto(codArticulo, seccion, nombreArticulo, precio, fecha, importado, paisOrigen);
		
		// Enviar el objeto al modelo y dsp insertar el objeto producto en la base
		
		try {
			modeloProductos.agregarElNuevoProducto(nuevoProducto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Volver al listado de productos
		
		obtenerProductos(request, response);
		
	}


	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
		
		// Obtener la lista de productos desde el modelo
		
		List<Producto> productos;
		
		try {
			
			// Almacenamos lo que devuelve el modelo
			
			productos=modeloProductos.getProductos();
		
			// Agregar la lista obtenida al request
			
			request.setAttribute("ListaProductos", productos);
			
			// Enviar ese request a la página JSP
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("/ListaProductos.jsp");
			
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

}
