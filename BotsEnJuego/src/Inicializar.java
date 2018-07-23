public class Inicializar implements State {
	
	@Override
	public void manejarEstado(BOT unBot) {
		unBot.setNivelDeVida(100);
	}
}


