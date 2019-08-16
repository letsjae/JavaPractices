package jey.com.Calculadora;

public class Calculos {
	
	static private int resultado;

	static public int metodoSuma(int num1, int num2){
		
		resultado=num1+num2;
		
		return resultado;
		
	}

	static public int metodoResta(int num1, int num2){
		
		resultado=num1-num2;
		
		return resultado;
		
	}

	static public int metodoMultiplica(int num1, int num2){
		
		resultado=num1*num2;
		
		return resultado;
		
	}

}
