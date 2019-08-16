<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*, com.jey.productos.*" %>    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

	.cabecera{
		font-size: 1.2em;
		font-weight: bold;
		color: #FFFFFF;
		background-color: #08088A;
	}
	
	.filas{
		text-align: center;
		background-color: #5882FA;
	}
	
table {

	float:left;
	
}

#contenedorBoton{

	margin-left:1000px;

}
	
</style>

</head>

<body>

	<table>
		<tr>
			<td class="cabecera">Código Artículo</td>
			<td class="cabecera">Sección</td>
			<td class="cabecera">Nombre Artículo</td>
			<td class="cabecera">Precio</td>
			<td class="cabecera">Fecha</td>
			<td class="cabecera">Importado</td>
			<td class="cabecera">País Origen</td>
		    <td class="cabecera">Acción</td>
		</tr>
		
		<c:forEach var="temprod" items="${ ListaProductos }">
			
			<!-- Link para cada producto con su campo clave -->
			
			<c:url var="linkTemp" value="ControladorProductos">
			
				<c:param name="instruccion" value="cargar"></c:param>
				<c:param name="codArticulo" value="${ temprod.codigoArticulo }"></c:param>
				
			</c:url>
			
			<!-- Link para eliminar cada producto con su campo clave -->
			
			<c:url var="linkEliminar" value="ControladorProductos">
			
				<c:param name="instruccion" value="eliminar"></c:param>
				<c:param name="codArticulo" value="${ temprod.codigoArticulo }"></c:param>
				
			</c:url>
			
			<tr>
				<td class="filas"> ${ temprod.codigoArticulo }</td>
				<td class="filas"> ${ temprod.seccion }</td>
				<td class="filas"> ${ temprod.nombreArticulo }</td>
				<td class="filas"> ${ temprod.precio }</td>
				<td class="filas"> ${ temprod.fecha }</td>
				<td class="filas"> ${ temprod.importado }</td>
				<td class="filas"> ${ temprod.paisOrigen }</td>
				<td class="filas"> <a href="${ linkTemp }"> Actualizar </a>&nbsp;&nbsp;<a href="${ linkEliminar }"> Eliminar </a> </td>
				
			
			</tr>
		
		</c:forEach>
		
	</table>
	
	<div id="contenedorBoton">
	
		<input type="button" value="Insertar nuevo registro" onclick="window.location.href='insertaProducto.jsp'"> 
	
	</div>

</body>
</html>