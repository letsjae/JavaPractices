package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Varios_Oyentes {

	public static void main(String[] args) {
		Marco_Principal marco = new Marco_Principal();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);

	}

}

class Marco_Principal extends JFrame{
	public Marco_Principal() {
		setTitle("Prueba Varios");
		setBounds(1300,100,300,200);
		Lamina_Principal lamina= new Lamina_Principal();
		add(lamina);
		
	}
}

class Lamina_Principal extends JPanel{
	public Lamina_Principal() {
		JButton boton_nuevo=new JButton("Nuevo");
		add(boton_nuevo);
		boton_cerrar=new JButton("Cerrar todo");
		add(boton_cerrar);
		OyenteNuevo miOyente=new OyenteNuevo();
		boton_nuevo.addActionListener(miOyente);
	}
	
	private class OyenteNuevo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Marco_Emergente marco=new Marco_Emergente(boton_cerrar);
			marco.setVisible(true);
		}
		
	}
	
	// Voy a tener que utilizar ésta instancia en otros métodos
	JButton boton_cerrar;
}

class Marco_Emergente extends JFrame{
	public Marco_Emergente(JButton botonDePrincipal) {
		contador ++;
		setTitle("Ventana " + contador);
		setBounds(40*contador,40*contador,300,150);
		CierraTodas oyenteCerrar=new CierraTodas();
		botonDePrincipal.addActionListener(oyenteCerrar);
	}
	
	private class CierraTodas implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
		
	}
	
	// Común a todas las instancias	
	private static int contador=0;
}