package testes;

import exceptions.ExcecaoZonaEleitoralExistente;
import model.FachadaCartorioEleitoral;

public class main {

	public static void main(String[] args) throws ExcecaoZonaEleitoralExistente {
		FachadaCartorioEleitoral cartorio = new FachadaCartorioEleitoral();
		cartorio.cadastraZonaEleitoral(101, "Estreito");
		System.out.println("Numero de Zonas Cadastradas 1: " + cartorio.numeroDeZonasEleitorais());
		cartorio.cadastraZonaEleitoral(101, "Estreito");
		System.out.println("Numero de Zonas Cadastradas 2: " + cartorio.numeroDeZonasEleitorais());
	}
}
