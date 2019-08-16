package graficos;

import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FocoEvento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoFoco marco=new MarcoFoco();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoFoco extends JFrame{
	public MarcoFoco() {
		setVisible(true);
		setBounds(300,300,600,450);
		add(new LaminaFoco());
	}
}

class LaminaFoco extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setLayout(null);
		cuadro1=new JTextField();
		cuadro2=new JTextField();
		
		cuadro1.setBounds(120,10,150,20);
		cuadro2.setBounds(120,50,150,20);
		
		add(cuadro1);
		add(cuadro2);
		
		LanzaFocos elFoco = new LanzaFocos();
		
		cuadro1.addFocusListener(elFoco);
	}
	
	
	class LanzaFocos implements FocusListener{

		@Override
		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
			String mail=cuadro1.getText();
			
			boolean comprobacion=false;
			System.out.println(mail);
			
			
			for (int i = 0; i < mail.length(); i++) {
				if(mail.charAt(i)=='@') {
					comprobacion=true;
				}
			}
			
			if (comprobacion) {
				System.out.print("Mail correcto");
			} else {
				System.out.println("Mail incorrecto");
			}
		}
		
	}
	
	private JTextField cuadro1;
	private JTextField cuadro2;
}

