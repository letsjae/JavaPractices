public class CuantaCorriente extends Cuenta {
	private long descubiertoAcordado;
	
	public CuantaCorriente(long unDescubiertoAcordado, String unTitular, long unNumCuenta) {
		this.descubiertoAcordado = unDescubiertoAcordado;
		this.titular = unTitular;
		this.numeroDeCuenta = unNumCuenta;
	}
	
	@Override
	public long saldoDisponible() {
		return this.saldo + this.descubiertoAcordado;
	}
}


