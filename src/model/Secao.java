package model;

import java.util.ArrayList;

public class Secao {
	private int numero;
	private ArrayList<Eleitor> eleitores;

	public Secao(int numero, Zona zona) {
		this.numero = numero;
		this.eleitores = new ArrayList<Eleitor>();
	}

	public void insereEleitor(Eleitor eleitor) {
		if (!this.eleitores.contains(eleitor)) {
			this.eleitores.add(eleitor);
		}
	}

	public int getNumero() {
		return this.numero;
	}

	public boolean verificaSeEleitorVotaNestaSecao(Eleitor eleitor) {
		return this.eleitores.contains(eleitor);
	}

	public int getNumEleitores() {
		return this.eleitores.size();
	}
}