package poo;

public class Coche {
	
	// Características comunes:
	private int ruedas;
	private int largo;
	private int ancho;
	private int motor; // cm cúbicos de ese motor
	private int peso_plataforma;
	private String color;
	private int peso_total;
	private boolean asientos_cuero, climatizador;
	
	public Coche() {
		ruedas=4;
		largo=2000;
		ancho=300;
		motor=1600;
		peso_plataforma=500; 
	}
	
	/* private es un modificador de acceso,
	 * lo que permite es el encapsulamiento, 
	 * la variable modificada con private
	 * no puede ser visible ni modificable por otra clase
	 * que no sea la que la crea. 
	 */
	public String datos_generales() {
		return "La plataforma del coche tiene " + ruedas + " ruedas" +
	            ". Mide " + largo + " metros con un ancho de " + ancho + " cm";
	}
	
	public void establece_color(String color_coche) {
		color=color_coche;
	}
	
	public String dame_el_color() {
		return "El color del coche es " + color;
	}
	
	public void configura_asientos(String asientos_cuero) {
		if(asientos_cuero =="si") {
			this.asientos_cuero=true;
		} else {
			this.asientos_cuero=false;
		}
	}
	
	public String dime_asientos() {
		if(asientos_cuero==true) {
			return "El coche tiene asientos de cuero"; 
		} else {
			return "No tiene asientos de cuero";
		}
		
	}
	
	
	
}
