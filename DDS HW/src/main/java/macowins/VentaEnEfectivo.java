package macowins;

import java.util.Date;
import java.util.List;

public class VentaEnEfectivo extends Venta {
	
	public VentaEnEfectivo(Date fecha, List<ItemVenta> items) {
		super(fecha, items);
}
	
	public Float importeTotal() {
		return this.importeTotal();
	}
}
