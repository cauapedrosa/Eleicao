package controller;

import exceptions.ExceptionEleitorInexistente;
import exceptions.ExceptionMsg;
import view.GUI;

public class Main {

	public static FachadaCartorio fachada = new FachadaCartorio();

	public static void main(String[] args) throws Exception {

		boolean loopFlag = true;
		while (loopFlag) {

			String opcaoSelecionada = GUI.mainMenu();

			if (opcaoSelecionada != null) {
				switch (opcaoSelecionada) {
				case "Verificar Cadastros":
					verificarCadastros();
					break;
				case "Cadastrar Eleitor":
					cadastrarEleitor();
					break;
				case "Cadastrar Partido":
					cadastraPartido();
					break;
				case "Cadastrar Candidato":
					cadastraCandidato();
					break;
				case "Cadastrar Zona":
					cadastrarZona();
					break;
				case "Cadastrar Seção":
					cadastrarSecao();
					break;
				default:
					loopFlag = false;
					break;
				}
			} else {
				loopFlag = false;
			}
		}

		System.out.println("# ENCERRANDO PROGRAMA #");
	}

	private static void verificarCadastros() {

		String opcaoSelecionada = GUI.verificaMenu();

		switch (opcaoSelecionada) {
		case "Verificar Zona":
			verificarZona();
			break;
		case "Verificar Seção":
			verificarSecao();
			break;
		case "Verificar Eleitor":
			verificarEleitor();
			break;
		case "Verificar Partido":
			verificarPartido();
			break;
		case "Verificar Candidato":
			verificarCandidato();
			break;
		default:
			opcaoSelecionada = null;
			break;
		}
	}

	private static void verificarSecao() {
		// TODO Auto-generated method stub

	}

	private static void verificarZona() {
		// TODO Auto-generated method stub
	}

	private static void verificarEleitor() {
		// TODO Auto-generated method stub

	}

	private static void verificarPartido() {
		// TODO Auto-generated method stub

	}

	private static void verificarCandidato() {
		// TODO Auto-generated method stub

	}

	private static void cadastrarZona() throws Exception {
		System.out.println("CADASTRANDO ZONA");
		//
		int numeroZonaEleitoral = GUI.inputInt("Digite o Numero da Zona Eleitoral");
		String localizacao = GUI.inputStr("Digite a localizacao da Zona Eleitoral");
		fachada.cadastraZona(numeroZonaEleitoral, localizacao);
		//
		System.out.println("# de Zonas aumentado para: " + fachada.numeroDeZonas());
	}

	private static void cadastrarSecao() throws Exception {
		System.out.println("CADASTRANDO SEÇÃO");

		int numero = GUI
				.inputInt("Digite o Número da Zona Eleitoral emque deseja cadastrar uma Seção");
		fachada.cadastrarSecao(numero);
		System.out.printf("Num de Seções da zona %d aumentado para: " + fachada.numeroDeSecoes(),
				numero);

	}

	private static void cadastrarEleitor() throws Exception {
		System.out.println("CADASTRANDO ELEITOR");

		String nome = GUI.inputStr("Digite o Nome do Eleitor");
		int cpf = GUI.inputInt("Digite o CPF do Eleitor");
		int titulo = GUI.inputInt("Digite o Titulo do Eleitor");

		fachada.cadastrarEleitor(nome, cpf, titulo);
	}

	private static void cadastraPartido() throws ExceptionMsg {
		System.out.println("CADASTRANDO PARTIDO");

		String nomePartido = GUI.inputStr("Digite o Nome do Partido");
		int numeroPartido = GUI.inputInt("Digite o Numero do Partido");

		if (numeroPartido > 0 && nomePartido != null)
			fachada.cadastrarPartido(numeroPartido, nomePartido);
	}

	private static void cadastraCandidato() throws Exception {
		System.out.println("CADASTRANDO CANDIDATO");
		int cpf = GUI.inputInt("Digite o CPF do Candidato");
		String nome = GUI.inputStr("Digite o Nome do Candidato");
		int numPartido = GUI.inputInt("Digite o Numero do Partido do Candidato");
		int numero = GUI.inputInt("Digite o Numero de Candidato do Candidato");
		fachada.cadastrarCandidato(cpf, nome, numPartido, numero);
	}

}
