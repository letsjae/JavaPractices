package swingAvanzado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UsoJTable {
	public static void main(String[] args) {
		
		JFrame marco=new MarcoTabla();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
	}

}

class MarcoTabla extends JFrame{
	
	public MarcoTabla() {
		
		setTitle("Prueba con JTable");
		
		setBounds(400,200,400,300);
		
		JTable tablaPlanetas=new JTable(datosFilas, nombreColumnas);
		
		add(new JScrollPane(tablaPlanetas), BorderLayout.CENTER);
		
		JButton botonImprimir=new JButton("Imprimir tabla");
		
		botonImprimir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					tablaPlanetas.print();
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		JPanel laminaBoton=new JPanel();
		
		laminaBoton.add(botonImprimir);
		
		add(laminaBoton, BorderLayout.SOUTH);
	}
	
	private String[] nombreColumnas= {"Nombre","Radio","Lunas","Gaseoso"};
	
	private Object[][] datosFilas= {
			{"Mercurio",2440.0,0,false},
			{"Venus",6052.0,0,false},
			{"Tierra",6378.0,1,false},
			{"Marte",3397.0,2,false},
			{"Júpiter",71492.0,16,true},
			{"Saturno",60268.0,18,true},
			{"Urano",25559.0,17,true},
			{"Neptuno",24766.0,8,true},
			{"Plutón",1137.0,1,false},
	};
	
	
}