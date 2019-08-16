package graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layout_1 {

	public static void main(String[] args) {
		Marco_Layout marco= new Marco_Layout();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);

	}

}

class Marco_Layout extends JFrame{
	public Marco_Layout(){
		setTitle("Prueba Acciones");
		setBounds(600,350,600,300);
		Panel_Layout lamina=new Panel_Layout();
		Panel_Layout_2 lamina2=new Panel_Layout_2();
//		FlowLayout disposicion = new FlowLayout(FlowLayout.LEFT);
//		lamina.setLayout(new FlowLayout(FlowLayout.LEFT, 75, 100));
		
//		lamina.setLayout(new FlowLayout(FlowLayout.LEFT, 75, 100));
		
		add(lamina,BorderLayout.NORTH);
		add(lamina2,BorderLayout.SOUTH);
		
	}
}

class Panel_Layout extends JPanel{
	public Panel_Layout() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new JButton("Amarillo"));
		add(new JButton("Rojo"));
		
	}
}

class Panel_Layout_2 extends JPanel{
	public Panel_Layout_2() {
		setLayout(new BorderLayout());
		add(new JButton("Azul"), BorderLayout.WEST);
		add(new JButton("Verde"), BorderLayout.EAST);
		add(new JButton("Negro"), BorderLayout.CENTER); 
	}
}