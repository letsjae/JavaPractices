import java.util.Comparator;
import java.util.TreeSet;

public class Prueba_TreeSet {
	
	public static void main(String[] args) {
		
//		TreeSet<String> ordenaPersonas=new TreeSet<String>();
//		
//		ordenaPersonas.add("Jana");
//		
//		ordenaPersonas.add("Jey");
//		
//		ordenaPersonas.add("Anuka");
//		
//		for (String p : ordenaPersonas) {
//			System.out.println(p);
//		}
		
		TreeSet<Articulo> ordenaArt=new TreeSet<Articulo>();
		
		Articulo primerArt=new Articulo(1, "Primer artículo");
		
		Articulo segundoArt=new Articulo(2 , "Segundo artículo");
		
		Articulo tercerArt=new Articulo(3, "Este es el tercer artículo");
		
		ordenaArt.add(segundoArt);
		
		ordenaArt.add(primerArt);
		
		ordenaArt.add(tercerArt);
		
		for (Articulo a : ordenaArt) {
			System.out.println(a.getDesc());
		}

		// usa constructor sin parámetros, está creando un objeto del tipo COMPARATOR
		// para pasarle al TreeSet, para que use finalmente el método compare
//		Articulo comparadorArticulo=new Articulo();
		
		// se usa otro constructor de TreeSet ->  los objetos se van a almacenar ordenados
		// segun lo que marque el comparador -> metodo compare
//		TreeSet<Articulo> ordenaArticulos=new TreeSet<Articulo>(comparadorArticulo);
		
//		ComparadorArticulos compara_art=new ComparadorArticulos();
		
		TreeSet<Articulo> ordenaArticulos=new TreeSet<Articulo>(new Comparator<Articulo>() {

			@Override
			public int compare(Articulo a1, Articulo a2) {
				
				String desc_a1=a1.getDesc();
				
				String desc_a2=a2.getDesc();
				
				return desc_a1.compareTo(desc_a2);
				
				
			} 
			
			
		}); 
		
		
		ordenaArticulos.add(segundoArt);
		
		ordenaArticulos.add(primerArt);
		
		ordenaArticulos.add(tercerArt);
		
		for (Articulo a : ordenaArticulos) {
			System.out.println(a.getDesc());
		}

	}
}

class Articulo implements Comparable<Articulo> /*, Comparator<Articulo>*/{

//	public Articulo() {
//		
//	}
	
	public Articulo(int num, String desc) {
		
		this.num=num;
		
		this.desc=desc;
		
	}
	
	public String getDesc() {
		return desc;
	}
	
	@Override
	public int compareTo(Articulo a) {
		return num - a.num;
	}
	
	private int num;
	
	private String desc;

//	@Override
//	public int compare(Articulo a1, Articulo a2) {
//		
//		String desc_a1=a1.getDesc();
//		
//		String desc_a2=a2.getDesc();
//		
//		return desc_a1.compareTo(desc_a2);
//		
//		
//	}
}

class ComparadorArticulos implements Comparator<Articulo>{

	@Override
	public int compare(Articulo a1, Articulo a2) {
		
		String desc_a1=a1.getDesc();
		
		String desc_a2=a2.getDesc();
		
		return desc_a1.compareTo(desc_a2);
		
		
	}
	
}




