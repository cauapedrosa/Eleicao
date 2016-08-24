package modelo;

import java.util.ArrayList;

import interfaces.IZonaEleitoral;

public class ZonaEleitoral implements IZonaEleitoral {
	private int numero;
	private String localizacao;
	private ArrayList<Secao> secoes;
	private int numeroSecao;

	public ZonaEleitoral(int numero, String localizacao) {
		this.numero = numero;
		this.localizacao = localizacao;
		this.secoes = new ArrayList<Secao>();
		this.setNumeroSecao(0);
	}

	public int getNumero() {
		return this.numero;
	}

	public String getLocalizacao() {
		return this.localizacao;
	}

	public int getNumeroSecoes() {
		return numeroSecao;
	}

	public void setNumeroSecao(int numeroSecao) {
		this.numeroSecao = numeroSecao;
	}

	public ArrayList<Secao> getSecoes() {
		return secoes;
	}

	public Secao getSecao(int index) {
		return secoes.get(index);
	}

	public void setSecoes(ArrayList<Secao> secoes) {
		this.secoes = secoes;
	}

	public Secao criarNovaSecao() {
		this.setNumeroSecao(this.getNumeroSecoes() + 1);
		Secao secao = new Secao(this.getNumeroSecoes(), this);
		this.getSecoes().add(secao);
		return secao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

}