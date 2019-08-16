package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Persona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona[] personas = new Persona[2];
		
		personas[0]=new Empleado2("Luis",50000,2009,02,25);
		personas[1]=new Alumno("Jey","Sistemas");
		
		for(Persona p:personas) {
			 
		}

	}

}

abstract class Persona{
	public Persona(String nom) {
		nombre=nom;
	}
	
	public String nombre() {
		return nombre;
	}
	
	public void nombre(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract String descripcion();
	
	private String nombre;
}

class Empleado2 extends Persona{
	public Empleado2(String nom, double sue, int anio, int mes, int dia) {
		super(nom);
		sueldo=sue;
		GregorianCalendar fecha=new GregorianCalendar(anio, mes-1, dia); 
		altaContrato=fecha.getTime();
		id=siguienteId;
		siguienteId++;
		
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
	
	public String descripcion() {
		return "Este empleado tiene un id= " + id + " con un sueldo= " + sueldo;
	}
	
	
	private double sueldo;
	private Date altaContrato;
	private int id;
	private static int siguienteId;
	
}

class Alumno extends Persona{
	public Alumno(String nom, String carr) {
		super(nom);
		carrera=carr;
	}
	
	public String descripcion() {
		return "Este alumno está estudindo: " + carrera;
	}
	
	private String carrera;
}





