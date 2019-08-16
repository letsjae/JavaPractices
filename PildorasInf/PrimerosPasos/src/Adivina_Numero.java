import java.util.Scanner;

public class Adivina_Numero {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int aleatorio = (int)(Math.random()*100);
//		
//		System.out.println(aleatorio);
//		System.out.println((int)Math.round(aleatorio));
//		
		Scanner entrada = new Scanner(System.in);
		int numero=0;
		int intentos=0;
		
//		while(numero!=aleatorio){
//			intentos++;
//			
//			System.out.println("Introduce un número:");
//			
//			numero=entrada.nextInt();
//			
//			if(aleatorio<numero) {
//				System.out.println("Mas pequeño...");
//			} else if (aleatorio>numero) {
//				System.out.println("Mas alto...");
//			}
//		}
		
		do{
			intentos++;
			
			System.out.println("Introduce un número:");
			
			numero=entrada.nextInt();
			
			if(aleatorio<numero) {
				System.out.println("Mas pequeño...");
			} else if (aleatorio>numero) {
				System.out.println("Mas alto...");
			}
		} while(numero!=aleatorio);
			
		/* En el caso de que random dé un número 0,0050 (con dos ceros despues de la coma)
		 * nos aseguramos que una vez al menos pase por el bucle
		 */
		
		System.out.println("Correcto! Lo conseguiste en " + intentos + " intentos");
	}	
}
