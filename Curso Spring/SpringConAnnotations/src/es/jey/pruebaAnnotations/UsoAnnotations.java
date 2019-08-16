package es.jey.pruebaAnnotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoAnnotations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Leer el xml de configuracion
		
		ClassPathXmlApplicationContext contexto= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Pedir un bean al contenedor
		
		Empleados jey=contexto.getBean("ComercialExperimentado", Empleados.class);
		
		// Usar el bean
		
		System.out.println(jey.getInforme());
		
		System.out.println(jey.getTareas());
		
		// Cerrar el contexto
		
		contexto.close();

	}

}
