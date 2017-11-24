
public class Cacador {
	String cor;
	int qntdMoedas;
	
	public Cacador(String cor) {
		super();
		this.cor = cor;
		this.qntdMoedas = 0;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getQntdMoedas() {
		return qntdMoedas;
	}

	
	public void addMoedas(int moedas){
		qntdMoedas = qntdMoedas + moedas;
		System.out.println("O caçador de cor " + cor + " recebeu " + moedas + " moedas! Total: " + qntdMoedas);
	}
	
}
