import javax.swing.JOptionPane;

public class Comprueba_mail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arroba = 0;
		boolean punto=false;
		
		String mail = JOptionPane.showInputDialog("Ingrese su mail");
		
		for(int i=0; i<mail.length(); i++) {
			if( mail.charAt(i) == '@') {
				arroba++;
			}
			
			if(mail.charAt(i)=='.') {
				punto=true;
			}
		}
		
		if(arroba == 1 && punto==true) {
			System.out.println("Mail correcto");
		} else {
			System.out.println("Mail incorrecto");
		}
	}

}
