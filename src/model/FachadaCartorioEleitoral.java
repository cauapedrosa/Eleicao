package model;

import java.util.ArrayList;

public class FachadaCartorioEleitoral {

	private ArrayList<ZonaEleitoral> zonas;

	public FachadaCartorioEleitoral() {
		this.zonas = new ArrayList<ZonaEleitoral>();
	}

	public void cadastraZonaEleitoral(int numeroZonaEleitoral, String localizacao) {
		ZonaEleitoral zona = getZona(numeroZonaEleitoral);
		if (zona == null) {
			zona = new ZonaEleitoral(numeroZonaEleitoral, localizacao);
			this.zonas.add(zona);
		}
	}

	public ZonaEleitoral getZona(int numeroZonaEleitoral) {
		for (int cont = 0; cont < this.zonas.size(); cont++) {
			ZonaEleitoral zona = this.zonas.get(cont);
			if (zona.getNumero() == numeroZonaEleitoral) {
				return zona;
			}
		}
		return null;
	}

	public int numeroDeZonasEleitorais() {
		return this.zonas.size();
	}

	public int cadastraNovaSecaoEmUmaZona(int numeroZona) {
		ZonaEleitoral zona = getZona(numeroZona);
		if (zona != null) {
			return zona.criaNovaSecao();
		} else
			return 0;
	}

}
