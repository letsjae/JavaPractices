<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1 style="text-align: center"> Actualizar Producto </h1>
	<form name="FormularioNuevoRegistro" method="get" action="ControladorProductos">
	<input type="hidden" name="instruccion" value="actualizarBBDD">
	<input type="hidden" name="CArt" value="${ProductoActualizado.codigoArticulo} ">
	
    	<table width="501" border="0">
			
			<tr>
				<td>Sección</td>
				<td><label for="seccion"></label>
				<input type="text" name="seccion" id="seccion" value="${ProductoActualizado.seccion}"></td>			
			</tr>
			<tr>
				<td>Nombre del Artículo</td>
				<td><label for="NArt"></label>
				<input type="text" name="NArt" id="NArt" value="${ProductoActualizado.nombreArticulo}"></td>			
			</tr>
			<tr>
				<td>Fecha</td>
				<td><label for="fecha"></label>
				<input type="text" name="fecha" id="fecha" value="${ProductoActualizado.fecha}"></td>			
			</tr>
			<tr>
				<td>Precio</td>
				<td><label for="precio"></label>
				<input type="text" name="precio" id="precio" value="${ProductoActualizado.precio}"></td>			
			</tr>
			<tr>
				<td>Importado</td>
				<td><label for="importado"></label>
				<input type="text" name="importado" id="importado" value="${ProductoActualizado.importado}"></td>			
			</tr>			
			<tr>
				<td>País de Origen</td>
				<td><label for="POrig"></label>
				<input type="text" name="POrig" id="POrig" value="${ProductoActualizado.paisOrigen}"></td>			
			</tr>				
			<tr>
				<td><input type="submit" name="envio" id="envio" value="Actualizar Registro"></td>
				
			</tr>
	    </table>
</form>

</body>
</html>