package macowins;

import java.util.Date;
import java.util.List;

abstract public class Venta {
	private List<ItemVenta> items;
	private Date fechaDeVenta;
	private String tipoPago;
	//private PrecioFinal preciofinal;
	
	public Venta(Date fecha, List<ItemVenta> items) {
		this.fechaDeVenta = fecha;
		this.items = items;
	}
	
	public List<ItemVenta> getItems() {
		return items;
	}

	public void setItems(List<ItemVenta> items) {
		this.items = items;
	}

	public Date getFechaDeVenta() {
		return fechaDeVenta;
	}

	public void setFechaDeVenta(Date fechaDeVenta) {
		this.fechaDeVenta = fechaDeVenta;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public Float precioTotal() {
		
		return this.getItems().
				    stream().
				    map(item -> item.importe()).
				    reduce(0f,Float::sum);
	}
}
