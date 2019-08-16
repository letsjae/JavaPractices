<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="java.util.*" %>
<html>

<body>
<form name="Formulario_Compra" action="ListaCompra.jsp">
 
  <p>Artículos a comprar:</p>
  <p>
    <label>
      <input type="checkbox" name="articulos" value="agua " >
      Agua </label>
    <br>
    <label>
      <input type="checkbox" name="articulos" value="leche" >
      Leche </label>
    <br>
     <label>
      <input type="checkbox" name="articulos" value="pan" >
      Pan </label>
    <br>
     <label>
      <input type="checkbox" name="articulos" value="mazanas" >
      Manzanas </label>
    <br>
     <label>
      <input type="checkbox" name="articulos" value="carne" >
      Carne </label>
      <br>
       <label>
      <input type="checkbox" name="articulos" value="pescado" >
      Pescado </label>
  </p>
  <p>
    <input type="submit" name="button" id="button" value="Enviar">
    <br>
  </p>
</form>

<h2>Carrito de compra</h2>

<ul>
<%

	// Al entrar por primera vez desp de cargar el formulario
	// se leería ésta línea:
	// Como aun no hay nada cargado, se cumple que es null	
	List<String> listaCompra=(List<String>)session.getAttribute("ListaCompras");
	
	if(listaCompra == null){
		
		listaCompra=new ArrayList<String>();
		
		session.setAttribute("ListaCompras", listaCompra);
		
	}
	
	String[] elementos=request.getParameterValues("articulos");

	if(elementos!=null){
		
		for(String elem: elementos){
			
			listaCompra.add(elem);
			
		}
		
	}
	
	for(String elem: listaCompra){
		
		out.println("<li>" + elem + "</li>");
		
	}
	
%>

</ul>

</body>
</html>