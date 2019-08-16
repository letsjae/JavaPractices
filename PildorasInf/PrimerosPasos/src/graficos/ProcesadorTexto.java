package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

public class ProcesadorTexto {

	public static void main(String[] args) {
		Marco_procesador marco=new Marco_procesador();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class Marco_procesador extends JFrame{
 public Marco_procesador() {
	 setTitle("Word casero");
	 setBounds(500,300,550,420);
	 Lamina_procesador lamina = new Lamina_procesador();
	 add(lamina);
	 setVisible(true);
 }
}

class Lamina_procesador extends JPanel{
	public Lamina_procesador() {
		setLayout(new BorderLayout());
		
		JPanel lamina_menu=new JPanel();
		
		JMenuBar barrra_menu=new JMenuBar();
		
		fuente=new JMenu("Fuente");
		estilo=new JMenu("Estilo");
		tamaño=new JMenu("Tamaño");
		
		configuraMenu("Ubuntu", "fuente", "Ubuntu", 9, 10, "");
		configuraMenu("Courier", "fuente", "Courier", 9, 10, "");
		configuraMenu("Verdana", "fuente", "Verdana", 9, 10, "");
		
		configuraMenu("Negrita", "estilo", "", Font.BOLD, 1, "src/graficos/negrita.png");
		configuraMenu("Cursiva", "estilo", "", Font.ITALIC, 1, "src/graficos/cursiva.png");
		
		ButtonGroup tamañoLetra=new ButtonGroup();
		
		JRadioButtonMenuItem doce=new JRadioButtonMenuItem("12");
		JRadioButtonMenuItem dieciseis=new JRadioButtonMenuItem("16");
		JRadioButtonMenuItem veinte=new JRadioButtonMenuItem("20");
		JRadioButtonMenuItem veinticuatro=new JRadioButtonMenuItem("24");
		
		veinticuatro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		
		tamañoLetra.add(doce);
		tamañoLetra.add(dieciseis);
		tamañoLetra.add(veinte);
		tamañoLetra.add(veinticuatro);
		
		doce.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamaño", 12));
		dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamaño", 16));
		veinte.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamaño", 20));
		veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamaño", 24));
		
		tamaño.add(doce);
		tamaño.add(dieciseis);
		tamaño.add(veinte);
		tamaño.add(veinticuatro);
		
		barrra_menu.add(fuente);
		barrra_menu.add(estilo);
		barrra_menu.add(tamaño);
		
		lamina_menu.add(barrra_menu);
		
		add(lamina_menu,BorderLayout.NORTH);
		
		area=new JTextPane();
		
		add(area,BorderLayout.CENTER);
		
		JTextPane area=new JTextPane();
		
		add(area,BorderLayout.CENTER);
		
		JPopupMenu emergente = new JPopupMenu();
		
		JMenuItem negritaE= new JMenuItem("Negrita");
		JMenuItem cursivaE= new JMenuItem("Cursiva");
				
		negritaE.addActionListener(new StyledEditorKit.BoldAction());
		cursivaE.addActionListener(new StyledEditorKit.ItalicAction());
		
		emergente.add(negritaE);
		emergente.add(cursivaE);
				
		area.setComponentPopupMenu(emergente);
		
		barra= new JToolBar();
		
		configuraBarra("src/graficos/negrita.png").addActionListener(new StyledEditorKit.BoldAction());
		configuraBarra("src/graficos/subrayar.png").addActionListener(new StyledEditorKit.UnderlineAction());
		configuraBarra("src/graficos/cursiva.png").addActionListener(new StyledEditorKit.ItalicAction());
		
		barra.addSeparator();
		
		configuraBarra("src/graficos/iconoAzul.png").addActionListener(new StyledEditorKit.ForegroundAction("TextoAzul", Color.BLUE));
		configuraBarra("src/graficos/iconoAmarillo.png").addActionListener(new StyledEditorKit.ForegroundAction("TextoAmarillo", Color.YELLOW));
		configuraBarra("src/graficos/iconoRojo.png").addActionListener(new StyledEditorKit.ForegroundAction("TextoRojo", Color.RED));
		
		barra.addSeparator();
		
		configuraBarra("src/graficos/izquierda.png").addActionListener(new StyledEditorKit.AlignmentAction("IZQ", StyleConstants.ALIGN_LEFT));
		configuraBarra("src/graficos/derecha.png").addActionListener(new StyledEditorKit.AlignmentAction("DER", StyleConstants.ALIGN_RIGHT));
		configuraBarra("src/graficos/centrada.png").addActionListener(new StyledEditorKit.AlignmentAction("CEN", StyleConstants.ALIGN_CENTER));
		configuraBarra("src/graficos/justificado.png").addActionListener(new StyledEditorKit.AlignmentAction("JUS", StyleConstants.ALIGN_JUSTIFIED));
		
		barra.setOrientation(1);
		
		add(barra, BorderLayout.WEST);
		
	}
	
	public JButton configuraBarra(String ruta){
		
		JButton boton = new JButton(new ImageIcon(ruta));
		
		barra.add(boton);
		
		return boton;
	}

	public void configuraMenu(String rotulo, String menu, String tipo_letra, int estilos, int tam, String rutaIcono) {
		JMenuItem elem_menu=new JMenuItem(rotulo, new ImageIcon(rutaIcono));
		
		if(menu=="fuente") {
			fuente.add(elem_menu);
			
			if (tipo_letra=="Ubuntu") {
				elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Ubuntu"));
			} else if (tipo_letra=="Courier") {
				elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Courier"));
			} else if (tipo_letra=="Verdana") {
				elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Verdana"));
			}
			
		} else if (menu=="estilo") {
			estilo.add(elem_menu);
			
			if (estilos==Font.BOLD) {
				elem_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
				elem_menu.addActionListener(new StyledEditorKit.BoldAction());				
			} else {
				elem_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
				elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
			}
			
		} else if (menu=="tamaño") {
			tamaño.add(elem_menu);
			elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamaño", tam));
		}
	}
	
	JTextPane area;
	JMenu fuente, estilo, tamaño;
	Font letras;
	JButton negritaBarra, cursivaBarra, subraBarra, azulBarra,rojoBarra, amarilloBarra, a_izq, a_centr, a_der, a_just;
	JToolBar barra;
}
