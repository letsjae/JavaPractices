package principal;

import javax.swing.JFrame;

import vista.Marco_Aplicacion_II;

public class Ejecuta_MVC {

	public static void main(String[] args) {
		
		Marco_Aplicacion_II marco = new Marco_Aplicacion_II();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
	}

}
