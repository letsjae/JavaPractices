public class BOT {
	protected State estado;
	protected EstrategiaDeAtaque estretegia;
	protected int nivelDeVida;
	protected int nivelAtaque;
	
	public int getNivelAtaque() {
		return nivelAtaque;
	}
	public void setNivelAtaque(int nivelAtaque) {
		this.nivelAtaque = nivelAtaque;
	}
	public State getEstado() {
		return estado;
	}
	public void setEstado(State estado) {
		this.estado = estado;
	}
	public EstrategiaDeAtaque getEstretegia() {
		return estretegia;
	}
	public void setEstretegia(EstrategiaDeAtaque estretegia) {
		if (this.getEstado() instanceof Inicializar) {
			estretegia = new AtaqueAlInicializar();
		} else if  (this.getEstado() instanceof Atacado) {
			estretegia = new AtaqueAlSerAtacado();
		} else if (this.getEstado() instanceof Perdiendo) {
			estretegia = new AtaquePerdiendo();
		}
	}
	public int getNivelDeVida() {
		return nivelDeVida;
	}
	public void setNivelDeVida(int nivelDeVida) {
		this.nivelDeVida = nivelDeVida;
	}
}

