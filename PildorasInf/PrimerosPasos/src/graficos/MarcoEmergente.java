package graficos;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;
import javax.swing.border.Border;

public class MarcoEmergente {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Marco_Emergente_ marco= new Marco_Emergente_();
			marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			marco.setVisible(true);

		}

	}

class Marco_Emergente_ extends JFrame{
	public Marco_Emergente_() {
		setTitle("Prueba ventanas emergentes");
		setBounds(550,400,550,350);
		Lamina_Emergente lamina = new Lamina_Emergente();
		add(lamina);
	}
}

class Lamina_Emergente extends JPanel{
	public Lamina_Emergente() {
		setLayout(new BorderLayout());
		
		JPanel laminaMenu= new JPanel();
		
		JMenuBar barra= new JMenuBar();
		
		JMenu fuente = new JMenu("Fuente");
		JMenu estilo = new JMenu("Estilo");
		JMenu tamaño = new JMenu("Tamaño");
		
		barra.add(fuente);
		barra.add(estilo);
		barra.add(tamaño);
		
		laminaMenu.add(barra);
		
		add(laminaMenu,BorderLayout.NORTH);
		
		JTextPane area=new JTextPane();
		
		add(area,BorderLayout.CENTER);
		
		JPopupMenu emergente = new JPopupMenu();
		
		JMenuItem opcion1= new JMenuItem("Opcion 1");
		JMenuItem opcion2= new JMenuItem("Opcion 2");
		JMenuItem opcion3= new JMenuItem("Opcion 3");
		
		emergente.add(opcion1);
		emergente.add(opcion2);
		emergente.add(opcion3);
		
		setComponentPopupMenu(emergente);
	}
}