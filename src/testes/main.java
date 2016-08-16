package testes;

import exceptions.ExcecaoZonaEleitoralExistente;
import model.FachadaCartorioEleitoral;

public class main {

	public static void main(String[] args){
		FachadaCartorioEleitoral cartorio = new FachadaCartorioEleitoral();
		try{
			cartorio.cadastraZonaEleitoral(101, "Estreito");
			System.out.println("Numero de Zonas Cadastradas 1: " + cartorio.getNumero());
			cartorio.cadastraZonaEleitoral(101, "Estreito");
			System.out.println("Numero de Zonas Cadastradas 2: " + cartorio.getNumero());
		}catch (ExcecaoZonaEleitoralExistente e){
			System.out.println("Gerou Excecao!" + e.getMessage());
		}
	}
}
