<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.*, java.sql.*, jey.com.jspTags.Empleado" %>

<%
	ArrayList<Empleado> empleadosEnBase=new ArrayList<>();
	
	Class.forName("com.mysql.cj.jdbc.Driver");

	try{
		
		Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_JSP","root","root");
		
		Statement statement=conexion.createStatement();
		
		String consulta="select * from empleados";
		
		ResultSet rs=statement.executeQuery(consulta);
		
		while(rs.next()){
			
			empleadosEnBase.add(new Empleado( rs.getString(1), rs.getString(3), rs.getString(4), rs.getDouble(5)));
			
		}
		
		rs.close();
		
		conexion.close();
		
	} catch(Exception e){
		e.printStackTrace();
	}
	
	pageContext.setAttribute("empleados", empleadosEnBase);
	
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
	.cabecera{
		font-weight:bold;
	}
</style>

</head>
<body>

<table border="1">

<tr class="cabecera"><td>Nombre</td><td>Apellido</td><td>Puesto</td><td>Salario con el bonus aplicado</td><td>Bonus</td></tr>
	
	<c:forEach var="empTemp" items="${ empleados }">
		<tr>
			<td>${ empTemp.nombre}</td><td>${ empTemp.apellido }</td><td>${ empTemp.puesto }</td>
			
			<td> 

				<c:choose>
					<c:when test="${empTemp.salario<40000}"> ${ empTemp.salario + 5000}</c:when>
				
					<c:when test="${empTemp.salario>40000 && empTemp.salario<=50000}"> ${ empTemp.salario + 2000}</c:when>
				
					<c:otherwise>${ empTemp.salario}</c:otherwise>
				
				</c:choose>

			</td>
			
			<td>
			
				<c:if test="${empTemp.salario<40000}">5000</c:if>
				
				<c:if test="${empTemp.salario>40000 && empTemp.salario<=50000}">No aplica</c:if>
				
			</td>
		</tr>
	</c:forEach>
	
</table>	
	
</body>
</html>