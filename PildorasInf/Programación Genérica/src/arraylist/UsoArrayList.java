package arraylist;

import java.io.File;

public class UsoArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList2 archivos=new ArrayList2(5);
		
		archivos.add("Jael");
		archivos.add("Cristina");
		archivos.add("Duran");
		archivos.add("letsjae");
		archivos.add(new File("Gestiones.txt"));
		
//		String apellido=(String) archivos.get(2);
		
		String nombre=(String)archivos.get(4);
		
		System.out.println(nombre);
	}

}
