import javax.swing.JOptionPane;

public class Entrada_ejemplo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre:");
		
		String edad = JOptionPane.showInputDialog("Introduce edad: ");
		
		System.out.println("Hola " + nombre + " .Tenes " + edad + " años.");
		
		int edad_usuario = Integer.parseInt(edad);
		
		System.out.println("Hola " + nombre + " .El año que viene tendrás " + (edad_usuario+1) + " años.");
	}

}
