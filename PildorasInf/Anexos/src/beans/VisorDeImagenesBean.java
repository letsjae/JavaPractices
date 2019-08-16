 package beans;

import javax.imageio.*;
import javax.swing.*;

import java.awt.*;
import java.io.*;

/**
 * Esta clase pretende construir un Bean para incluir imágenes
 * @author jey
 *
 */

public class VisorDeImagenesBean extends JLabel{

	public VisorDeImagenesBean() {
		
		// Construimos los bordes
		
		setBorder(BorderFactory.createEtchedBorder());
		
	}
	
	/**
	 * Método clave para escoger imagen.
	 * @param elegirImagen. Este parámetro permitirá escoger una imagen
	 */
	
	public void setEligeImagen(String elegirImagen) {
		
		try {
			
			archivo=new File(elegirImagen);
			
			setIcon(new ImageIcon( ImageIO.read(archivo)));
			
		} catch (IOException e) {
			
			archivo=null;
			
			setIcon(null);
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @return Devuelve la ruta de la imagen elegida con setEligeImagen
	 * @param No recibe parámetro alguno
	 * 
	 */
	
	public String getEligeImage() {
		
		if(archivo==null) {
			
			return null;
			
		} else {
			
			return archivo.getPath();
			
		}
		
	}
	
	public Dimension getPreferredSize() {
		
		return new Dimension(600,400);
		
	}
	
	/**
	 *  El tamáno máximo en mb
	 */
	public static int pruebaConstante=7;
	
	private File archivo=null;
	
	
}
