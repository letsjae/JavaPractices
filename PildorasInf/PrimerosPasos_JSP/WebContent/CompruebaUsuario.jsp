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

	String usuario=request.getParameter("usuario");
	
	String contra=request.getParameter("contra");
	
	Class.forName("com.mysql.jdbc.Driver");
	
	try {
	
		Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_JSP","root","root");

		PreparedStatement c_preparada=conexion.prepareStatement("select * from usuarios where USUARIO=? and CONTRASEÑA=?");
		
		c_preparada.setString(1, usuario); 
		
		c_preparada.setString(2, contra);
		
		ResultSet rs=c_preparada.executeQuery();
		
		if(rs.absolute(1)) out.print("Usuario autorizado");
		
		else out.print("No existe usuario");
		
	} catch (Exception e){
		
		out.print("Hubo un error al acceder a la base");
		
		e.printStackTrace();
		
	}
%>

</body>
</html>