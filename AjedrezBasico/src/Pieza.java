public abstract class Pieza {
	boolean enJuego = true;
	protected int posicionFila;
	protected int posicionColumna;
	
	public void eliminada() {
		this.enJuego = false;
	}
	
	public void seleccionadaPorCoronar() {
		this.enJuego = true;
	}
	
	public boolean estaEnTablero() {
		return this.enJuego;
	}
	
	public void posicionar(int enFila, int enColumna)  throws RuntimeException {
		if (enFila > 8  || enColumna > 8 || enFila < 0  || enColumna < 0 ) {
			throw new RuntimeException("Una de las posiciones indicadas es incorrecta");
		} else { 
			this.posicionFila = enFila;
			this.posicionColumna = enColumna;
		}
	}
	
	public void movimiento(int irAFila, int irAColumna) {
		
	}
}


