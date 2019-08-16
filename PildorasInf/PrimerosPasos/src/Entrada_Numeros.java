import javax.swing.JOptionPane;

public class Entrada_Numeros {
	public static void main(String[] args) {

		double x = 10000.0;
		
//		System.out.println(x/3);		
//		System.out.printf("%1.2f", x/3);
		
		String numero = JOptionPane.showInputDialog("Introduce un número: ");
		
		double numero_double = Double.parseDouble(numero);
		
		System.out.print("La raiz cuadrada de " + numero + " es: ");
		System.out.printf("%1.2f", Math.sqrt(numero_double));
	}

}
