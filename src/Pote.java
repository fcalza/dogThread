/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Calza
 */
import java.util.List;


public class Pote {

	private int nMoedas;
	List<Pote> referencias;
	Thread cachorroAtual, d1, d2, d3;

	public Thread getCachorroAtual() {
		return cachorroAtual;
	}

	public void setCachorroAtual(Thread atual) {
		this.cachorroAtual = atual;
	}

	public Thread getD1() {
		return d1;
	}

	public void setD1(Thread d1) {
		this.d1 = d1;
	}

	public Thread getD2() {
		return d2;
	}

	public void setD2(Thread d2) {
		this.d2 = d2;
	}

	public Thread getD3() {
		return d3;
	}

	public void setD3(Thread d3) {
		this.d3 = d3;
	}

	public Pote(int nMoedas) {
		super();
		this.nMoedas = nMoedas;
	}

	public int getnMoedas() {
		return nMoedas;
	}

	public void setnMoedas(int nMoedas) {
		this.nMoedas = nMoedas;
	}
	
	public void setReferencias(List<Pote> referencias){
		this.referencias = referencias;
	}
	
	public Pote getProximoPote(int p){
		return referencias.get(p);
	}
	
	public int getQuantidadeReferencias(){
		return referencias.size();
	}
}

