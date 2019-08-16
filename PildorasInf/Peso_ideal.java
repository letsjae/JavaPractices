import javax.swing.JOptionPane;

public class Peso_Ideal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String genero = "";
		
		do {
			genero = JOptionPane.showInputDialog("Ingrese género (F/M)");
		} while ( genero.equalsIgnoreCase("F") == false && genero.equalsIgnoreCase("M") == false  );
		
		int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce altura"));

        int pesoIdeal = 0;

        if( genero.equalsIgnoreCase("M")){
            pesoIdeal = altura - 110;
        } else if(genero.equalsIgnoreCase("F")){
			pesoIdeal = altura - 120;
		}

		System.out.println("Tu peso ideal es " + pesoIdeal);

	}

}
