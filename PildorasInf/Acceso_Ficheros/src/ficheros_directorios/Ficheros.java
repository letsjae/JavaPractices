package ficheros_directorios;

import java.io.File;

public class Ficheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File ruta=new File(File.separator+
		                    "home"+
		                    File.separator+
		                    "jey"+
		                    File.separator+
		                    "Desktop"+
		                    File.separator+
		                    "letsjaeJava");
		
		
//		File ruta=new File("/home/jey/Desktop/letsjaeJava");
		
		System.out.println(ruta.getAbsolutePath());
		
		String[] archivos=ruta.list();
		
		for(int i = 0; i < archivos.length; i++) {
//			System.out.println(archivos[i]);
			
			File f=new File(ruta.getAbsoluteFile(), archivos[i]);
			
			if (f.isDirectory()) {
				String [] archivos_subcarpeta=f.list();
				
				for (int j = 0; j < archivos_subcarpeta.length; j++) {
					System.out.println(archivos_subcarpeta[j]);
				}
			}
		}
	}

}
