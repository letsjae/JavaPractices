import java.awt.JobAttributes;

import javax.swing.JOptionPane;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long resultado = 1L;
		// El factorial del número 20 es -2102132736 > sobrepasa el valor de lo que puede almacenar un int

		int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero"));
		
		for(int i=numero; i>0; i--) {
			resultado=resultado*i;
		}
		
		System.out.println("El factorial del número " + numero + " es " + resultado);
	}

}
