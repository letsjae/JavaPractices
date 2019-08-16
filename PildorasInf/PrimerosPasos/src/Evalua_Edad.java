import java.util.Scanner;

public class Evalua_Edad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("Introduce tu edad: ");
		
		int edad=entrada.nextInt();
		
//		if (edad>=18) {
//			System.out.println("Sos mayor de edad.");
//		} else {
//			System.out.println("No sos mayor de edad.");
//		}

		if (edad<18) {
			System.out.println("Sos adolescente");
		} else if (edad<40){
			System.out.println("Sos joven");
		} else if (edad<65) {
			System.out.println("Sos maduro");
		} else {
			System.out.println("Cuidate!");
		}
	}

}
