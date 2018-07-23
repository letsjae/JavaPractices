public class Perdiendo implements State{
	@Override
	public void manejarEstado(BOT unBot) {
		unBot.setNivelDeVida(50);
	}
}


