import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Bosque {

	private List<Pote> potes;
	private static Bosque instance;
	private Cacador cacador_amarelo, cacador_verde, cacador_azul;
	private List<Cacador> podio = new ArrayList<Cacador>();
	private List<Cachorro> cachorros = new ArrayList<Cachorro>();
	Cachorro c;
	
	
	public static Bosque getInstance() {
		if (instance == null) {
			System.out.println("-------------------------- Bosque criado!");
			instance = new Bosque();
		}

		return instance;
	}

	protected Bosque() {

		super();

		potes = new ArrayList<Pote>();

		for (int i = 0; i < 20; i++) {
			potes.add(new Pote(4));
		}

		List<Pote> referencias;

                //todo referencias de caminhos conforme imagem do moodle
		referencias = new ArrayList<Pote>(Arrays.asList(potes.get(1),
				potes.get(14)));
		potes.get(0).setReferencias(referencias);

		referencias = new ArrayList<Pote>(Arrays.asList(potes.get(0),
				potes.get(2), potes.get(3), potes.get(4)));
		potes.get(1).setReferencias(referencias);

		referencias = new ArrayList<Pote>(Arrays.asList(potes.get(1),
				potes.get(8)));
		potes.get(2).setReferencias(referencias);

		referencias = new ArrayList<Pote>(Arrays.asList(potes.get(1),
				potes.get(8), potes.get(9)));
		potes.get(3).setReferencias(referencias);

		referencias = new ArrayList<Pote>(Arrays.asList(potes.get(1),
				potes.get(5)));
		potes.get(4).setReferencias(referencias);

		referencias = new ArrayList<Pote>(Arrays.asList(potes.get(4),
				potes.get(6), potes.get(7)));
		potes.get(5).setReferencias(referencias);

		referencias = new ArrayList<Pote>(Arrays.asList(potes.get(5)));
		potes.get(6).setReferencias(referencias);

		referencias = new ArrayList<Pote>(Arrays.asList(potes.get(5)));
		potes.get(7).setReferencias(referencias);

		referencias = new ArrayList<Pote>(Arrays.asList(potes.get(2),
				potes.get(3), potes.get(14), potes.get(17)));
		potes.get(8).setReferencias(referencias);

		referencias = new ArrayList<Pote>(Arrays.asList(potes.get(3),
				potes.get(11)));
		potes.get(9).setReferencias(referencias);

                referencias = new ArrayList<>(Arrays.asList(potes.get(11), potes.get(16)));
                potes.get(10).setReferencias(referencias);
                
		referencias = new ArrayList<Pote>(Arrays.asList(potes.get(9),
				potes.get(10), potes.get(12)));
		potes.get(11).setReferencias(referencias);

		referencias = new ArrayList<Pote>(Arrays.asList(potes.get(11)));
		potes.get(12).setReferencias(referencias);

		referencias = new ArrayList<Pote>(Arrays.asList(potes.get(10),
				potes.get(15)));
		potes.get(13).setReferencias(referencias);

		referencias = new ArrayList<Pote>(Arrays.asList(potes.get(0),
				potes.get(8)));
		potes.get(14).setReferencias(referencias);

		referencias = new ArrayList<Pote>(Arrays.asList(potes.get(13),
				potes.get(17), potes.get(19)));
		potes.get(15).setReferencias(referencias);

		referencias = new ArrayList<Pote>(Arrays.asList(potes.get(10),
				potes.get(15)));
		potes.get(16).setReferencias(referencias);

		referencias = new ArrayList<Pote>(Arrays.asList(potes.get(8),
				potes.get(15), potes.get(18)));
		potes.get(17).setReferencias(referencias);

		referencias = new ArrayList<Pote>(Arrays.asList(potes.get(17),
				potes.get(19)));
		potes.get(18).setReferencias(referencias);

		referencias = new ArrayList<Pote>(Arrays.asList(potes.get(15),
				potes.get(18)));
		potes.get(19).setReferencias(referencias);

		System.out.println("-------------------------- Potes criados!");

		cacador_amarelo = new Cacador("amarelo");
		cacador_azul = new Cacador("azul");
		cacador_verde = new Cacador("verde");

		System.out.println("-------------------------- Caçadores criados!");

	}

	public void iniciaJogo() {
		/*
		 * Thread t1 = new Thread(new Cachorro("amarelo", instance)); Thread t2
		 * = new Thread(new Cachorro("azul", instance)); Thread t3 = new
		 * Thread(new Cachorro("verde", instance));
		 * 
		 * t1.start(); t2.start(); t3.start();
		 */
		/*
		 * ExecutorService threadPool = Executors.newFixedThreadPool(4);
		 * CompletionService<Long> pool = new ExecutorCompletionService<Long>(
		 * threadPool); for (int i = 0; i < 10; i++) {
		 * pool.submit((Callable<Long>) new Cachorro("amarelo", instance)); }
		 * 
		 * ExecutorService executa = Executors.newSingleThreadExecutor();
		 * ExecutorService executa1 = Executors.newSingleThreadExecutor();
		 * ExecutorService executa2 = Executors.newSingleThreadExecutor();
		 */
		ExecutorService executa1 = Executors.newFixedThreadPool(1);
		ExecutorService executa2 = Executors.newFixedThreadPool(1);
		ExecutorService executa3 = Executors.newFixedThreadPool(1);
		ExecutorService executa4 = Executors.newFixedThreadPool(1);
		ExecutorService executa5 = Executors.newFixedThreadPool(1);
		ExecutorService executa6 = Executors.newFixedThreadPool(1);
		
                
                
		// ExecutorService executa = Executors.newCachedThreadPool();
		for (int i = 0; i < 3; i++) {
			// Cria e executa as threads
			executa1.execute(c = new Cachorro("amarelo", instance));
			c.t.setName("Cachorro Amarelo");
			cachorros.add(c);
			executa2.execute(c = new Cachorro("verde", instance));
			c.t.setName("Cachorro Verde");
			cachorros.add(c);
			executa3.execute(c = new Cachorro("azul", instance));
			c.t.setName("Cachorro Azul");
			cachorros.add(c);
//                        // Cria e executa as threads
//			executa3.execute(c = new Cachorro("amarelo dois", instance));
//			c.t.setName("Cachorro Amarelo 2");
//			cachorros.add(c);
                        
		}
		// Encerra o executor assim que as threads terminarem
		//executa.shutdown();
		
		//liberaToken();
		
		/*ScheduledExecutorService exec1 = Executors
				.newSingleThreadScheduledExecutor();
		exec1.scheduleAtFixedRate(new Coordenador(cachorros), 0, 2000,
				TimeUnit.MILLISECONDS);*/
		Thread coordenador = new Thread(new Coordenador(cachorros));
		coordenador.start();
		
		ScheduledExecutorService exec = Executors
				.newSingleThreadScheduledExecutor();
		exec.scheduleAtFixedRate(new CachorroVermelho(instance), 0, 200,
				TimeUnit.MILLISECONDS);
		
		
	}

	public List<Pote> getPotes() {
		return potes;
	}

	public void colocarMoedas() {
		for (Pote pote : potes) {
			if (pote.getnMoedas() == 0) {
				pote.setnMoedas(1);

				if (pote.getD1() != null) {
					pote.getD1().interrupt();
				}
				if (pote.getD2() != null) {
					pote.getD2().interrupt();
				}
				if (pote.getD3() != null) {
					pote.getD3().interrupt();
				}

			}
		}
	}

	public int pegarMoeda(Pote pote) {
		if (pote.getnMoedas() >= 3) {
			pote.setnMoedas(pote.getnMoedas() - 3);
			return 3;
		} else if (pote.getnMoedas() == 2) {
			pote.setnMoedas(pote.getnMoedas() - 2);
			return 2;
		} else if (pote.getnMoedas() == 1) {
			pote.setnMoedas(pote.getnMoedas() - 1);
			return 1;
		}
		return 0;
	}

	public void retornaMoeda(int n_moedas, String cor) {
		switch (cor) {
		case "amarelo":
			cacador_amarelo.addMoedas(n_moedas);
			if (cacador_amarelo.getQntdMoedas() >= 50) {
				podio.add(cacador_amarelo);
			}
			break;

		case "azul":
			cacador_azul.addMoedas(n_moedas);
			if (cacador_azul.getQntdMoedas() >= 50) {
				podio.add(cacador_azul);
			}
			break;

		case "verde":
			cacador_verde.addMoedas(n_moedas);
			if (cacador_verde.getQntdMoedas() >= 50) {
				podio.add(cacador_verde);
			}
			break;

		default:
			break;
		}

		if (podio.size() == 3) {
			finalizaJogo();
		}

	}

	private void finalizaJogo() {
		int i = 1;
		for (Cacador c : podio) {
			System.out.println("\nO caçador de cor " + c.cor + " ficou na " + i
					+ "ª posição com " + c.getQntdMoedas() + " moedas!");
			i++;
		}
		System.out.println("Fim do jogo!");
		System.exit(0);

	}
	
	//implementação token//
	
	public void liberaToken() {
		
		
	}

}
