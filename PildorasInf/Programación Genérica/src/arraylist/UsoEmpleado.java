package arraylist;

import java.util.ArrayList;
import java.util.Iterator;



public class UsoEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Empleado lista[]=new Empleado[3];
//		
//		lista[0]=new Empleado("Ana",45,2500);
//		lista[1]=new Empleado("Antonio",55,2000);
//		lista[2]=new Empleado("Maria",25,2600);
//		
//		for (Empleado empleado : lista) {
//			System.out.println(empleado.datos());
//		}
		
		ArrayList<Empleado> listaEmpleados=new ArrayList<Empleado>();
		
//		listaEmpleados.ensureCapacity(15); 
		
		listaEmpleados.add(new Empleado("Ana",45,2500));
		listaEmpleados.add(new Empleado("Antonio",55,2000));
		listaEmpleados.add(new Empleado("Maria",25,2600));
		listaEmpleados.add(new Empleado("Jose",35,2200));
		listaEmpleados.set(1, new Empleado("Olga",37,2100));
		
//		listaEmpleados.trimToSize();
		
//		System.out.println(listaEmpleados.size());
		
//		System.out.println(listaEmpleados.get(1).datos());
		
//		for (Empleado empleado : listaEmpleados) {
//			System.out.println(empleado.datos());
//		}
		
//		for (int i = 0; i < listaEmpleados.size(); i++) {
//			Empleado e=listaEmpleados.get(i);
//			e.datos();
//		}
		
		
		Iterator <Empleado> iterador = listaEmpleados.iterator();
		
		while(iterador.hasNext()) {
			System.out.println(iterador.next().datos());
		}
		
//		Empleado arrayEmpleados[]=new Empleado[listaEmpleados.size()];
//		
//		listaEmpleados.toArray(arrayEmpleados);
//		
//		for (int i = 0; i < arrayEmpleados.length; i++) {
//			System.out.println(arrayEmpleados[i].datos());
//		}
		
		
	}

}

class Empleado{
	
	public Empleado(String nombre, int edad, double salario) {
		this.nombre=nombre;
		this.edad=edad;
		this.salario=salario;
	}
	
	public String datos() {
		return "El empleado de nombre "+nombre+" tiene "+edad+" años y gana "+salario;
	}
	
	private String nombre;
	private int edad;
	private double salario;
}