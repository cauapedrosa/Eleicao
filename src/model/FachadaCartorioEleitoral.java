package model;

import java.util.ArrayList;

import exceptions.ExcecaoZonaEleitoralExistente;

public class FachadaCartorioEleitoral {

	private ArrayList<ZonaEleitoral> zonas;

	public FachadaCartorioEleitoral() {
		this.zonas = new ArrayList<ZonaEleitoral>();
	}

	public void cadastraZonaEleitoral(int numero, String localizacao) throws ExcecaoZonaEleitoralExistente {
		ZonaEleitoral zonaExistente = getZona(numero);
		if (zonaExistente == null) {
			ZonaEleitoral zonaNova = new ZonaEleitoral(numero, localizacao);
			this.zonas.add(zonaNova);
		} else
			throw new ExcecaoZonaEleitoralExistente();
	}

	public ZonaEleitoral getZona(int numero) {
		for (int cont = 0; cont < this.zonas.size(); cont++) {
			ZonaEleitoral zona = this.zonas.get(cont);
			if (zona.getNumero() == numero) {
				return zona;
			}
		}
		return null;
	}

	public int numeroDeZonasEleitorais() {
		return this.zonas.size();
	}

	public String getNumero(){
		return null;
	}
	
	public int cadastraNovaSecaoEmUmaZona(int numeroZona) {
		ZonaEleitoral zona = getZona(numeroZona);
		if (zona != null) {
			return zona.criaNovaSecao();
		} else
			return 0;
	}

}
