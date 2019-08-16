package poo;

public class Camion extends Coche{
	private int capacidad_carga;
	private int plazas_extra;
	
	public Camion(int capacidad_carga, int plazas_extra) {
		super(); // llama al constructor del padre
		this.capacidad_carga=capacidad_carga;
		this.plazas_extra=plazas_extra;
	}
	
	public String datos_furgoneta() {
		return "La capacidad de carga es " + capacidad_carga + " y las plazas son " + plazas_extra;
	}
}
