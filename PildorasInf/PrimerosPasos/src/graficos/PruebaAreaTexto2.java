package graficos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PruebaAreaTexto2  {

	public static void main(String[] args) {
		MarcoAreaTexto marco=new MarcoAreaTexto();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}

}

class MarcoAreaTexto extends JFrame{
	public MarcoAreaTexto() {
		setTitle("Prueba area de texto");
		setBounds(500,300,500,350);
		setLayout(new BorderLayout());
		
		
		laminaBotones = new JPanel();
		
		botonInsertar= new JButton("Insertar");
		
		botonInsertar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				areaTexto.append("En un lugar de la Mancha de cuyo nombre no quiero acordarme...");
				
			}
		});
		
		laminaBotones.add(botonInsertar);
		
		botonSaltoLinea = new JButton("Salto Línea");
		
		botonSaltoLinea.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Indica si hay saltos de línea
				boolean saltar=!areaTexto.getLineWrap();
				areaTexto.setLineWrap(saltar);
				
//				if (saltar) {
//					botonSaltoLinea.setText("Quitar salto");
//				} else {
//					botonSaltoLinea.setText("Salto Línea");
//				}
//				Operador ternario
				
				botonSaltoLinea.setText(saltar ? "Quitar salto" : "Salto Línea");
				
			}
		});
		
		laminaBotones.add(botonSaltoLinea);
		
		add(laminaBotones,BorderLayout.SOUTH);
		
		areaTexto=new JTextArea(8,20);
		
		laminaBarras= new JScrollPane(areaTexto);
		
		add(laminaBarras, BorderLayout.CENTER);
		
		
		
	}
	
	private JPanel laminaBotones;
	private JButton botonInsertar;
	private JButton botonSaltoLinea;
	private JTextArea areaTexto;
	private JScrollPane laminaBarras;
}

