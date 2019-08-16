package es.jey.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoCicloVidaBean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext contexto= new ClassPathXmlApplicationContext("applicationContextII.xml");
		
		Empleados jey=contexto.getBean("miEmpleado", Empleados.class);
		
		System.out.println(jey.getInforme());
		
		contexto.close();
		
	}

}
