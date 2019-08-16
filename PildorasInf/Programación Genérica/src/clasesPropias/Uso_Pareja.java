package clasesPropias;

public class Uso_Pareja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Pareja<String> una=new Pareja<String>();
		
		una.setPrimero("Jael");
		
		System.out.println(una.getPrimero());
		
		Persona persona1=new Persona("Jey");
		
		Pareja<Persona> otra=new Pareja<Persona>();
		
		otra.setPrimero(persona1);
		
		System.out.println(otra.getPrimero());
	}

}

class Persona{
	public Persona(String nombre ) {
		this.nombre=nombre;
	}
	
	public String toString() {
		return nombre;
	}
	
	private String nombre;
}