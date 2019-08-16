
/*
	
	Write a short program that prints each number from 1 to 100 on a new line. 
	
	For each multiple of 3, print "Fizz" instead of the number. 
	
	For each multiple of 5, print "Buzz" instead of the number. 
	
	For numbers which are multiples of both 3 and 5, print "FizzBuzz" instead of the number.

*/


public class FizzBuzz {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1; i<=100; i++) {
			if (i%3==0) 
				System.out.print("Fizz");
			if (i%5==0) 
				System.out.print("Buzz");
			else if (i%3!=0) 
				System.out.println(i);
			System.out.println();
		}
	}
}

/*

Teoría aprendida

public class FizzBuzz_miIntento {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(i%3==0 && i%5==0) {
			System.out.print("FizzBuzz");
		} else if (i%3==0) {
			System.out.print("Fizz");
		} else if(i%5==0) {
			System.out.print("Buzz");
		} else System.out.print(i);
	}
}


Ejemplo aplicado al caso real
Si el usuario es de Cablevision y Fibertel aplicar descuento del 20
Si el usuario es de Cablevision aplicar descuento del 10
Si el usuario es de Fibertel aplicar descuento del 10
Sino -> debe ser de Personal, por eso está en la base: aplicar descuento 5

public class aplicarDescuentosUsuarios {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			if (usuario.esUsuarioCablevision) 
				usuario.aplicaDescuento(10);
			if (usuario.esUsuarioFibertel) 
				usuario.aplicaDescuento(10);
			else if (!usuario.esUsuarioCablevision) 
				usuario.aplicaDescuento(5);
			System.out.println();
	}	
}

Si el usuario gastó más de 1000 cambiar categoría ORO
Si el usuario gastó más de 500 cambiar categoría Plata
Si el usuario gastó más de 200 cambiar categoría Platino
Sino -> mantener categoría

En este caso no es aplicable porque no es ACUMULATIVO.
Este algoritmo es aplicable a casos acumulativos y 
donde no queremos repetir la evaluación de los casos.

 */


 