package graficos;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ButonRadioSintaxis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoBotonRadioSintaxis marco= new MarcoBotonRadioSintaxis();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}

}

class MarcoBotonRadioSintaxis extends JFrame{
	public MarcoBotonRadioSintaxis() {
		setTitle("Prueba botones radio - sintaxis");
		setBounds(550,300,500,300);
		LaminaBotonRadioSintaxis lamina = new LaminaBotonRadioSintaxis();
		add(lamina);
	}
}

class LaminaBotonRadioSintaxis extends JPanel{
	public LaminaBotonRadioSintaxis() {
		ButtonGroup grupo1 = new ButtonGroup();
		ButtonGroup grupo2 = new ButtonGroup();
		
		JRadioButton boton1 = new JRadioButton("Azul",false);
		JRadioButton boton2 = new JRadioButton("Rojo",true);
		JRadioButton boton3 = new JRadioButton("Verde",false);
		
		JRadioButton boton4 = new JRadioButton("Masculino",false);
		JRadioButton boton5 = new JRadioButton("Femenino",false);
		
		grupo1.add(boton1);
		grupo1.add(boton2);
		grupo1.add(boton3);
		
		grupo2.add(boton4);
		grupo2.add(boton5);
		
		
		add(boton1);
		add(boton2);
		add(boton3);
		
		add(boton4);
		add(boton5 );		
		
	}
}