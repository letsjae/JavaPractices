package es.jey.ioc;

public class SecretarioEmpleado implements Empleados {
	
	private CreacionInformes informeNuevo;
	
	public void setInformeNuevo(CreacionInformes informeNuevo) {
		
		this.informeNuevo = informeNuevo;
		
	}

	@Override
	public String getTareas() {
		
		return "Gestionar la agenda de los jefes";
		
	}

	@Override
	public String getInforme() {

		return "Informe generado por el secretario: " + informeNuevo.getInforme();
		
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
	
	private String email;
	
	private String nombreEmpresa;

}
