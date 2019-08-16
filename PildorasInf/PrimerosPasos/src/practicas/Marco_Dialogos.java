package practicas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Marco_Dialogos extends JFrame{
	public Marco_Dialogos() {
		
		setTitle("Generador de ventanas emergentes - Ejercicio práctico I");
		
		setBounds(500,300,600,450);
		
		JPanel lamina_cuadricula=new JPanel();
		
		lamina_cuadricula.setLayout(new GridLayout(2, 3));
		
		String primerBox[]= {"Mensaje","Confirmar","Opción","Entrada"};
		
		lamina_tipos=new Lamina_Botones("Tipo", primerBox);
		
		lamina_tipo_mensajes=new Lamina_Botones("Tipo de mensajes", new String [] {
				"ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE"
		});
		
		lamina_mensaje=new Lamina_Botones("Mensaje", new String[] {
			"Cadena", "Icono", "Componente", "Otros", "Object[]"	
		});
		
		lamina_tipo_opcion=new Lamina_Botones("Confirmar", new String[] {
				"DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION"	
			});
		
		lamina_opciones=new Lamina_Botones("Opción", new String[] {
				"String[]","Icon[]","Object[]"	
			});
		
		lamina_entrada=new Lamina_Botones("Entrada", new String[] {
				"Campo de texto", "Combo"	
			});
		
		setLayout(new BorderLayout());
		
		lamina_cuadricula.add(lamina_tipos);
		
		lamina_cuadricula.add(lamina_tipo_mensajes);
		
		lamina_cuadricula.add(lamina_mensaje);
		
		lamina_cuadricula.add(lamina_tipo_opcion);
		
		lamina_cuadricula.add(lamina_opciones);
		
		lamina_cuadricula.add(lamina_entrada);
		
		add(lamina_cuadricula, BorderLayout.CENTER);
		
		// Construimos la lámina inferior
		
		JPanel lamina_secundaria=new JPanel();
		
		JButton botonMostrar=new JButton("Mostrar");
		
		botonMostrar.addActionListener(new AccionMostrar());
		
		lamina_secundaria.add(botonMostrar);
		
		add(lamina_secundaria, BorderLayout.SOUTH);
		
	}
	
	
	// - - - - - - - - - - Proporciona el mensaje - - - - - - - - - - 
	
	public Object ObtenerMensaje() {
		
		String s=lamina_mensaje.seleccion();
		
		if (s.equals("Cadena")) {
			return cadenaMensaje;
		} else if (s.equals("Icono")) {
			return iconoMensaje;
		} else if (s.equals("Componente")) {
			return componenteMensaje;
		} else if (s.equals("Componente")) {
			return componenteMensaje;
		} else if (s.equals("Otros")) {
			return objetoMensaje;
		} else if (s.equals("Object[]")) {
			return new Object[] {
					cadenaMensaje, iconoMensaje, componenteMensaje, objetoMensaje
			};
		} else {
			return null;
		}
	}

	// - - - - - - - - - - Proporciona el icono y también número de botones en Confirmar - - - - - - - - - - 
	

	public int obtenerTipo(Lamina_Botones lamina) {
		String s=lamina.seleccion();
		
		if (s.equals("ERROR_MESSAGE") || s.equals("YES_NO_OPTION")) {
			return 0;
		} else if (s.equals("INFORMATION_MESSAGE") || s.equals("YES_NO_CANCEL_OPTION")) {
			return 1;
		} else if (s.equals("WARNING_MESSAGE") || s.equals("OK_CANCEL_OPTION") ) {
			return 2;
		} else if (s.equals("QUESTION_MESSAGE")) {
			return 3;
		} else if (s.equals("PLAIN_MESSAGE") || s.equals("DEFAULT_OPTION")) {
			return -1;
		} else {
			return -1;
		}
	}
	
	// - - - - - - - - - - Proporciona las opciones - - - - - - - - - -
		
	public Object[] obtenerOpciones(Lamina_Botones lamina) {
		String s=lamina.seleccion();
		
		if (s.equals("String[]")) {
			return new String[] { "Amarillo", "Azul", "Rojo"};
		} else if(s.equals("Icon[]")) {
			return new Object[] {
				new ImageIcon("src/graficos/iconoAmarillo.png"),
				new ImageIcon("src/graficos/iconoAzul.png"),
				new ImageIcon("src/graficos/iconoRojo.png"),
			};
		} else if (s.equals("Object[]")) {
			return new Object[] {
					cadenaMensaje, iconoMensaje, componenteMensaje, objetoMensaje
			};
		}else {
			return null;
		}
	}
	
	
	
	
	private class AccionMostrar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (lamina_tipos.seleccion().equals("Mensaje")) {
				JOptionPane.showMessageDialog(Marco_Dialogos.this, ObtenerMensaje(), "Título", obtenerTipo(lamina_tipo_mensajes));
			} else if (lamina_tipos.seleccion().equals("Confirmar")){
				JOptionPane.showConfirmDialog(Marco_Dialogos.this, ObtenerMensaje(), "Título", obtenerTipo(lamina_tipo_opcion), obtenerTipo(lamina_tipo_mensajes));
			} else if (lamina_tipos.seleccion().equals("Entrada")){
				if (lamina_entrada.seleccion().equals("Campo de texto")) {
					JOptionPane.showInputDialog(Marco_Dialogos.this, ObtenerMensaje(), "Título", obtenerTipo(lamina_tipo_mensajes));
				} else {
					JOptionPane.showInputDialog(Marco_Dialogos.this, ObtenerMensaje(), "Título", obtenerTipo(lamina_tipo_mensajes), null, new String[] { "Amarillo", "Azul", "Rojo"}, "Azul");
				}
				
				
				
				
			} else if (lamina_tipos.seleccion().equals("Opción")){
				JOptionPane.showOptionDialog(Marco_Dialogos.this, ObtenerMensaje(), "Título", 0, obtenerTipo(lamina_tipo_mensajes), null, obtenerOpciones(lamina_opciones), null);
			}
		}
		
	}
	
	private Lamina_Botones lamina_tipos, lamina_tipo_mensajes, lamina_mensaje, lamina_tipo_opcion, lamina_opciones, lamina_entrada;
	
	private String cadenaMensaje="Mensaje";
	
	private Icon iconoMensaje=new ImageIcon("src/graficos/iconoRojo.png");
	
	private Object objetoMensaje=new Date();
	
	private Component componenteMensaje=new LaminaMensaje();
}

class LaminaMensaje extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D) g;
		
		Rectangle2D rectangulo=new Rectangle2D.Double(0,0,getWidth(),getHeight());
		
		g2.setPaint(Color.YELLOW);
		
		g2.fill(rectangulo);
	}
}



