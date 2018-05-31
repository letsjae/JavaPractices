package cadenita;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.*;

public class ContarDeterminadaLetra {
	
	
	//File archivo = new File ("/archivito.txt");
	File archivo; 
	
	

	
	public ContarDeterminadaLetra(String ruta) {
		archivo = new File (ruta);
	}

	
	public int ContarLaLetra(char letra) {
		int contadorLetra = 0;
		int index;
		
		try {
			FileReader fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);
			
			String unaLinea;
			
			while( (unaLinea = br.readLine()) != null) {
				for(index = 0;index<unaLinea.length(); index++) {
					if( unaLinea.charAt(index) == letra)
						contadorLetra ++;
				}
			}
			
			System.out.println("La letra: " + letra + " se repite " +contadorLetra +" veces");

				br.close();
				
		} catch (FileNotFoundException ex) {
			
			System.out.println("Error en archivo:" + archivo.getName());
			
		} catch (IOException ioe) {
			
			System.out.println(ioe.getMessage());
			
		} 
		
		return contadorLetra;
		
	}
	
}