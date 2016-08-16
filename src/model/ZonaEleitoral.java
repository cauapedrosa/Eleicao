package model;

import java.util.ArrayList;

public class ZonaEleitoral {
	private int numero;
	private String localizacao;
	private ArrayList<Secao> secoes;
	private int numeroSecao;

	public ZonaEleitoral(int numero, String localizacao) {
		this.numero = numero;
		this.localizacao = localizacao;
		// this.secoes = secoes;
		this.numeroSecao = 0;

	}

	public int getNumero() {
		return this.numero;
	}

	public String getLocalizacao() {
		return this.localizacao;
	}

	public int criaNovaSecao() {
		this.numeroSecao++;
		Secao secao = new Secao(this.numeroSecao, this);
		this.secoes.add(secao);
		return this.numeroSecao;

	}
}
