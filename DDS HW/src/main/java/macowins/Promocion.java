package macowins;

public class Promocion implements EstadoPrenda {

	private Float descuentoAcordado;
	
	public Promocion(Float descuentoAcordado) {
		super();
		this.descuentoAcordado = descuentoAcordado;
	}
	
	public Float getDescuentoAcordado() {
		return descuentoAcordado;
	}

	public void setDescuentoAcordado(Float descuentoAcordado) {
		this.descuentoAcordado = descuentoAcordado;
	}
	
	public Float modificarPrecio(Float precio) {
		return precio - descuentoAcordado;
	}	
}
