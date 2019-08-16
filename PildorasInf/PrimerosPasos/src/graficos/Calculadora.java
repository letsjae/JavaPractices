package graficos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculadora {

	public static void main(String[] args) {
		MarcoCalculadora marco = new MarcoCalculadora();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);

	}

}

class MarcoCalculadora extends JFrame{
	public MarcoCalculadora() {
		setTitle("Calculadora");
		setBounds(500,300,450,300);
		LaminaCalculadora lamina=new LaminaCalculadora();
		add(lamina);
//		pack();
	}
}

class LaminaCalculadora extends JPanel{
	public LaminaCalculadora() {
		principio=true;
		setLayout(new BorderLayout());
		pantalla = new JButton("0");
		pantalla.setEnabled(false);
		add(pantalla,BorderLayout.NORTH);
		laminaBotones = new JPanel();
		laminaBotones.setLayout(new GridLayout(4,4));
		add(laminaBotones);
		
		ActionListener insertar = new InsertaNumero();
		ActionListener orden=new InsertaOperaciones();
		
		
		ponerBoton("7",insertar);
		ponerBoton("8",insertar);
		ponerBoton("9",insertar);
		ponerBoton("/",orden);
		
		ponerBoton("4",insertar);
		ponerBoton("5",insertar);
		ponerBoton("6",insertar);
		ponerBoton("*",orden);
		
		ponerBoton("1",insertar);
		ponerBoton("2",insertar);
		ponerBoton("3",insertar);
		ponerBoton("-",orden);
		
		ponerBoton("0",insertar);
		ponerBoton(".",orden);
		ponerBoton("+",orden);
		ponerBoton("=",orden);
		
		add(laminaBotones,BorderLayout.CENTER);
		
		ultimaOperacion="=";
	}
	
	private void ponerBoton(String rotulo, ActionListener oyente) {
		JButton boton = new JButton(rotulo);
		boton.addActionListener(oyente);
		
		laminaBotones.add(boton);
	}
	
	private class InsertaNumero implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String entrada = e.getActionCommand();
			
			if(principio) {
				pantalla.setText("");
				principio=false;
			}
			
			pantalla.setText(pantalla.getText() + entrada);
			
		}
		
	}
	
	private class InsertaOperaciones implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String operacion=e.getActionCommand();
			
			calcular(Double.parseDouble(pantalla.getText()));
			
			ultimaOperacion=operacion;
			
			principio=true;
		}
		
		public void calcular(Double x) {
			if (ultimaOperacion.equals("+")) {
				resultado+=x;
			} else if (ultimaOperacion.equals("-")) {
				resultado-=x;
			} else if (ultimaOperacion.equals("*")) {
				resultado*=x;
			} else if (ultimaOperacion.equals("/")) {
				resultado/=x;
			} else if (ultimaOperacion.equals("=")) {
				resultado=x;
			}
			
			pantalla.setText("" + resultado);
		}
	}
	
	private JPanel laminaBotones;
	private JButton pantalla;
	private boolean principio;
	private double resultado;
	private String ultimaOperacion;
	
}