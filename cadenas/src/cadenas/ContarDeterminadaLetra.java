package cadenas;
import java.util.*;
import java.io.*;

public class ContarDeterminadaLetra {
	
	
	File archivo = new File ("/home/jey/Escritorio/archivito.txt");
	
	
	public void ContarLaLetra(char letra) {
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
			
			System.out.println("La letra: " + letra + " se repite" +contadorLetra +" veces");
			try{
				br.close();
				} catch (IOException ioe) {}
		} catch (FileNotFoundException ex)
		{
			System.out.println("Error en archivo:" + archivo.getName());
		}
		
		
		
	}
	
}
