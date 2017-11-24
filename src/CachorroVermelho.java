public class CachorroVermelho implements Runnable {
	Bosque bosque;

	@Override
	public void run() {
		bosque.colocarMoedas();
	}

	public CachorroVermelho(Bosque bosque) {
		super();
		this.bosque = bosque;
	}

}
