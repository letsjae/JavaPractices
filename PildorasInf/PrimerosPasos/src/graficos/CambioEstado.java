package graficos;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

public class CambioEstado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoEstado marco = new MarcoEstado();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MarcoEstado extends JFrame{
	public MarcoEstado() {
		setVisible(true);
		setBounds(300,300,500,350);
		CambioDeEstado nuevo_estado=new CambioDeEstado();
		addWindowStateListener(nuevo_estado);
	}
			
}

class CambioDeEstado implements WindowStateListener{
	public void windowStateChanged(WindowEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("La ventana ha cambiado de estado");
		
//		System.out.println(e.getNewState());
		
		// Ver si el nuevo estado de la ventana es pantalla completa
		if (e.getNewState()==Frame.MAXIMIZED_BOTH) {
			System.out.println("La ventana está a pantalla completa");			
		} else if(e.getNewState()==Frame.NORMAL) {
			System.out.println("La ventana está normal");
		} else if(e.getNewState()==Frame.ICONIFIED) {
			System.out.println("La ventana está minimizada");
		}
	}
}