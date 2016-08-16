package model;

import java.util.ArrayList;

public class FachadaCartorioEleitoral {
	private ArrayList<Zona> zonas;
	private ArrayList<Eleitor> eleitores;
	private ArrayList<Secao> secoes;

	public FachadaCartorioEleitoral() {
		this.zonas = new ArrayList<Zona>();
		this.secoes = new ArrayList<Secao>();
		this.eleitores = new ArrayList<Eleitor>();
	}

	public void cadastraZonaEleitoral(int numeroZonaEleitoral, String localizacao) {
		Zona zona = getZona(numeroZonaEleitoral);
		if (zona == null) {
			zona = new Zona(numeroZonaEleitoral, localizacao);
			this.zonas.add(zona);
		}
	}

	public Zona getZona(int numeroZonaEleitoral) {
		for (int cont = 0; cont < this.zonas.size(); cont++) {
			Zona zona = this.zonas.get(cont);
			if (zona.getNumero() == numeroZonaEleitoral) {
				return zona;
			}
		}
		return null;
	}

	public int numeroDeZonasEleitorais() {
		return zonas.size();
	}

	public int cadastrarSecao(int numeroZona) {
		Zona zona = getZona(numeroZona);
		if (zona != null) {
			Secao secao = zona.criarNovaSecao();
			this.secoes.add(secao);
			return secao.getNumero();
		} else {
			return 0;
		}
	}

	public Secao getSecao(int numeroSecao) {
		for (int cont = 0; cont < this.secoes.size(); cont++) {
			Secao secao = this.secoes.get(cont);
			if (secao.getNumero() == numeroSecao) {
				return secao;
			}
		}
		return null;
	}

	public int numeroDeSecoes() {
		return this.secoes.size();
	}

}