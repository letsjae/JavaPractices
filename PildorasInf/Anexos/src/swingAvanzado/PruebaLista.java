package swingAvanzado;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PruebaLista {

	public static void main(String[] args) {
		
		JFrame marco=new MarcoDeLista();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
	}

}

class MarcoDeLista extends JFrame{
	
	public MarcoDeLista() {
		setTitle("Prueba con JLIST");
		
		setBounds(400,300,400,300);
		
		String [] meses= {
				"Enero","Febrero","Marzo","Abril","Mayo","Junio",
				"Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"	};
		
		listaMeses=new JList<String>(meses);
		
		listaMeses.setVisibleRowCount(5);
		
		JScrollPane laminaDesplazamiento=new JScrollPane(listaMeses);
		
		laminaDeLista=new JPanel();
		
		laminaDeLista.add(laminaDesplazamiento);
		
		listaMeses.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				List<String> seleccionados=listaMeses.getSelectedValuesList();
				
				StringBuilder texto=new StringBuilder("Mes seleccionado: ");
				
				for (String elemento : seleccionados) {
					
					String palabra=elemento;
					
					texto.append(palabra);
					
					texto.append(", ");
					
					rotulo.setText(texto.toString());
					
				}
				
			}
		});
		
		laminaDeTexto=new JPanel();
		
		rotulo=new JLabel("Mes seleccionado: ");
		
		laminaDeTexto.add(rotulo);
		
		add(laminaDeLista, BorderLayout.NORTH);
		
		add(laminaDeTexto, BorderLayout.SOUTH);
		
	}
	
	private JList<String> listaMeses;
	
	private JPanel laminaDeLista, laminaDeTexto;
	
	private JLabel rotulo;
}

