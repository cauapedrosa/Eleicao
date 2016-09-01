package modelo;

import java.util.ArrayList;

import interfaces.ISecao;
import interfaces.IZonaEleitoral;

public class Secao implements ISecao {
	private int numero;
	private ArrayList<Eleitor> eleitores;
	private Urna urna;

	public Secao(int numero, ZonaEleitoral zona) {
		this.numero = numero;
		this.eleitores = new ArrayList<Eleitor>();
		this.urna = new Urna(this);
	}

	public void insereEleitor(Eleitor eleitor) {
		if (!this.eleitores.contains(eleitor)) {
			this.eleitores.add(eleitor);
		}
	}

	public void limparEleitores() {
		eleitores.clear();
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

	public IZonaEleitoral getZona() {
		// TODO Auto-generated method stub
		return null;
	}

	public Urna getUrna() {
		return urna;
	}

}
