import java.util.Scanner;

public class Entrada_ejemplo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce tu nombre: ");
		
		String nombreUsuario = entrada.nextLine();
		
		System.out.println("Introduce edad: ");
		
		int edad = entrada.nextInt();
		
		System.out.println("Hola! " + nombreUsuario + " el año que viene tendrás " + (edad+1) + " años.");

	}

}
