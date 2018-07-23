public abstract class Cuenta {
	protected long numeroDeCuenta;
	protected long saldo;
	protected String titular;
	
	public void depositar(long monto) {
		saldo += monto;
	}
	
	public void extraer(long monto) throws RuntimeException {
		if (monto > this.saldoDisponible()) {
			throw new RuntimeException("No hay dinero suficiente");
		}
	}
	
	public long saldoDisponible() {
		return saldo;
	}
}


