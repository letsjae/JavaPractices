package graficos;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MarcoMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco_Menu marco= new Marco_Menu();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);

	}

}

class Marco_Menu extends JFrame{
	public Marco_Menu() {
		setTitle("Prueba con menues");
		setBounds(550,400,550,350);
		Lamina_Menu lamina = new Lamina_Menu();
		add(lamina);
	}
}

class Lamina_Menu extends JPanel{
	public Lamina_Menu() {
		JMenuBar barra=new JMenuBar();
		JMenu archivo = new JMenu("Archivo");
		JMenu edicion = new JMenu("Edicion");
		JMenu herramientas = new JMenu("Herramientas");
		
		JMenu opciones = new JMenu("Opciones");
		
		JMenuItem guardar = new JMenuItem("Guardar");
		JMenuItem guardarComo = new JMenuItem("Guardar Como");
		
		JMenuItem copiar = new JMenuItem("Copiar", new ImageIcon("src/graficos/copiar.png"));
		
		copiar.setHorizontalTextPosition(SwingConstants.LEFT);
		
		JMenuItem cortar = new JMenuItem("Cortar", new ImageIcon("src/graficos/cortar.png"));
		JMenuItem pegar = new JMenuItem("Pegar", new ImageIcon("src/graficos/pegar.png"));
		
		
		
		JMenuItem generales= new JMenuItem("Generales");
		
		JMenuItem opcion1= new JMenuItem("Opcion 1");
		JMenuItem opcion2= new JMenuItem("Opcion 2");
		
		opciones.add(opcion1);
		opciones.add(opcion2);
		
		archivo.add(guardar);
		archivo.add(guardarComo);
		
		edicion.add(copiar);
		edicion.add(cortar);
		edicion.add(pegar);
		
		edicion.addSeparator();
		
		edicion.add(opciones);
		
		herramientas.add(generales);

		barra.add(archivo);
		barra.add(edicion);
		barra.add(herramientas);
		
		add(barra);
	}
}