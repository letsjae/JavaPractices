package introspección;

public class UsoEmpleado {

	public static void main(String[] args) {

		Persona jey=new Persona("Jey");
		
		System.out.println(jey.getNombre());
		
		Empleado ninfa=new Empleado("Ninfa", 50000);
		
		System.out.println(ninfa.getNombre());
		
		System.out.println(ninfa.getSalario());
		
		System.out.println(jey.getClass());
		
//		Class clase1=jey.getClass();
//		
//		System.out.println(clase1.getName());
		
		String nombreClase="introspección.Empleado";
		
		Class clase2;
		
		try {
			clase2=Class.forName(nombreClase);
			
			System.out.println(clase2.getName());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
        nombreClase="introspección.Persona";

		try {
			clase2=Class.forName(nombreClase);
			
			System.out.println(clase2.getName());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}

class Persona{
	
	public Persona(String nombre) {
		
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private String nombre;
	
}

class Empleado extends Persona{
	
	public Empleado(String nombre, double salario) {
		super(nombre);
		
		this.salario=salario;
	}
	
	public String getSalario() {
		return "El salario es: " + salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void setIncentivo(double incentivo) {
		
		salario=salario+incentivo;
		
	}

	private double salario;
	
}