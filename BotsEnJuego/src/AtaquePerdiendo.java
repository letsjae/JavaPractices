public class AtaquePerdiendo implements EstrategiaDeAtaque {
	public void estrategiaATomar(BOT unBot) {
		unBot.setNivelAtaque(0);
		System.out.println("Ya no puedo atacar mas :( ");
	}
}

