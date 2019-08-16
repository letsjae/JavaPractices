package graficos;

import java.awt.Frame;

import javax.swing.*;

public class CreandoMarcos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiMarco marco1=new MiMarco();
		marco1.setVisible(true);
		
		// cuando se cierra esta ventana el programa tiene que terminar
		// Constante de clase, static, final
		// Establece el comportamiento
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// util p ara varias ventanas en el programa
		
//		marco1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	}

}

class MiMarco extends JFrame{
	public MiMarco() {
		
//		setSize(500,300);
		
		// el centro de coordenadas NO ESTA en el centro de la pantalla
		// está en la esquina superior izquierda
//		setLocation(500, 300); // 500 pixeles en eje X , 300 pixeles en eje Y
		// Desplazamiento positivo desplaza hacia abajo en Y
		
		// podemos utilizar setBounds para ambas cosas:
		setBounds(500,300,550,250);
		
//		setResizable(false); // no se puede re dimensionar con false
//		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		setTitle("Mi ventana");
		
		// Para colocar la ventana en el centro del monitor
		// hay que saber la resolución
	
		
		
	}
}