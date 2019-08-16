package graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrabajandoConFuentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConFuentes miMarcoConColor = new MarcoConFuentes();
		miMarcoConColor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarcoConColor.setVisible(true);
	}

}

class MarcoConFuentes extends JFrame {
	public MarcoConFuentes() {
		setTitle("Prueba con colores");
		setSize(400, 400);		
		LaminaConFuentes laminaColor = new LaminaConFuentes();
		add(laminaColor);
		laminaColor.setBackground(Color.PINK);
		laminaColor.setForeground(Color.BLUE);
	}
}

class LaminaConFuentes extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D) g;
		
		Font mifuente=new Font("Ubuntu", Font.BOLD, 26);
		
		g2.setFont(mifuente);
		
//		g2.setColor(Color.RED);
		
		g2.drawString("Jael", 100, 100);
		
		g2.setFont(new Font("Ubuntu",Font.ITALIC, 50));
		
//		g2.setColor(new Color(128,90,50).brighter());
		
		g2.drawString("Curso de java", 100, 200);
	}
}
