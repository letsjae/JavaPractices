package excepciones_I;

import javax.swing.JOptionPane;

public class Aleatorios {

	public static void main(String[] args) {
		int elementos=Integer.parseInt(JOptionPane.showInputDialog("Introduce cantidad de elementos de la matriz"));
		
		int num_aleat[]=new int[elementos];
		
		for (int i = 0; i < num_aleat.length; i++) {
 			num_aleat[i]=(int) (Math.random()*100);
		}
		
		for (int i : num_aleat) {
			System.out.println(i);
		}
	}

}
