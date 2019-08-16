package graficos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class Eventos_Ventana {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoVentana marco = new MarcoVentana();
		// EXIT on CLOSE, cierra el programa, por lo tanto ambas ventanas
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// EXIT con el marco, con marco2, si se cierra se cierra solo el 2
		MarcoVentana marco2 = new MarcoVentana();
		marco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		marco.setTitle("MARCO");
		
		marco2.setTitle("MARCO2");
		
		marco.setBounds(300,300,500,350);
		
		marco2.setBounds(900,300,500,350);
	}

}

class MarcoVentana extends JFrame {
	public MarcoVentana() {
//		setTitle("Respondiendo");
//		setBounds(300,300,500,350);
		setVisible(true);
		
//		M_Ventana oyente_ventana = new M_Ventana();
		
//		addWindowListener(oyente_ventana);
		
		addWindowListener(new M_Ventana());
		
	}
}

//class M_Ventana implements WindowListener{
class M_Ventana extends WindowAdapter{
	
//	public void windowActivated(WindowEvent e){
//		System.out.println("Ventana activada");
//	}
//	
//	public void windowClosed(WindowEvent e){
//		System.out.println("La ventana ha sido cerrada");
//	}
//	
//	public void windowClosing(WindowEvent e){
//		System.out.println("Cerrando ventana");
//	}
//	
//	public void windowDeactivated(WindowEvent e){
//		System.out.println("Ventana desactivada");
//	}
//	
//	public void windowDeiconified(WindowEvent e){
//		System.out.println("Ventana restaurada");
//	}

	// Minimizar la ventana
	public void windowIconified(WindowEvent e) {
		System.out.println("Ventana minimizada");
	}
	
//	public void windowOpened(WindowEvent e) {
//		System.out.println("Ventana abierta");
//	} 
	
}