package graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class PruebaTexto {

	public static void main(String[] args) {
		MarcoTexto marco=new MarcoTexto();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoTexto extends JFrame{
	public MarcoTexto() {
		setBounds(600,300,600,350);
		LaminaTexto lamina=new LaminaTexto();
		add(lamina);
		setVisible(true);
	}
}

class LaminaTexto extends JPanel{
	public LaminaTexto() {
		setLayout(new BorderLayout());
		
		JPanel lamina2 = new JPanel();
		
		lamina2.setLayout(new FlowLayout());
		
		resultado=new JLabel("", JLabel.CENTER);
		
		JLabel texto1=new JLabel("Email: ");
		
		lamina2.add(texto1);
		
		campo1= new JTextField(20);
		
		lamina2.add(campo1);
		
		add(resultado,BorderLayout.CENTER);
		
		JButton boton=new JButton("Comprobar");
		
		ObtenerTexto evento= new ObtenerTexto();
		
		boton.addActionListener(evento);
		
		lamina2.add(boton);
		
		add(lamina2,BorderLayout.NORTH);
	}
	
	private class ObtenerTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int correcto=0;
			
			String email=campo1.getText().trim();
			
			for (int i = 0; i < email.length(); i++) {
				if (email.charAt(i)=='@') {
					correcto++;
				}
			}
			
			if (correcto!=1) {
				resultado.setText("Incorrecto");
			} else {
				resultado.setText("Correcto");
			}
			
			
			
		}
		
	}
	
	private JTextField campo1;
	private JLabel resultado;
}
