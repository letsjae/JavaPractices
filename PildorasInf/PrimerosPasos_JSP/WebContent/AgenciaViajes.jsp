<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1 style="text-align: center"> Agencia de viajes</h1>

<%

	// Valor por defecto
	
	String ciudadFavorita="Buenos Aires";

	// Lectura de cookie de la petición del navegador
	
	Cookie[] cookiesUsuario=request.getCookies();
	
	// Buscar las preferencias - ciudad favorita
	
	if(cookiesUsuario!=null){
		
		for(Cookie temp: cookiesUsuario){
			
			if("AgenciaViajes.ciudadFavorita".equals(temp.getName())){
				
				ciudadFavorita=temp.getValue();
				
				break;
				
			}
			
		}
		
	}
%>

<h3>Vuelos a: <%= ciudadFavorita %></h3>

<p> Texto ejemplo </p>
<p> Texto ejemplo </p>
<p> Texto ejemplo </p>
<p> Texto ejemplo </p>
<p> Texto ejemplo </p>

<h3>Hoteles en: <%= ciudadFavorita %></h3>

<p> Texto ejemplo </p>
<p> Texto ejemplo </p>
<p> Texto ejemplo </p>
<p> Texto ejemplo </p>
<p> Texto ejemplo </p>

<h3>Descuentos en restaurantes en: <%= ciudadFavorita %></h3>

<p> Texto ejemplo </p>
<p> Texto ejemplo </p>
<p> Texto ejemplo </p>
<p> Texto ejemplo </p>
<p> Texto ejemplo </p>


</body>
</html>