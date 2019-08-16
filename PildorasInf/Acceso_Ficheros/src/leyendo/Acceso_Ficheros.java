package leyendo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Acceso_Ficheros {
	public static void main(String args[]) {
		Leer_Fichero accediendo = new Leer_Fichero();
		
		accediendo.leer();

	}
}

class Leer_Fichero{
	
	public void leer() {
		try {
			FileReader entrada=new FileReader("src/leyendo/Doc_1_AccesoFicheros");
			
			BufferedReader buffer=new BufferedReader(entrada);
			
//			int c=0;
			
			String linea=""; // salto de linea
			
			while(linea != null) { // mientras que aun haya que leer...
				linea=buffer.readLine();
				
				if(linea!=null) System.out.println(linea);
			}
			
			entrada.close(); // No es necesario el finally pq solo se abre si todo va bien
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo");
		} 
	}
}