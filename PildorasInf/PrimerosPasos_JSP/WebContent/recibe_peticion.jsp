<%@page import="java.net.*"%>
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

	// Leyendo datos del formulario

	String ciudadFavorita=request.getParameter("ciudad_favorita");

	// Creación de cookie
	Cookie cookieUsuario=new Cookie("AgenciaViajes.ciudadFavorita", URLEncoder.encode( ciudadFavorita, "UTF-16" ) );

	// Se establece la durabilidad de la cookie
	
	cookieUsuario.setMaxAge(365*24*60*60); // un año según cálculo del parámetro
	
	response.addCookie(cookieUsuario);
	
%>

Gracias por enviar sus preferencias

<a href="AgenciaViajes.jsp"> Ir a la agencia de viajes </a>

</body>
</html>