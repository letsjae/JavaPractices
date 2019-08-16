package graficos;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class MarcoSpinner {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Marco_Spinner marco= new Marco_Spinner();
			marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			marco.setVisible(true);

		}

	}

class Marco_Spinner extends JFrame{
	public Marco_Spinner() {
		setTitle("Prueba Spinner");
		setBounds(550,400,550,350);
		Lamina_Spinner lamina = new Lamina_Spinner();
		add(lamina);
	}
}

class Lamina_Spinner extends JPanel{
	public Lamina_Spinner() {
//		String lista[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
//		JSpinner control=new JSpinner(new SpinnerListModel(lista));
	
		JSpinner control= new JSpinner(new SpinnerNumberModel(5,0,10,1) {
			public Object getNextValue() {
				return super.getPreviousValue();
			}
			
			public Object getPreviousValue() {
				return super.getNextValue();
			}

		});
		
		Dimension d = new Dimension(200,20);
		control.setPreferredSize(d);
		add(control);
	}
	
//	private class MiModeloJSpinner extends SpinnerNumberModel{
//		public MiModeloJSpinner() {
//			super(5,0,10,1);
//			
//		}
//		
//		public Object getNextValue() {
//			return super.getPreviousValue();
//		}
//		
//		public Object getPreviousValue() {
//			return super.getNextValue();
//		}
//	}
}