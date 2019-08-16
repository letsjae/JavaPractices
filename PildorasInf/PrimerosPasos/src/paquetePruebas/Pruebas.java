package paquetePruebas;

import java.awt.GraphicsEnvironment;
import javax.swing.*;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] nombresDeLasFuentesInstaladas=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
//		String fuente=JOptionPane.showInputDialog("Ingrese una fuente");
		
//		boolean existeFuente=false;
		
		for(String nombreFuente:nombresDeLasFuentesInstaladas) {
			System.out.println(nombreFuente);
//			if (nombreFuente.equals(fuente)) {
//				existeFuente=true;
//			}
		}
		
//		if(existeFuente) {
//			System.out.println("La fuente está instalada");
//		} else {
//			System.out.println("La fuente no está instalada");
//		}
	}

}
