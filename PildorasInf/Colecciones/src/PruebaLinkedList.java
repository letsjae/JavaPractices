import java.util.*;

public class PruebaLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> personas=new LinkedList<String>();
		
		personas.add("Jey");
		
		personas.add("Claire");
		
		personas.add("Anuka");
		
		personas.add("Jana");
		
		personas.add("Dana");
		
		System.out.println(personas.size());
		
		ListIterator<String> it=personas.listIterator();
		
		it.next();
		
		it.add("Camila");
		
		for (String persona : personas) {
			System.out.println(persona);
		}
	}

}
