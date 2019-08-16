package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class CampoPassword {

	public static void main(String[] args) {
		MarcoPass marco=new MarcoPass();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoPass extends JFrame{
	public MarcoPass() {
		setBounds(500,300,500,350);
		LaminaPass lamina=new LaminaPass();
		add(lamina);
		setVisible(true);
	}
}

class LaminaPass extends JPanel{
	public LaminaPass() {
		setLayout(new BorderLayout());
		
		JPanel laminaSuperior=new JPanel();
		
		laminaSuperior.setLayout(new GridLayout(2,2));
		
		add(laminaSuperior, BorderLayout.NORTH);
		
		JLabel etiqueta1 = new JLabel("Usuario");
		JLabel etiqueta2 = new JLabel("Contraseña");
		
		JTextField c_usuario=new JTextField(15);
		
		Comprueba_pass evento = new Comprueba_pass();
		
		c_pass=new JPasswordField(15);
		
		c_pass.getDocument().addDocumentListener(evento);
		
		laminaSuperior.add(etiqueta1);
		laminaSuperior.add(c_usuario);
		
		laminaSuperior.add(etiqueta2);
		laminaSuperior.add(c_pass);
		
		JButton enviar= new JButton("Enviar");
		
		add(enviar,BorderLayout.SOUTH);
	}
	
	private class Comprueba_pass implements DocumentListener{
		@Override
		public void changedUpdate(DocumentEvent e) {
			
		}
	
		@Override
		public void insertUpdate(DocumentEvent e) {
			char [] contraseña;
			
			contraseña=c_pass.getPassword();
			
			if (contraseña.length<8 || contraseña.length>12) {
				c_pass.setBackground(Color.RED);
			} else {
				c_pass.setBackground(Color.WHITE);
			}
		}
	
		@Override
		public void removeUpdate(DocumentEvent e) {
			char [] contraseña;
			
			contraseña=c_pass.getPassword();
			
			if (contraseña.length<8 || contraseña.length>12) {
				c_pass.setBackground(Color.RED);
			} else {
				c_pass.setBackground(Color.WHITE);
			}
		}
		
	}
	
	private JPasswordField c_pass;
} 