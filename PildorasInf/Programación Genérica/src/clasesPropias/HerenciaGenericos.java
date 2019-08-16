package clasesPropias;

public class HerenciaGenericos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Empleado administrativa=new Empleado("Jael", 25, 3500);
//		
//		Jefe directorComercial=new Jefe("Jey", 30, 4500);
//		
//		Empleado nuevoEmpleado=directorComercial;
		
		Pareja<Empleado> administrativa=new Pareja<Empleado>();
		
		Pareja<Jefe> directorio=new Pareja<Jefe>();
		
//		Pareja<Empleado> nuevoEmpleado=directorio;
		
		Pareja.imprimirTrabajador(administrativa);
		
		Pareja.imprimirTrabajador(directorio);
	}

}
