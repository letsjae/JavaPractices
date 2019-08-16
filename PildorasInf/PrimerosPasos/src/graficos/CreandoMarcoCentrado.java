package graficos;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class CreandoMarcoCentrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCentrado miMarcoCentrado = new MarcoCentrado();
		
		miMarcoCentrado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		miMarcoCentrado.setVisible(true);
	}

}

class MarcoCentrado extends JFrame {
	public MarcoCentrado() {
		// detectar la resolución de la pantalla
		
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		
		Dimension tamanoPantalla = miPantalla.getScreenSize();
		
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla=tamanoPantalla.width;
		
		setSize(anchoPantalla/2, alturaPantalla/2);
		
		setLocation(anchoPantalla/4, alturaPantalla/4);		
		
		setTitle("Marco centrado");
		
		// hay que especificarle partiendo de la raiz, la ruta donde se encuentra
		
		Image icono = miPantalla.getImage("src/graficos/mascota.png");
		
		setIconImage(icono);
		
//		System.out.println(tamanoPantalla);
		
		
	}
}