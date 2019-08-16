package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaEventos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoBotones marco = new MarcoBotones();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoBotones extends JFrame{
	public MarcoBotones() {
		setTitle("Marco con botones");
		setBounds(700,300,500,300);
		LaminaBotones lamina= new LaminaBotones();
		add(lamina);
	}
}


// La lámina tiene que implementar la interfaz ActionListener pq es ella 
// quien recibirá al evento
class LaminaBotones extends JPanel{
	JButton botonAzul = new JButton("Tornar Azul"); // Objeto fuente
	JButton botonAmarillo = new JButton("Tornar Amarillo");
	JButton botonRojo = new JButton("Tornar Rojo");
	
	
	public LaminaBotones() {
		add(botonAzul);
		add(botonAmarillo);
		add(botonRojo);
		// El oyente, quien recibe el evento es la lamina
		// Ponemos a la escucha la propia lámina
		// va a desencadenar un evento de tipo click
		// y el objeto que va a estar a la escucha es la lámina
		
		ColorFondo Amarillo= new ColorFondo(Color.YELLOW);
		ColorFondo Rojo= new ColorFondo(Color.RED);
		ColorFondo Azul= new ColorFondo(Color.BLUE);
		
		botonAzul.addActionListener(Azul);
		botonAmarillo.addActionListener(Amarillo);
		botonRojo.addActionListener(Rojo);
		// 3 objetos fuentes
		// oyentes? 1 solo, la lámina
		// Hay que decirle que dependiendo el botón presionado, hay que indicarle la acción
		// 
		
	}
	
	private class ColorFondo implements ActionListener{
		public ColorFondo(Color c) {
			colorFondo=c;
		}
		
		public void actionPerformed(ActionEvent e) {
			setBackground(colorFondo);
		}
		
		private Color colorFondo;
	}
	
	
	
	
// Construir obligadamente el método actionPerformed
//	public void actionPerformed(ActionEvent e) {
//		
//		Object botonPulsado = e.getSource(); // origen evento
//		
//		if (botonPulsado==botonAzul) {
//			setBackground(Color.BLUE);
//		} else if (botonPulsado==botonRojo) {
//			setBackground(Color.RED);
//		} else {
//			setBackground(Color.YELLOW);
//		}
//	}
}

/*
 * 1er FACTOR: objeto evento, ACTION > al hacer click
 * 2do FACTOR: objeto fuente, objeto que desencadena este EVENTO > el botón
 * 3er elemento: el LISTENER, identifica la clase que > RECIBE el evento
 * */
 






