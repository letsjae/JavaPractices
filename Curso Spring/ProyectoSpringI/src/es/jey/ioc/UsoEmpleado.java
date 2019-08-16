package es.jey.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creación de objetos de tipo Empleado
		
		// Abstracción de objetos
		
//		Empleados empleadoI=new DirectorEmpleado();
		
		
		// Uso de los objetos creados
		
//		System.out.println(empleadoI.getTareas());
		
		// Pasos a seguir para usar el contenedor
		
		ClassPathXmlApplicationContext contexto= new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		Empleados jey=contexto.getBean("miEmpleado", Empleados.class);
		
//		System.out.println(jey.getTareas());
		
		// Utilizando la inyección
		
//		System.out.println(jey.getInforme());
		
		SecretarioEmpleado secretariaJey=contexto.getBean("secretarioEmpleado", SecretarioEmpleado.class);
		
		System.out.println(secretariaJey.getTareas());
		
		System.out.println(secretariaJey.getInforme());
		
		System.out.println("Email: " + secretariaJey.getEmail());
		
		System.out.println(secretariaJey.getNombreEmpresa());
		
		SecretarioEmpleado secretariaAnuka=contexto.getBean("secretarioEmpleado", SecretarioEmpleado.class);
		
		System.out.println(secretariaAnuka.getEmail());
		
		DirectorEmpleado directoraNinfa=contexto.getBean("miEmpleado", DirectorEmpleado.class);
		
		System.out.println(directoraNinfa.getEmail());
		
		System.out.println(directoraNinfa.getNombreEmpresa());
		
		contexto.close(); 
	}

}
