package graficos;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class PruebaDibujo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConFiguras marco = new MarcoConFiguras();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoConFiguras extends JFrame{
	public MarcoConFiguras() {
		setTitle("Prueba con dibujos");
		setVisible(true);
		setSize(400, 400);
		LaminaConFiguras miLamina = new LaminaConFiguras();
		add(miLamina);
	}
}

class LaminaConFiguras extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Pixeles x, y -> luego el tamaño del Rect
//		g.drawRect(50, 50, 200, 200);
//		g.drawLine(100, 100, 300, 200);
//		g.drawArc(50, 100, 100, 200, 120, 150);
		
		Graphics2D g2=(Graphics2D) g;
		
		Rectangle2D rectangulo=new Rectangle2D.Double(100,100,200,150);
		
		g2.draw(rectangulo);
		
		Ellipse2D elipse= new Ellipse2D.Double();
				
		elipse.setFrame(rectangulo);
		
		g2.draw(elipse);
		
		g2.draw(new Line2D.Double(100, 100, 300, 250));
		
		double CentroEnX=rectangulo.getCenterX();
		double CentroEnY=rectangulo.getCenterY();
		double radio=150;
		
		Ellipse2D circulo=new Ellipse2D.Double();
		
		circulo.setFrameFromCenter(CentroEnX, CentroEnY, CentroEnX+radio, CentroEnY+radio);
		
		g2.draw(circulo);
		
	}
}