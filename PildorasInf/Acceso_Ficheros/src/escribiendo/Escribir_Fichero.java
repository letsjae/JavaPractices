package escribiendo;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class Escribir_Fichero {

	public static void main(String[] args) {
		Escribiendo accede=new Escribiendo();
		
		accede.escribir();
	}

}

class Escribiendo{
	public void escribir() {
		String frase="Prueba de escritura";
		
		try {
			FileWriter escritura=new FileWriter("src/escribiendo/fichero_nuevo");
			
			for (int i = 0; i < frase.length(); i++) {
				escritura.write(frase.charAt(i));
			}
			
			escritura.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
