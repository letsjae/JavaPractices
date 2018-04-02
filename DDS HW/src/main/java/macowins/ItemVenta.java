package macowins;

public class ItemVenta {
	private Prenda prenda;
	private int cantidad;
	
		
	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Float importe(){
		return prenda.getPrecio()*cantidad;
	}
}
