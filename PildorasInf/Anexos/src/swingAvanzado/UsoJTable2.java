package swingAvanzado;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class UsoJTable2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame marco=new MarcoTablaPersonalizada();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
	}

}

class MarcoTablaPersonalizada extends JFrame{
	
	public MarcoTablaPersonalizada() {
		
		setTitle("Tabla personalizada");
		
		setBounds(400,200,400,300);
		
		TableModel modelo=new ModeloTablaPersonalizada();
		
		JTable tabla=new JTable(modelo);
		
		add(new JScrollPane(tabla));
	}
}

class ModeloTablaPersonalizada extends AbstractTableModel{

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columIndex) {
		
		int z=rowIndex+1;
		
		int y=columIndex+2;
		
		return " " + z + " " + y;
		
	}
	
	public String getColumnName(int c) {
		
		return "Columna " + c;
		
	}
	
}