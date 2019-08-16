package ficheros_directorios;

import java.io.File;

public class Eliminando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		ruta.delete();
	}

}
