import java.util.HashMap;
import java.util.Map;

public class PruebaMapas {

	public static void main(String[] args) {
		HashMap<String, Empleado> personal=new HashMap<String, Empleado>();
		// HasMap<K,V>
		
		personal.put("145", new Empleado("Jey"));
		
		personal.put("150", new Empleado("Claire"));
		
		personal.put("155", new Empleado("Anuka"));
		
		System.out.println(personal);
		
		personal.remove("150");
		
		System.out.println(personal);
		
		personal.put("155", new Empleado("Anukka"));
		
		System.out.println(personal);
		
//		System.out.println(personal.entrySet());
		
		for (Map.Entry<String, Empleado> entrada: personal.entrySet()) {
			String clave=entrada.getKey();
			
			Empleado valor=entrada.getValue();
			
			System.out.println("Clave: "+clave+". Valor: "+valor);
		}
	}

}

class Empleado{
	public Empleado(String nombre) {
		
		this.nombre=nombre;
		
		this.sueldo=3000;
	}
	
	public String toString() {
		return "[ Nombre: "+nombre+" Sueldo: "+sueldo+"]";
	}
	
	private String nombre;
	
	private double sueldo;
}