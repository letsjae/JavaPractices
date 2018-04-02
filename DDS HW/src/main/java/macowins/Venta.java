package macowins;

import java.util.Date;
import java.util.List;

abstract public class Venta {
	private List<ItemVenta> items;
	private Date fechaDeVenta;
	private String tipoPago;
	//private PrecioFinal preciofinal;
	
	public Venta(List<ItemVenta> items, Date fechaDeVenta) {
		this.items = items;
		this.fechaDeVenta = fechaDeVenta;
	}
	
	
}
