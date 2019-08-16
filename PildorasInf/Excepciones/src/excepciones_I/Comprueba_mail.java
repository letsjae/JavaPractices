package excepciones_I;

import javax.swing.JOptionPane;

public class Comprueba_mail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String mail = JOptionPane.showInputDialog("Ingrese su mail");
		
		try {
			examina_mail(mail);
		} catch(Exception e) {
			System.out.println("Mail INCORRECTO!!");
			e.printStackTrace();
		}

	}
	
	static void examina_mail (String mailEntered) throws LongitudMailErroneo{
		int arroba = 0;
		boolean punto=false;
		
		if(mailEntered.length()<=3) {
		
			throw new LongitudMailErroneo("El mail es demasiado corto");
			
		} else {
			for(int i=0; i<mailEntered.length(); i++) {
				if( mailEntered.charAt(i) == '@') {
					arroba++;
				}
				
				if(mailEntered.charAt(i)=='.') {
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

}


class LongitudMailErroneo extends Exception{
	public LongitudMailErroneo(){
		
	}
	
	public LongitudMailErroneo(String msjError){
		super(msjError); 
	}
	
}