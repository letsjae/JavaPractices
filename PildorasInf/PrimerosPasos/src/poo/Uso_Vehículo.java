package poo;

public class Uso_Vehículo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//      Instanciar una clase, ejemplar de clase
//		Coche Renault = new Coche(); 
		
//		System.out.println("Este coche tiene " + Renault.ruedas + " ruedas");
		
//		System.out.println(Renault.dame_el_largo());
		
//		Coche micoche = new Coche();
//		
//		micoche.establece_color("amarillo");
//		
//		System.out.println(micoche.datos_generales());
//		System.out.println(micoche.dame_el_color());
//		
//		micoche.configura_asientos("no");
//		System.out.println(micoche.dime_asientos());
		
		Coche micoche1 = new Coche();
		micoche1.establece_color("verde");
		
		Camion micamion1= new Camion(7, 580);
		
		micamion1.establece_color("azul");
		
		micamion1.configura_asientos("si");
		
		
	}

}
