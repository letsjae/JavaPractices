public class Peon extends Pieza {
	
	public void coronar(Pieza piezaQueSuplanta) {
		this.eliminada();
		piezaQueSuplanta.seleccionadaPorCoronar();
		piezaQueSuplanta.posicionar(this.posicionFila, this.posicionColumna);
	}	
}
