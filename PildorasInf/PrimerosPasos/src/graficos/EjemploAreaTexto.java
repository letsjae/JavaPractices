package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EjemploAreaTexto {

	public static void main(String[] args) {
		MarcoArea marco=new MarcoArea();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoArea extends JFrame{
	public MarcoArea() {
		setBounds(500,300,500,350);
		LaminaArea lamina=new LaminaArea();
		add(lamina);
		setVisible(true);
	}
}

class LaminaArea extends JPanel{
	public LaminaArea() {
		area=new JTextArea(8,20);
		
		JScrollPane laminaScroll=new JScrollPane(area);
		
		area.setLineWrap(true);
		add(laminaScroll);
		
		JButton boton=new JButton("Done!");
		
		boton.addActionListener(new GestionaArea());
		
		add(boton);
	}
	
	private class GestionaArea implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println(area.getText());
		}
		
	}
	
	private JTextArea area;
}