package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class PruebaAcciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoAccion marco=new MarcoAccion();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}

}

class MarcoAccion extends JFrame{
	public MarcoAccion() {
		setTitle("Prueba acciones");
		
		setBounds(600,350,600,300);
		
		PanelAccion lamina=new PanelAccion();
		
		add(lamina);
	}
}

class PanelAccion extends JPanel{
	public PanelAccion() {

		AccionColor accionAmarillo = new AccionColor("Amarillo",
				                                     new ImageIcon("src/graficos/iconoAmarillo.png"),
				                                     Color.YELLOW);
		
		AccionColor accionAzul = new AccionColor("Azul",
								                 new ImageIcon("src/graficos/iconoAzul.png"),
								                 Color.BLUE);
		
		AccionColor accionRojo = new AccionColor("Rojo",
                                                 new ImageIcon("src/graficos/iconoRojo.png"),
                                                 Color.RED);

		add(new JButton(accionAmarillo));
		add(new JButton(accionAzul));
		add(new JButton(accionRojo));
		
		// 1er PASO - Mapa de entrada
		InputMap mapaEntrada=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

		// 2do PASO - Combinación de teclas
//		KeyStroke teclasAmarillo = KeyStroke.getKeyStroke("ctrl A");
		
		// 3er PASO - Asignar la comb de teclas a un objeto
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondo_amarillo");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl T"), "fondo_amarillo");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondo_azul");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondo_rojo");
		
		// 4to PASO - Asignar el objeto a la acción
		ActionMap mapaAccion=getActionMap();
		
		mapaAccion.put("fondo_amarillo", accionAmarillo);
		mapaAccion.put("fondo_azul", accionAzul);
		mapaAccion.put("fondo_rojo", accionRojo);
	}
	
	private class AccionColor extends AbstractAction{

		public AccionColor(String nombre, Icon icono, Color colorBoton) {
			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color " + nombre);
			putValue("ColorDeFondo", colorBoton);
		}
		
		public void actionPerformed(ActionEvent e) {
			// Qué tiene que pasar cuando los botones son pulsados?
			Color c=(Color)getValue("ColorDeFondo");
			setBackground(c);
			System.out.println("Nombre: " + getValue(Action.NAME) + 
					           ", descripción: " + getValue(Action.SHORT_DESCRIPTION));
		}
		
	}
}

