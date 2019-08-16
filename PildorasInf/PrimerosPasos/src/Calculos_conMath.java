
public class Calculos_conMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double raiz=Math.sqrt(9);
		
		int raizRedondeada = (int)Math.round(raiz);
		
		double base= 5;
		double exponente=3;
		
		int resultado = (int)Math.pow(base, exponente);
		
		System.out.println(raizRedondeada);
		
		System.out.println("Elevar " + (int)base + " al exponente " + (int)exponente + " es: " + resultado);
	}	

}
