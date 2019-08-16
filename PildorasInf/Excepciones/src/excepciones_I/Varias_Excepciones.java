package excepciones_I;

import javax.swing.JOptionPane;

public class Varias_Excepciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			division();
		}catch(ArithmeticException e) {
			System.out.println("Estas intentando dividir por 0");
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido un número entero");
			System.out.println(e.getMessage());
			System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
			
		}

	}

	static void division() {
		int num1=Integer.parseInt(JOptionPane.showInputDialog("Introduce dividendo"));
		
		int num2=Integer.parseInt(JOptionPane.showInputDialog("Introduce divisor"));
		
		System.out.println("Resultado: " + num1/num2);
	}
}


