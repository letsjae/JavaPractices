package leyendoyescribiendobytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LecturaEscritura_bytes {

	public static void main(String[] args) {
		int cont=0;
		
		int datosEntrada []=new int[17174];
		
		try {
			FileInputStream archivo_lectura=new FileInputStream("src/Duke.png");
			
			boolean final_archivo=false;
						
			while (!final_archivo) {
				
				int byte_entrada=archivo_lectura.read();
				
				if (byte_entrada !=-1) {
					datosEntrada[cont]=byte_entrada;
				} else final_archivo=true;
				
				System.out.println(datosEntrada[cont]);
				
				cont++;
				
			}
			
			archivo_lectura.close();
			
		} catch (IOException e) {
			System.out.println("No se puede acceder a la imagen");
		}
		
		System.out.println(cont);
		
		crea_fichero(datosEntrada);
	}
	
	static void crea_fichero(int datosNuevoFichero[]) {
		try {
			FileOutputStream ficheroNuevo=new FileOutputStream("src/DukeCopia.png");
			
			for (int i = 0; i < datosNuevoFichero.length; i++) {
				ficheroNuevo.write(datosNuevoFichero[i]);
			}
			
			ficheroNuevo.close();
		} catch (IOException e) {
			System.out.println("Error al crear el archivo");
		}
	}

}
