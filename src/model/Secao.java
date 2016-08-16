package model;

import java.util.ArrayList;

public class Secao {
	private int numero;
	private Zona zona;
	private ArrayList<Eleitor> eleitores;

	public Secao(int numero, Zona zona) {
		this.numero = numero;
		this.zona = zona;
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
}