package es.jey.pruebaAnnotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoAnnotationsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		ClassPathXmlApplicationContext contexto= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// leer el class de configuración
		
		AnnotationConfigApplicationContext contexto=new AnnotationConfigApplicationContext(EmpleadosConfig.class);
		
		/*
		Empleados jey=contexto.getBean("ComercialExperimentado", Empleados.class);
		
		Empleados anuka=contexto.getBean("ComercialExperimentado", Empleados.class);
		
		if(jey==anuka) {
			System.out.println("Apuntan al mismo lugar en memoria");
			System.out.println(jey + "\n" + anuka);
		} else {
			System.out.println("No apuntan al mismo lugar en memoria");
			System.out.println(jey + "\n" + anuka);
		}*/
		
		/*Empleados empleado=contexto.getBean("directorFinanciero", Empleados.class);
		
		System.out.println(empleado.getTareas());
		
		System.out.println(empleado.getInforme());*/
		
		DirectorFinanciero empleado=contexto.getBean("directorFinanciero", DirectorFinanciero.class);
		
		System.out.println("Email de la dirección: " + empleado.getEmail());
		
		System.out.println("Nombre de la empresa: " + empleado.getNombreEmpresa());
		
		contexto.close();
		
	}

}
