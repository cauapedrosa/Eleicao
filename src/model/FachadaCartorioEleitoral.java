package model;

import java.util.ArrayList;

public class FachadaCartorioEleitoral {

	private ArrayList<Zona> zonas;
	
	public FachadaCartorioEleitoral(){
		this.zonas = new ArrayList<Zona>();
	}
	
	public void cadastraZonaEleitoral(int numeroZonaEleitoral, String localizacao){
		Zona zona = getZona(numeroZonaEleitoral);
		if (zona == null){
			zona = new Zona(numeroZonaEleitoral, localizacao);
			this.zonas.add(zona);
		}
	}

	private Zona getZona(int numeroZonaEleitoral) {
		for(int cont = 0; cont<this.zonas.size();cont++){
			Zona zona = this.zonas.get(cont);
			if (zona.getNumero() == numeroZonaEleitoral){
				return zona;
			}
		}
		return null;
	}
}
