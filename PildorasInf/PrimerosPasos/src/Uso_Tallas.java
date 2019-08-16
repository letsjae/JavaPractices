import java.util.Scanner;

public class Uso_Tallas {

//	enum Talla {MINI, MEDIANO, GRANDE, MUY_GRANDE};
	
	enum Talla { 
		MINI("S"), MEDIANO("M"), GRANDE("L"), MUY_GRANDE("XL");
		
		private Talla(String abreviatura) {
			this.abreviatura=abreviatura;					
		}
		
		public String obtenerAbreviatura() {
			return abreviatura;
		}
		
		private String abreviatura;
		
	}
	
	enum meses {
		// Constantes de enumeración, cada una es un miembro público y estático
		ENERO("ENE"),
		FEBRERO("FEB"),
		MARZO("MAR"),
		ABRIL("ABR"),
		MAYO("MAY"),
        JUNIO("JUN"),
        JULIO("JUL"),
        AGOSTO("AGO"),
        SEPTIEMBRE("SEP"),
        OCUBRE("OCT"),
        NOVIEMBRE("NOV"),
        DICIEMBRE("DIC");
		
		private meses(String abreviatura) {
			this.abreviatura=abreviatura;
		}
		
		private String abreviatura;
		
		public String abreviatura() {
			return abreviatura;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Talla s=Talla.MINI;
//		Talla m=Talla.MEDIANO;
//		Talla l=Talla.GRANDE;
//		Talla xl=Talla.MUY_GRANDE;
		
//		Scanner entrada = new Scanner(System.in);
//		
//		System.out.println("Escribir una talla: MINI, MEDIANO, GRANDE, MUY_GRANDE");
//		
//		String entrada_datos=entrada.nextLine().toUpperCase();
//		
//		Talla la_talla=Enum.valueOf(Talla.class, entrada_datos);
//		
//		System.out.println("Talla=" + la_talla);
//		
//		System.out.println("Abreviatura=" + la_talla.abreviatura); 
		
		meses mes=Enum.valueOf(meses.class, "ENERO");
		
		System.out.println(mes.abreviatura);
		
		meses arr[] = meses.values();
		
		for(meses m: arr) {
			System.out.println(m + " está en el índice " + m.ordinal());
		}
		
		System.out.println(meses.valueOf("JULIO"));
		
		
		
	}

}
