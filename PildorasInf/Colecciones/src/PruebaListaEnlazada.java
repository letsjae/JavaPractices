import java.util.LinkedList;
import java.util.ListIterator;

public class PruebaListaEnlazada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<String> paises=new LinkedList<String>();
		
		LinkedList<String> capitales=new LinkedList<String>();
		
		paises.add("España");
		
		paises.add("Colombia");
		
		paises.add("México");
		
		paises.add("Perú");
		
		System.out.println(paises);
		
		capitales.add("Madrid");
		
		capitales.add("Bogotá");
		
		capitales.add("DF");
		
		capitales.add("Lima");
		
		System.out.println(capitales);
		
		ListIterator<String> it_pai=paises.listIterator();
		
		ListIterator<String> it_cap=capitales.listIterator();
		
		while (it_cap.hasNext()) {
			
			if (it_pai.hasNext()) {
				
				it_pai.next();
			}
			
			it_pai.add(it_cap.next());
		}
		
		System.out.println(paises);
		
		it_cap=capitales.listIterator(); // Vuelve al principio de la lista
		
		while(it_cap.hasNext()) {
			
			it_cap.next();
			
			if (it_cap.hasNext()) {
			
				it_cap.next();
				
				it_cap.remove();
			}
		}
		
		System.out.println(capitales);
		
		paises.removeAll(capitales);
		
		System.out.println(paises);
	}

}
