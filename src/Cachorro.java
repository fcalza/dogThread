import java.util.Random;


/*TODO
caminhos de referencias conforme a imagem do moodle - ok
criar dois cachorros de cada cor
limitar o numero de moedas em 20 por cachorro e no máximo 50 somando caçador + cachorro


*/
class Cachorro implements Runnable {
	String cor;
	int n_moedas;
	Bosque bosque;
	Pote pote_atual;
	int token;
	int requestToken;
	Thread t;

	public Cachorro(String cor, Bosque bosque) {
		this.cor = cor;
		this.bosque = bosque;
		this.t = Thread.currentThread();
		this.n_moedas = 0;
		this.token = 0;
		this.requestToken = 0;
	}

	public void run() {
		System.out.println("Cachorro de cor " + cor + " começou a caçar! ");
		requestToken = 1;
		
		this.proximoPote();

		this.cacar();
	}

	public void dormir(int xTempo) {
		try {
			Thread.sleep(100 * xTempo);
		} catch (InterruptedException e) {
                    //quanto não tem mais moedas no pote (quantidade nMoedas = 0)
			System.out.println(Thread.currentThread() + " sofreu interrupt! ---"); 
			while (token != 1) {
				System.out
						.println(Thread.currentThread() + " esperando sinal depois do interrupt. ---");
				dormir(1);
			}
			
			if (pote_atual.getCachorroAtual() == null) {
				pote_atual.setCachorroAtual(Thread.currentThread());

				if (pote_atual.getD1() == Thread.currentThread()) {
					pote_atual.setD1(null);
				} else if (pote_atual.getD2() == Thread.currentThread()) {
					pote_atual.setD2(null);
				} else if (pote_atual.getD3() == Thread.currentThread()) {
					pote_atual.setD3(null);
				}
				
				
				cacar();
			} else {
				dormir(06);
			}
		}
	}

	public int gerarNumero() {
		Random gerador = new Random();
		int numeroAleatorio = gerador.nextInt(pote_atual.getQuantidadeReferencias());
		
                System.out.println(Thread.currentThread() + " O número aleatório gerado foi: " + numeroAleatorio);
		
                return numeroAleatorio;
	}

	public void proximoPote() {
		dormir(1);
		
		if (pote_atual == null) {
			pote_atual = bosque.getPotes().get(0); // entra no bosque
		} else {
			pote_atual = pote_atual.getProximoPote(gerarNumero());
		}
		
		
		if (pote_atual.getCachorroAtual() == null) {

			while (token != 1) {
				System.out
						.println(Thread.currentThread().getName() + " esperando sinal.");
				dormir(1);
			}
		} 
		if (pote_atual.getCachorroAtual() == null) { // verifica se ja tem algum
			// cachorro no pote 0
			pote_atual.setCachorroAtual(Thread.currentThread()); // se não tiver
																	// ele
																	// entra
			//bosque.liberaToken();

			System.out
					.println("A thread " + Thread.currentThread().getName()
							+ " ENTROU no pote "
							+ bosque.getPotes().indexOf(pote_atual)
                                                    + ". Quantidade de moedas no pote: " + pote_atual.getnMoedas());
		} else if (pote_atual.getCachorroAtual() != null) {

			/*System.out
					.println("A thread " + Thread.currentThread().getName()
							+ " saiu do pote: "
							+ bosque.getPotes().indexOf(pote_atual));*/
			proximoPote();
		}

		/*
		 * dormir(1); pote_atual = pote_atual.getProximoPote(gerarNumero()); if
		 * (pote_atual.getCachorroAtual() == null) {
		 * pote_atual.setCachorroAtual(Thread.currentThread()); System.out
		 * .println("A thread " + Thread.currentThread().getName() +
		 * " está no pote: " + bosque.getPotes().indexOf(pote_atual)); } else {
		 * System.out .println("A thread " + Thread.currentThread().getName() +
		 * " saiu do pote: " + bosque.getPotes().indexOf(pote_atual));
		 * proximoPote(); }
		 */
	}

	public void cacar() {
		int i = bosque.pegarMoeda(pote_atual);
		if (i == 0) {
			if (pote_atual.getD1() == null) {
				pote_atual.setD1(Thread.currentThread());
				pote_atual.setCachorroAtual(null);
				dormir(6);
				pote_atual.setD1(null); // garantia se voltar sem interrupt

			} else if (pote_atual.getD2() == null) {
				pote_atual.setD2(Thread.currentThread());
				pote_atual.setCachorroAtual(null);
				dormir(6);
				pote_atual.setD2(null); // garantia se voltar sem interrupt

			} else if (pote_atual.getD3() == null) {
				pote_atual.setD3(Thread.currentThread());
				pote_atual.setCachorroAtual(null);
				dormir(6);
				pote_atual.setD3(null); // garantia se voltar sem interrupt
			}
		} else {
			n_moedas = n_moedas + i;
			System.out.println("A thread: " + Thread.currentThread().getName()
					+ " tem " + n_moedas + " moedas! ");

			if (n_moedas < 20 ) {
				pote_atual.setCachorroAtual(null);
				System.out.println("A thread "
						+ Thread.currentThread().getName() + " SAIU do pote "
						+ bosque.getPotes().indexOf(pote_atual));
				
				proximoPote();
				cacar();

			} else {
				pote_atual.setCachorroAtual(null);
				System.out.println("A thread "
						+ Thread.currentThread().getName() + " SAIU do pote "
						+ bosque.getPotes().indexOf(pote_atual));
				
				requestToken = 0;
				bosque.retornaMoeda(n_moedas, cor);
				Thread.yield();
			}

		}

	}
}
