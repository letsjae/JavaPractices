package graficos;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class DisposicionMuelle {

	public static void main(String[] args) {
		MarcoLibre marco=new MarcoLibre();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}

}

class MarcoMuelle extends JFrame{
	
	public MarcoMuelle() {
		
		setTitle("Marco CAJA");
		
		setBounds(300,400,1000,350);
		
		LaminaLibre lamina=new LaminaLibre();
		
		add(lamina);
		
	}
}

class LaminaMuelle extends JPanel{
	
	public LaminaMuelle() {
		JButton boton1=new JButton("Boton 1");
		JButton boton2=new JButton("Boton 2");
		JButton boton3=new JButton("Boton 3");
		
		SpringLayout layout=new SpringLayout();
		
		setLayout(layout); // la lamina va a trabajar con esta disposición
		
		add(boton1);
		add(boton2);
		add(boton3);
		
		Spring muelle=Spring.constant(100,10,100);
		
		Spring muelleRigido=Spring.constant(20);
		
		layout.putConstraint(SpringLayout.WEST, boton1, muelle, SpringLayout.WEST, this);
		
		layout.putConstraint(SpringLayout.WEST, boton2, muelleRigido, SpringLayout.EAST, boton1);
		
		layout.putConstraint(SpringLayout.WEST, boton3, muelleRigido, SpringLayout.EAST, boton2);
		
		layout.putConstraint(SpringLayout.EAST, this, muelle, SpringLayout.EAST, boton3);
		
		
	}
}