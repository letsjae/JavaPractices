package graficos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class EventoTeclado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConTeclas marco = new MarcoConTeclas();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoConTeclas extends JFrame{
	public MarcoConTeclas() {
		setVisible(true);
		setBounds(700,300,600,450);
		EventoDeTeclado tecla=new EventoDeTeclado();
		addKeyListener(tecla);
		
	}
}

// Crear un oyente para que detecte la tecla pulsasa
class EventoDeTeclado implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
//		int codigo=e.getKeyCode();
//		System.out.println(codigo);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char letra=e.getKeyChar();
		System.out.println(letra);
		
	}
	
}