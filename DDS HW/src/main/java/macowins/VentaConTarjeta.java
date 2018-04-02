package macowins;

import java.util.Date;
import java.util.List;

public class VentaConTarjeta extends Venta {
		
	private Integer cuotas;
	private Integer coeficienteFijo;
	
	public VentaConTarjeta(Date fecha, List<ItemVenta> items, Integer cuotas, Integer coeficienteFijo) {
		super(fecha, items);
		this.cuotas = cuotas;
		this.coeficienteFijo = coeficienteFijo;
	}
	
	public VentaConTarjeta(Date fecha, List<ItemVenta> items) {
			super(fecha, items);
	}
		
	public Float importeTotal() {
			return precioTotal() + recargo();
		}
	
	public Float recargo() {
		Float valorDeCadaPrenda;
		valorDeCadaPrenda = getItems().stream().map(item -> item.importe() * 0.1f).reduce(0f, Float::sum);
		return cuotas * coeficienteFijo + valorDeCadaPrenda;
	}
}
	
