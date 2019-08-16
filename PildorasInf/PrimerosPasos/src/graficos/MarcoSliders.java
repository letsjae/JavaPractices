package graficos;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MarcoSliders {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			MarcoSlider marco= new MarcoSlider();
			marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			marco.setVisible(true);

		}

	}

class MarcoSlider extends JFrame{
	public MarcoSlider() {
		setTitle("Prueba Sliders");
		setBounds(550,400,550,350);
		Lamina_Spinner lamina = new Lamina_Spinner();
		add(lamina);
	}
}

class LaminaSliders extends JPanel{
	public LaminaSliders() {
//		JSlider control = new JSlider(0,100,50);
		
//		control.setOrientation(SwingConstants.VERTICAL);
		
//		control.setMajorTickSpacing(50);
//		
//		control.setMinorTickSpacing(25);
//		
//		control.setPaintTicks(true);
//		
//		control.setPaintLabels(true);
//		
//		control.setFont(new Font("Ubuntu", Font.ITALIC, 12));
//		
//		control.setSnapToTicks(true);
//		
//		add(control);
		
		setLayout(new BorderLayout());
		
		rotulo=new JLabel("En un lugar de la Mancha de cuyo nombre...");
		
		add(rotulo,BorderLayout.CENTER);
		
		control= new JSlider(8,50,12);
		
		control.setMajorTickSpacing(20);
		
		control.setMinorTickSpacing(5);
		
		control.setPaintTicks(true);
		
		control.setPaintLabels(true);
		
		control.setFont(new Font("Ubuntu", Font.ITALIC, 10));
		
		control.addChangeListener(new EventoSlider());
		
		JPanel laminaSlider=new JPanel();
		
		laminaSlider.add(control);
		
		add(laminaSlider,BorderLayout.NORTH);
	}
	
	private class EventoSlider implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent arg0) {
			// TODO Auto-generated method stub
			rotulo.setFont(new Font("Ubuntu", Font.ITALIC, control.getValue()));
			
		}
		
	}
	
	private JLabel rotulo;
	private JSlider control;
	private static int contador;
	
}