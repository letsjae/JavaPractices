import javax.swing.JOptionPane;

public class Acceso_App {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String clave = "Contraseña";
		String pass = "";
		
		while(clave.equals(pass) == false) {
			pass = JOptionPane.showInputDialog("Introduce la contraseña correcta:");
			
			if (clave.equals(pass) == false) {
				System.out.println("Contraseña incorrecta");
			}
		}
		
		System.out.println("Contraseña correcta, acceso permitido");
	}	
}
