package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PruebaCombo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCombo marco= new MarcoCombo();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);

	}

}

class MarcoCombo extends JFrame{
	public MarcoCombo() {
		setTitle("Prueba ComboBox");
		setBounds(550,300,500,300);
		LaminaCombo lamina = new LaminaCombo();
		add(lamina);
	}
}

class LaminaCombo extends JPanel{
	public LaminaCombo() {
		setLayout(new BorderLayout());
		texto= new JLabel("En un lugar de la Mancha...");
		texto.setFont(new Font("Serif", Font.PLAIN, 18));
		add(texto,BorderLayout.CENTER);
		
		JPanel laminaNorte = new JPanel();
		combo= new JComboBox();
		
		combo.setEditable(true);
		
		combo.addItem("Serif");
		combo.addItem("SansSerif");
		combo.addItem("Monospaced");
		combo.addItem("Dialog");
		
		EventoCombo evento = new EventoCombo();
		
		combo.addActionListener(evento);
		
		laminaNorte.add(combo);
		
		add(laminaNorte, BorderLayout.NORTH);
		
	}
	
	private class EventoCombo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			texto.setFont(new Font( (String) combo.getSelectedItem(), Font.PLAIN, 18));
		}
		
	}
	
	private JLabel texto;
	private JComboBox combo;
}