package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrabajandoColores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoColor miMarcoConColor = new MarcoColor();
		miMarcoConColor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarcoConColor.setVisible(true);
	}

}

class MarcoColor extends JFrame {
	public MarcoColor() {
		setTitle("Prueba con colores");
		setSize(400, 400);		
		LaminaConColor laminaColor = new LaminaConColor();
		add(laminaColor);
//		laminaColor.setBackground(SystemColor.OPAQUE);
		
		laminaColor.setBackground(Color.PINK);
		
	}
}

class LaminaConColor extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D) g;
		
		Rectangle2D rectangulo = new Rectangle2D.Double(100,100,200,150);
		
		g2.setPaint(Color.BLUE);
		
		g2.draw(rectangulo);
		
		g2.setPaint(Color.RED);
		
		g2.fill(rectangulo);
		
		Ellipse2D elipse = new Ellipse2D.Double();
		
		elipse.setFrame(rectangulo);		
		
		Color miColor=new Color(170,80,90);
		
//		g2.setPaint(Color.BLUE);
		
//		g2.setPaint(new Color(109,172,59).darker());
				
		g2.setPaint(miColor);
		
		g2.fill(elipse);
		
	}
}
