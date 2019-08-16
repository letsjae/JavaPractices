package es.jey.ioc;

public class JefeEmpleado implements Empleados{

	private CreacionInformes informeNuevo;	
	
	public JefeEmpleado(CreacionInformes informeNuevo) {
			
		this.informeNuevo = informeNuevo;
		
	}

	public String getTareas() {
			
		return "Gestionar las cuestiones relativas a mis empleados";
			
	}

	@Override
	public String getInforme() {
		
		return "Informe presentado por el jefe de los empleados con arreglos: " + informeNuevo.getInforme();
	}
		
}
