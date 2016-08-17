package model;

import java.util.ArrayList;

public class Zona {
	private int numero;
	private String localizacao;
	private ArrayList<Secao> secoes;
	private int numeroSecao;

	public Zona(int numero, String localizacao) {
		this.numero = numero;
		this.localizacao = localizacao;
		this.secoes = new ArrayList<Secao>();
		this.numeroSecao = 0;
	}

	public int getNumero() {
		return this.numero;
	}

	public String getLocalizacao() {
		return this.localizacao;
	}

	public Secao criarNovaSecao() {
		this.numeroSecao++;
		Secao secao = new Secao(this.numeroSecao, this);
		this.secoes.add(secao);
		return secao;
	}

	public String toString() {

		return "toString: " + numero + localizacao + secoes.size() + numeroSecao;
	}
}