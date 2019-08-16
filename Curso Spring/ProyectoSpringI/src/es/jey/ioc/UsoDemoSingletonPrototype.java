package es.jey.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoDemoSingletonPrototype {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext contexto= new ClassPathXmlApplicationContext("applicationContextI.xml");
		
		// Peticion de beans al contenedor Spring
		
		SecretarioEmpleado secretariaJey=contexto.getBean("secretarioEmpleado", SecretarioEmpleado.class);
		
		SecretarioEmpleado secretariaAnuka=contexto.getBean("secretarioEmpleado", SecretarioEmpleado.class);
		
		System.out.println(secretariaJey);
		
		System.out.println(secretariaAnuka);
		
		if(secretariaAnuka==secretariaJey) System.out.println("Apuntan al mismo objeto");
		else System.out.println("No apuntan al mismo objeto");
		
		
	}

}
