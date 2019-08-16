<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/estilos/miEstilo.css">
</head>
<body>

	Hola! ${ param.nombreAlumno }. Bienvenido al mundo!
	
	<p><br>
	
	<h2> Atención! </h2>

	${ msjResultante }
	
	</p>	
			
	<img alt="paisaje" src="${pageContext.request.contextPath}/recursos/imgs/paisaje.jpg">

</body>
</html>