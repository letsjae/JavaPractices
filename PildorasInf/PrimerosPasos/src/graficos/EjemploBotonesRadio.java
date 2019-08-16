package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class EjemploBotonesRadio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco_Radio marco= new Marco_Radio();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}

}

class Marco_Radio extends JFrame{
	public Marco_Radio() {
		setTitle("Prueba botones radio - sintaxis");
		setBounds(550,300,500,300);
		Lamina_Radio lamina = new Lamina_Radio();
		add(lamina);
	}
}

class Lamina_Radio extends JPanel{
	public Lamina_Radio() {
		setLayout(new BorderLayout());
		
		texto=new JLabel("En un lugar de la Mancha de cuyo nombre...");
		
		add(texto, BorderLayout.CENTER);
		
		laminaBotones = new JPanel();
		
		grupo = new ButtonGroup();
		
		colocarBotones("Pequeño", false, 10);
		colocarBotones("Mediano", true, 12);
		colocarBotones("Grande", false, 18);
		colocarBotones("Muy grande", false, 26);
		
		add(laminaBotones, BorderLayout.SOUTH);
		
//		ButtonGroup grupo = new ButtonGroup();
//		
//		boton1 = new JRadioButton("Pequeño", false);
//		boton2 = new JRadioButton("Mediano", false);
//		boton3 = new JRadioButton("Grande", false);
//		boton4 = new JRadioButton("Muy grande", false);
//		
//		JPanel lamina_radio=new JPanel();
//		
//		EventoRadio evento= new EventoRadio();
//		
//		boton1.addActionListener(evento);
//		boton2.addActionListener(evento);
//		boton3.addActionListener(evento);
//		boton4.addActionListener(evento);
//		
//		grupo.add(boton1);
//		grupo.add(boton2);
//		grupo.add(boton3);
//		grupo.add(boton4);
//		
//		lamina_radio.add(boton1);
//		lamina_radio.add(boton2);
//		lamina_radio.add(boton3);
//		lamina_radio.add(boton4);
//
//		add(lamina_radio,BorderLayout.SOUTH);
	}
	
//	private class EventoRadio implements ActionListener{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			if (e.getSource()==boton1) {
//				texto.setFont(new Font("Serif", Font.PLAIN, 10));
//			} else if(e.getSource()==boton2) {
//				texto.setFont(new Font("Serif", Font.PLAIN, 12));
//			} else if(e.getSource()==boton3) {
//				texto.setFont(new Font("Serif", Font.PLAIN, 14));
//			} else if(e.getSource()==boton4) {
//				texto.setFont(new Font("Serif", Font.PLAIN, 24));
//			}
//		}
//		
//	}
	
	public void colocarBotones(String nombre, boolean seleccionado, int tamaño) {
		JRadioButton boton=new JRadioButton(nombre, seleccionado);
		
		grupo.add(boton);
		
		laminaBotones.add(boton);
		
		ActionListener evento= new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				texto.setFont(new Font("Serif", Font.PLAIN, tamaño));
			}
		};
		
		boton.addActionListener(evento);
	}
	
	private JLabel texto;
	private JRadioButton boton1,boton2,boton3,boton4;
	private ButtonGroup grupo;
	private JPanel laminaBotones;
}
