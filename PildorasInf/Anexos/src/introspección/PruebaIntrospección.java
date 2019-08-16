package introspección;

import java.lang.reflect.*;
import java.util.*;

public class PruebaIntrospección {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entrada=new Scanner(System.in);
		
		System.out.println("Introduce nombre de la clase: ");
		
		String nombreClase;
		
		nombreClase=entrada.next();
		
		// Imprimir clase y super clase
		
		try {
			
			Class clase=Class.forName(nombreClase);
			
			Class superCl=clase.getSuperclass();
			
			System.out.println("Clase: " + nombreClase);
			
			if(superCl!=null && superCl!=Object.class) {
				
				System.out.println(" Extends " + superCl.getName());
				
			}
			
			System.out.println();
			
			imprimirConstructores(clase);
			
			System.out.println();
			
			imprimirMetodos(clase);
			
			System.out.println();
			
			imprimirCampos(clase);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			System.exit(0);
			
		}
		
	}
	
	public static void imprimirConstructores(Class clase) {
		
		Constructor[] constructores=clase.getDeclaredConstructors();
		
		for (Constructor c : constructores) {
			
			String nombre=c.getName();
			
			System.out.print("   "+Modifier.toString(c.getModifiers()));
			
			System.out.print(" "+nombre+"(");
			
			// Imprimir parámetros
			
			Class[] tipoParams=c.getParameterTypes();
			
			for (int i = 0; i < tipoParams.length; i++) {
				
				if(i>0) System.out.print(", ");
				
				System.out.print(tipoParams[i].getName());
				
			}
			
			System.out.print(");");
		}
		
	}
	
	// Imprime todos los metodos de la clase
	
	public static void imprimirMetodos(Class clase) {
		
		Method [] metodos=clase.getDeclaredMethods();
		
		System.out.println("METODOS");
		
		for (Method m : metodos) {
			
			//Tipo que devuelve el método
			
			Class tipoDevuelto=m.getReturnType();
			
			String nombre=m.getName();
			
			// Imprime modificadores + tipo + nombre
			
			System.out.print("   " + Modifier.toString(m.getModifiers()));
			
			System.out.print(" " + tipoDevuelto.getName() + " " + nombre + "(");
			
			// Imprimir tipo de parámetros
			
			Class[] tipoParams=m.getParameterTypes();
			
			for (int i = 0; i < tipoParams.length; i++) {
				
				if(i>0) System.out.print(", ");
				
				System.out.print(tipoParams[i].getName());
			}
			
			System.out.println(");");
			
		}
		
	}
	
	// Imprime los campos de la clase
	
	public static void imprimirCampos(Class clase) {
		
		Field [] camposDeClase=clase.getDeclaredFields();
		
		System.out.println("CAMPOS DE CLASE");
		
		for (Field f : camposDeClase) {
			
			Class tipoCampo=f.getType();
			
			String nombre=f.getName();
			
			System.out.print("   " + Modifier.toString(f.getModifiers()));
			
			System.out.print(" " + tipoCampo.getName() + " " + nombre);

			System.out.println(");");
		}
		
	}

}
