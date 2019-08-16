package swingAvanzado;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.List;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class ArbolSencillo {
	public static void main(String[] args) {
		
		JFrame marco=new MarcoDeArbol();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
	}

}

class MarcoDeArbol extends JFrame{
	
	public MarcoDeArbol() {
		
		setTitle("Prueba con Arboles");
		
		setBounds(400,200,400,300);
		
		// Creamos la raiz
		
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("Mundo");
		
		// Nodo de tipo hijo
		
		DefaultMutableTreeNode pais=new DefaultMutableTreeNode("Argentina");
		
		raiz.add(pais);
		
		DefaultMutableTreeNode comunidad=new DefaultMutableTreeNode("Buenos Aires");
		
		pais.add(comunidad);

		DefaultMutableTreeNode CapFed=new DefaultMutableTreeNode("Capital Federal");
		
		comunidad.add(CapFed);
		
		DefaultMutableTreeNode prov=new DefaultMutableTreeNode("Provincia");
		
		comunidad.add(prov);
		
		comunidad=new DefaultMutableTreeNode("Córdoba");
		
		pais.add(comunidad);

		DefaultMutableTreeNode VGB=new DefaultMutableTreeNode("Villa General Belgrano");
		
		comunidad.add(VGB);
		
		//-----
		
		pais=new DefaultMutableTreeNode("Alemania");
		
		raiz.add(pais);
		
		comunidad=new DefaultMutableTreeNode("Baviera");
		
		pais.add(comunidad);

		DefaultMutableTreeNode munich=new DefaultMutableTreeNode("Munich");
		
		comunidad.add(munich);
		
		
		JTree arbol=new JTree(raiz);
		
//		LaminaArbol lamina=new LaminaArbol(arbol);
//		
//		add(lamina);
		
		Container laminaContenida=getContentPane();
		
		laminaContenida.add(new JScrollPane(arbol));
		
		
	}
}

//class LaminaArbol extends JPanel{
//	
//	public LaminaArbol(JTree arbol) {
//		
//		setLayout(new BorderLayout());
//		
//		add(arbol, BorderLayout.NORTH);
//	}
//}

