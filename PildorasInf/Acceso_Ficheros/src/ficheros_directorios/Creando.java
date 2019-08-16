package ficheros_directorios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Creando {

	public static void main(String[] args) {
		File ruta=new File(File.separator+
                "home"+
                File.separator+
                "jey"+
                File.separator+
                "Desktop"+
                File.separator+
                "letsjaeJava"+
                File.separator+
                File.separator+
                "Nuevo directorio" + 
                File.separator + 
                "nuevo archivo");
		
//		ruta.mkdir();
		
		String archivoDestino=ruta.getAbsolutePath();
		
		try {
			boolean rta = ruta.createNewFile();
			System.out.println(rta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Escribiendo accede_es=new Escribiendo();
		
		accede_es.escribir(archivoDestino);
		
		
	}

}

class Escribiendo{
	public void escribir(String ruta_archivo) {
		String frase="Esto es un ejemplo";	
		
		try {
			FileWriter escritura= new FileWriter(ruta_archivo);
			
			for (int i = 0; i < frase.length(); i++) {
				escritura.write(frase.charAt(i));
			}
			
			escritura.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}