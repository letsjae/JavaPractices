package macowins;

public class Prenda{
	public String tipoprenda;
	public Float precio;
	public EstadoPrenda estadoPrenda;
		
	//Constructore de la prenda:
	
	public Prenda(Float precio, String tipoprenda, EstadoPrenda estadoPrenda) {
		this.tipoprenda = tipoprenda;
		this.precio = precio;
		this.estadoPrenda = estadoPrenda;
	}

	public String getTipoprenda() {
		return tipoprenda;
	}

	public void setTipoprenda(String tipoprenda) {
		this.tipoprenda = tipoprenda;
	}

	public Float getPrecio() {
		return estadoPrenda.modificarPrecio(precio);
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public EstadoPrenda getEstadoPrenda() {
		return estadoPrenda;
	}

	public void setEstadoPrenda(EstadoPrenda estadoPrenda) {
		this.estadoPrenda = estadoPrenda;
	}
	
	
}
