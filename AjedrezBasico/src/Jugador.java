import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Jugador {
	
	List<Pieza> piezas = new ArrayList<Pieza>();
	
	public List<Pieza> piezasDisponiblesParaCoronar() {
		List<Pieza> listaAuxiliar =  piezas.stream().filter(pieza -> pieza.estaEnTablero()).collect(Collectors.toList());
		return listaAuxiliar;
	}
	
	public void coronarPeon(Peon unPeon) {
		Pieza piezaElegida;
		int eleccion = 0;
		
		piezaElegida = this.seleccionarUnaPiezaParaCoronar(this.piezasDisponiblesParaCoronar(), eleccion);
		unPeon.coronar(piezaElegida);
	}
	
	public Pieza seleccionarUnaPiezaParaCoronar(List<Pieza> listaDisponibles, int eleccion) {
		return listaDisponibles.get(eleccion);
	}
}
