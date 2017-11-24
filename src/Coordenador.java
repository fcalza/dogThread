import java.util.List;

public class Coordenador implements Runnable {

	private List<Cachorro> cachorros;

	public Coordenador(List<Cachorro> cachorros) {
		this.cachorros = cachorros;
	}

	public void run() {
		token();
	}

	public void token() {
		int count = 0;

		while (true) {

			if (cachorros.get(count).requestToken == 1) {
				cachorros.get(count).token = 1;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cachorros.get(count).token = 0;
			}
			count++;
			if (count == cachorros.size()) {
				count = 0;
			}

		}
	}
}
