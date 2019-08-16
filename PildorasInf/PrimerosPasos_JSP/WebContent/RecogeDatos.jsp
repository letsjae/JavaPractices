<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

	String nombre=request.getParameter("nombre");

	String apellido=request.getParameter("apellido");
	
	String usuario=request.getParameter("usuario");
	
	String contra=request.getParameter("contra");
	
	String pais=request.getParameter("pais");
	
	String tecnologías=request.getParameter("tecnologías");
	
	Class.forName("com.mysql.jdbc.Driver");
	
	try {
	
		Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_JSP","root","root");
	
		Statement statement=conexion.createStatement();
		
		// Instruccion que se encargará de llevar los datos a la BBDD
		
		String instruccionSQL="insert into usuarios (NOMBRE, APELLIDO, USUARIO, CONTRASEÑA, PAIS, TECNOLOGIA) values ('"+ nombre +"','"+ apellido +"','"+ usuario +"','"+ contra +"','"+ pais +"', "+ tecnologías +")"; 
		
		statement.executeUpdate(instruccionSQL);
		
		out.print("Usuario registrado con éxito");
	
	} catch (Exception e){
		
		out.print("Hubo un error al acceder a la base");
		
		e.printStackTrace();
		
	}
%>

</body>
</html>