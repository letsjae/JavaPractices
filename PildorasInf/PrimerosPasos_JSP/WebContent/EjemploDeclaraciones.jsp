<html>
<body>

<h1 style="text-align: center"> 

Ejemplo declaraciones

</h1>

<%!

private int resultado;

public int metodoSuma(int num1, int num2){
	
	resultado=num1+num2;
	
	return resultado;
	
}

public int metodoResta(int num1, int num2){
	
	resultado=num1-num2;
	
	return resultado;
	
}

public int metodoMultiplica(int num1, int num2){
	
	resultado=num1*num2;
	
	return resultado;
	
}

%>


El resultado de sumar 15 y 30 es: <%= metodoSuma(15, 30) %>

<br> 

El resultado de restar 30 y 15 es: <%= metodoResta(30, 15) %>

<br>

El resultado de multiplicar 30 y 15 es: <%= metodoMultiplica(30, 15) %>

</body>
</html>