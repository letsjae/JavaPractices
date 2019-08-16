package poo;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class PruebaTemporizador {

	public static void main(String[] args) {

		LaHora oyente = new LaHora();
		
		// ActionListener oyente = new LaHora();
		
		Timer miTemporizador=new Timer(5000, oyente);
		
		miTemporizador.start();

		JOptionPane.showMessageDialog(null, "Pulsa Aceptar para detener");
		
		// Cuando pulsas aceptar el programa 
		// sigue la ejecución hacia abajo se
        // ejecutar cerrar con la sgte instrucción
		
		System.exit(0);
	}

}

class LaHora implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		Date ahora=new Date();
		System.out.println("La hora será mostrada cada 5 segundos: " + ahora);
		Toolkit.getDefaultToolkit().beep();
	}
}
