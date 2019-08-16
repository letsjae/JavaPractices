package graficos;

import javax.swing.*;
import java.awt.*;

public class EscribiendoEnMarco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConTexto miMarco = new MarcoConTexto();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoConTexto extends JFrame{
	public MarcoConTexto () {
		setVisible(true);
		setSize(600, 450);
		setLocation(400, 200);
		setTitle("Primer texto");
		// además tiene que incluir una lámina
		Lamina miLamina = new Lamina();
		add(miLamina);
		
	}
}

class Lamina extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Nuestro texto está a 100 pixeles del borde 
		g.drawString("Estamos aprendiendo SWING", 100, 100);
	}
}