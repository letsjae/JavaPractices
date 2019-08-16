
public class Manipila_Cadenas_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String frase = "Hoy es un estupendo día para aprender a programar en Java";
		
		String frase_resumen = frase.substring(29, frase.length());
		
		String otra_frase_resumen = frase.substring(0, 29) + "irnos a la playa!";

		System.out.println(frase_resumen);
		
		System.out.println(otra_frase_resumen);

	}

}
