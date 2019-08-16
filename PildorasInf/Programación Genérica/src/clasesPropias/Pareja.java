package clasesPropias;

public class Pareja <T>{

	public Pareja() {
		primero=null;
	}
	
	public void setPrimero(T nuevoValor) {
		primero=nuevoValor;
	}
	
	public T getPrimero() {
		return primero;
	}
	
	public static void imprimirTrabajador(Pareja <? extends Empleado> e) {
		Empleado primero=e.getPrimero();
		System.out.println(primero);
	}
	
	private T primero;
}
 