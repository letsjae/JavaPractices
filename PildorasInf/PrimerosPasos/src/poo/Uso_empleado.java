package poo;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_empleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jefatura jefe_RRHH = new Jefatura("Jey", 55000, 2006,9,25);
		
		jefe_RRHH.estableceIncentivo(2570);
		
		Empleado [] misEmpleados = new Empleado[5];
		
		misEmpleados[0]=new Empleado("Paco Gómez", 85000, 1990, 12, 17);
		misEmpleados[1]=new Empleado("Ana López", 95000, 1995, 6, 2);
		misEmpleados[2]=new Empleado("María Martín", 105000, 2002, 3, 15);
		misEmpleados[3]=jefe_RRHH; // polimorfismo, principio de ustitución
			
		misEmpleados[4]= new Jefatura("Paula",95000,1999,5,26);
		Jefatura jefa_finanzas = (Jefatura) misEmpleados[4];
		
//		Empleado director_comercial=new Jefatura("Sandra",85000,2012,05,05);
//		Comparable ejemplo = new Empleado("Elisa",95000,2011,06,07);
//		
//		if(director_comercial instanceof Empleado) {
//			System.out.println("Es un jefe");
//		}
//		
//		if(ejemplo instanceof Comparable) {
//			System.out.println("Implementa Comparable");
//		}
		
		
//		
		System.out.println("La jefa de finanzas" + jefa_finanzas.nombre() + 
				" tiene un bonus de " + jefa_finanzas.establece_bonus(500));
		
		System.out.println(misEmpleados[3].nombre() + " tiene un bonus de: " +
		                  misEmpleados[3].establece_bonus(200));
		
		
		Arrays.sort(misEmpleados);
		
		System.out.println(jefa_finanzas.tomarDecisiones(" dar más días de vacaciones a los empleados"));
		
		for(Empleado e: misEmpleados) {
			e.subirSueldo(5);
		}
		
		for(Empleado e: misEmpleados) {
			System.out.println("Nombre: " + e.nombre() +
			           " Sueldo: " + e.sueldo() + 
			           " Fecha de alta: " + e.altaContrato() +
			           " ID: " + e.id() + ". " +
			           e.sigId());
		}
	}
}

class Empleado implements Comparable, Trabajadores {
	public Empleado(String nom, double sue, int anio, int mes, int dia) {
		nombre=nom;
		sueldo=sue;
		GregorianCalendar fecha=new GregorianCalendar(anio, mes-1, dia); 
		altaContrato=fecha.getTime();
		id=siguienteId;
		siguienteId++;
		
	}
	
	public Empleado(String nom) {
		this(nom, 30000, 2000, 01, 01);
	}
	
	public String nombre() {
		return nombre;
	}
	
	public double sueldo() {
		return sueldo;
	}
	
	public Date altaContrato() {
		return altaContrato;
	}
	
	public int id() {
		return id;
	}
	
	public void subirSueldo(double porcentaje) {
		double aumento=sueldo*porcentaje/100;
		sueldo=sueldo+aumento;
	}
	
	public static String sigId() {
		return "El siguiente id es: " + siguienteId;
	}
	
	public int compareTo(Object miObj) {
		Empleado otroEmpleado=(Empleado) miObj;
		if (this.sueldo < otroEmpleado.sueldo) {
			return -1;
		} 
		
		if (this.sueldo > otroEmpleado.sueldo) {
			return 1;
		}		
		return 0;
	}
	
	public double establece_bonus(double gratificacion) {
		return Trabajadores.bonus_base+gratificacion;
	}
	
	private final String nombre;
	private double sueldo;
	private Date altaContrato;
	private int id;
	private static int siguienteId;
	
}
 
class Jefatura extends Empleado implements Jefes{
	public Jefatura(String nom, double sue, int anio, int mes, int dia) {
		super(nom, sue, anio, mes, dia);
	}
	
	public void estableceIncentivo(double inc) {
		incentivo=inc;
	}
	
	public double sueldo() {
//		double sueldoJefe=sueldo(); 
//      No es correcto porque no sabe a cual de los dos tiene que llamar
//      queremos indicar que almacene lo que devuelve el metodo de la clase padre:
		
		double sueldo=super.sueldo();
		return sueldo+incentivo;
	}
	
	public String tomarDecisiones(String decision) {
		return "Ha tomado la decisión de: " + decision;
	}
	
	public double establece_bonus(double gratificacion) {
		double prima=2000;
		return Trabajadores.bonus_base+gratificacion+prima;
	}
	
	private double incentivo;
}

class Director extends Jefatura{
	public Director(String nom,double sue,int anio,int mes,int dia) {
		super(nom, sue, anio, mes, dia);
	}
}










