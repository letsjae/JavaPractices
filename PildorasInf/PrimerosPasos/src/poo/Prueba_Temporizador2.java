package poo;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Prueba_Temporizador2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reloj miReloj=new Reloj();
		miReloj.enMarcha(3000,true);
		
		JOptionPane.showMessageDialog(null, "Pulse ACEPTAR para finalizar");
		
		System.exit(0);
	}

}

class Reloj {
//	public Reloj(int intervalo, boolean sonido) {
//		this.intervalo=intervalo;
//		this.sonido=sonido;
//	}
	
	public void enMarcha(int intervalo, final boolean sonido) {
		// Clase interna LOCAL
		
		class LaHora2 implements ActionListener{
			public void actionPerformed(ActionEvent evento) {
				Date ahora=new Date();
				System.out.println("La hora cada 3 segs es: " + ahora);
				if (sonido) {
					Toolkit.getDefaultToolkit().beep();
				}
			}
		}
		
		ActionListener oyente=new LaHora2();
		Timer miTemporizador=new Timer(intervalo, oyente);
		miTemporizador.start();
	}
	
//	private int intervalo;
//	private boolean sonido;

	// Clase INTERNA
//	private class LaHora2 implements ActionListener{
//		public void actionPerformed(ActionEvent evento) {
//			Date ahora=new Date();
//			System.out.println("La hora cada 3 segs es: " + ahora);
//			if (sonido) {
//				Toolkit.getDefaultToolkit().beep();
//			}
//		}
//	}
	
}
