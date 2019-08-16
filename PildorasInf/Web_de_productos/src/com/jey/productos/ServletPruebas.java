package com.jey.productos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;

/**
 * Servlet implementation class ServletPruebas
 */
@WebServlet("/ServletPruebas")
public class ServletPruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// Definir o establecer el data source
	
	@Resource(name="jdbc/Productos")
	
	private DataSource pool;
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPruebas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter salida=response.getWriter();
		
		response.setContentType("text/plain");
		
		// Crear conexión base de datos
		
		Connection conexion=null;
		
		Statement statement=null;
		
		ResultSet rs=null;
		
		try {
			
			// Usamos el pool de conexiones para conectar con la base
			conexion=pool.getConnection();
			
			String consulta="select * from Productos";
			
			statement=conexion.createStatement();
			
			rs=statement.executeQuery(consulta);
			
			while(rs.next()) {
				
				String nombreArt=rs.getString(3);
				
				salida.println(nombreArt);
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
