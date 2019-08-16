package mis_applets;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Hola_Alumnos extends JApplet{
	public void init() {
		JLabel rotulo= new JLabel("Hola mundo", SwingConstants.CENTER);
		
		add(rotulo);
	}
}
