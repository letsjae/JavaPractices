package graficos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Eventos_Mouse {

	public static void main(String[] args) {
		MarcoBoton marcoConBoton=new MarcoBoton();
		marcoConBoton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
		
	}

}

class MarcoBoton extends JFrame{
	public MarcoBoton() {
		setVisible(true);
		setBounds(700,300,600,450);
		EventoDeRaton eventoRaton=new EventoDeRaton();
//		addMouseListener(eventoRaton);
		addMouseMotionListener(eventoRaton);
	}
}

//class EventoDeRaton implements MouseListener{
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("Hiciste click!!!");
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("Acabas de entrar!!!");
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("Acabas de salir!!!");
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("Acabas de hacer click!!!");
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("Acabas de hacer levantar tu dedo!!!");
//	}
//	
//}


//class EventoDeRaton extends MouseAdapter{
//
////	@Override
////	public void mouseClicked(MouseEvent e) {
////		// TODO Auto-generated method stub
////		//System.out.println("Coordenada X es: " + e.getX() + ", Coordenada Y es: " + e.getY());
////		System.out.println(e.getClickCount());
////	}
//	
//	public void mousePressed(MouseEvent e) {
////		System.out.println(e.getModifiers());
//		
//		if (e.getModifiers()==MouseEvent.BUTTON1_DOWN_MASK) {
//			System.out.println("Presionaste el botón izquierdo");
//		} else if (e.getModifiers()==MouseEvent.BUTTON2_DOWN_MASK) {
//			System.out.println("Presionaste la rueda del mouse");
//		} else if (e.getModifiers()==MouseEvent.BUTTON3_DOWN_MASK) {
//			System.out.println("Presionaste el botón derecho");
//		}
//	}
//	
//}


class EventoDeRaton implements MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent arg0) {
		System.out.println("Estas arrastrando el mouse");
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		System.out.println("Estas moviendo el mouse");
		
	}
	
}




