package model;

import java.util.ArrayList;

public class Secao {

	private int numero;
	private ZonaEleitoral zona;
	private ArrayList<Eleitor> eleitores;

	public Secao(int numero, ZonaEleitoral zona) {
		this.numero = numero;
		this.zona = zona;
		this.eleitores = new ArrayList<Eleitor>();
	}

	public void insereEleitor(Eleitor eleitor) {
		if (!this.eleitores.contains(eleitor)) {
			this.eleitores.add(eleitor);
		}
	}

	public ArrayList<Eleitor> getEleitores() {
		return eleitores;
	}

	public int getNumero() {
		return numero;
	}

	public ZonaEleitoral getZona() {
		return zona;
	}
}
