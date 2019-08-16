package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class Prueba {

	public static void main(String[] args) {
		Marco marco=new Marco();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class Marco extends JFrame{
	public Marco() {
		setBounds(500,300,500,350);
		LaminaPrueba lamina=new LaminaPrueba();
		add(lamina);
		setVisible(true);
	}
}

class LaminaPrueba extends JPanel{
	public LaminaPrueba() {
		JTextField campo=new JTextField(20);
		
		EscuchaTexto el_evento=new EscuchaTexto();
		
		Document midoc=campo.getDocument();
		
		midoc.addDocumentListener(el_evento);
		
		add(campo);
	}
	
	private class EscuchaTexto implements DocumentListener{

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			System.out.println("Has insertado texto");
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			System.out.println("Has borrado texto");
		}
		
	}
}