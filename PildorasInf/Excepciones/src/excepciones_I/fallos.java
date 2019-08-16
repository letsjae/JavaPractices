package excepciones_I;

import javax.swing.JOptionPane;

public class fallos {

	public static void main(String[] args) {
		int [] array = new int[5];
		
		array[0]=5;
		array[1]=30;
		array[2]=15;
		array[3]=92;
		array[4]=71;
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Posición " + i + " = " + array[i]);
		}
		
		String nombre=JOptionPane.showInputDialog("Introduce nombre: ");
		
		int edad=Integer.parseInt(JOptionPane.showInputDialog("Introduce edad: "));
		
		System.out.println("Hola, " + nombre + " tu edad es: " + edad + ". Fin ejecución");
		
	}

}
