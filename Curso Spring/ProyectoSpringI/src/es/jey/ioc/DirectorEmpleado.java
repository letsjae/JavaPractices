package es.jey.ioc;

public class DirectorEmpleado implements Empleados {

	
	// Creación de campo tipo cracionInforme (interfaz)
	
	private CreacionInformes informeNuevo;
	
	// Creación de constructor que inyecta la dependencia
	
	public DirectorEmpleado(CreacionInformes informeNuevo ) {
		
		this.informeNuevo=informeNuevo;
	
	}
	
	
	@Override
	public String getTareas() {
		
		return "Gestionar la plantilla de la empresa";
	
	}

	@Override
	public String getInforme() {
		
		return "Informe creado por el director: " + informeNuevo.getInforme();
	
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	
	// método init -> encargado de ejecutar tareas antes de que el bean esté disponible
	
	public void metodoInicial() {
		
		System.out.println("Dentro del método init, irían las tareas a ejecutar antes de que el bean esté disponible");
		
	}
	
	// método destroy -> encargado de ejecutar tareas después de que el bean haya sido utilizado
	
	public void metodoFinal() {
		
		System.out.println("Dentro del método destroy, irían las tareas a ejecutar después de que el bean fue utilizado");
		
	}

	private String email;
	
	private String nombreEmpresa;

}
