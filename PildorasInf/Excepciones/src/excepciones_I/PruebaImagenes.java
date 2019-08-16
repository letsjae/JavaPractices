package excepciones_I;


import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.*;

public class PruebaImagenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConImagen mimarco=new MarcoConImagen();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoConImagen extends JFrame{
	public MarcoConImagen() {
		setTitle("Marco con imagen");
		setBounds(750,300,300,200);
		LaminaConImagen milamina=new LaminaConImagen();
		add(milamina);
				
	}
}

class LaminaConImagen extends JPanel{
	
	public LaminaConImagen() {
		
		// ERROR COMPROBADO
		try {
			imagen=ImageIO.read(new File("src/excepciones_I/iconoAzul.png"));
		} catch (IOException e) {
			System.out.println("Imagen no encontrada");
		}
		
//		imagen=ImageIO.read(new File("src/excepciones_I/iconoAzul.png"));
	
	} // Variable, imagen en memoria 
	
	public void paintComponent(Graphics g) throws NullPointerException{
		super.paintComponent(g);
		
		// ERROR NO COMPROBADO: no te obliga a capturar la excepción.
		try {
			g.drawString("No podemos cargar la imagen", 10, 10);
		
			int anchuraImagen=imagen.getWidth(this); // this es el observer, la Lamina
			int alturaImagen=imagen.getHeight(this);
					
			g.drawImage(imagen, 0, 0, null);
			
			for(int i=0;i<300; i++) {
				for(int j=0;j<300; j++) {
					g.copyArea(0, 0, anchuraImagen, alturaImagen, anchuraImagen*i, anchuraImagen*j);
				}	
			}
		} catch (NullPointerException e ) {
			System.out.println("No se ha podido cargar la imagen");
		}
		
	}
	
	private Image imagen;
}