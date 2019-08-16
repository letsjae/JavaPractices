package graficos;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LibreDisposición {

	public static void main(String[] args) {
		MarcoLibre marco=new MarcoLibre();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}

}

class MarcoLibre extends JFrame{
	
	public MarcoLibre() {
		
		setTitle("Marco LIBRE");
		
		setBounds(450,350,350,400);
		
		LaminaLibre lamina=new LaminaLibre();
		
		add(lamina);
		
	}
}

class LaminaLibre extends JPanel{
	public LaminaLibre() {
		setLayout(new EnColumnas());
		
		JLabel nombre=new JLabel("Nombre: ");
		
		JLabel apellido=new JLabel("Apellido: ");
		
		JLabel edad=new JLabel("Edad: ");
		
		JTextField c_nombre=new JTextField();
		
		JTextField c_apellido=new JTextField();
		
		JTextField c_edad=new JTextField();
		
//		nombre.setBounds(20,20,80,10);
//		
//		c_nombre.setBounds(100,17,100,20);
//		
//		apellido.setBounds(20,60,80,15);
//		
//		c_apellido.setBounds(100,55,100,20);
		
		add(nombre);
		
		add(c_nombre);
		
		add(apellido);
		
		add(c_apellido);
		
		add(edad);
		
		add(c_edad);
	}
}


class EnColumnas implements LayoutManager{

	@Override
	public void addLayoutComponent(String name, Component comp) {
		
	}

	@Override
	public void layoutContainer(Container contenedor) {
		
		int d=contenedor.getWidth();
		
		x=d/2; // punto central del contenedor
		
		int contador=0;
		
		int n=contenedor.getComponentCount();
		
		for (int i = 0; i < n; i++) {
			
			contador++;
			
			Component c=contenedor.getComponent(i);
			
			c.setBounds(x-100, y, 100, 20);
			
			x+=100;
			
			if (contador%2==0) {
				x=d/2;
				y+=40;
			}
			
		}
		
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		return null;
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		return null;
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		
	}
	
	private int x=20;
	private int y=20;
	
}





































