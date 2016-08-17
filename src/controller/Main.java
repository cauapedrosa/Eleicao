package controller;

import view.GUI;

public class Main {
	private static FachadaCartorio fachada = new FachadaCartorio();

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

		boolean loopFlagVerificar = true;
		while (loopFlagVerificar) {

			String opcaoSelecionada = GUI.verificaMenu();

			if (opcaoSelecionada != null) {
				switch (opcaoSelecionada) {
				case "Verificar Zona":
					break;
				case "Verificar Seção":
					break;
				case "Verificar Eleitor":
					break;
				case "Verificar Partido":
					break;
				case "Verificar Candidato":
					break;
				default:
					loopFlagVerificar = false;
					break;
				}
			} else {
				loopFlagVerificar = false;
			}
		}

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

		int numero = GUI.inputInt("Digite o Numero da Seção Eleitoral");
		fachada.cadastrarSecao(numero);
		System.out.println("# de Seções aumentado para: " + fachada.numeroDeSecoes());

	}

	private static void cadastrarEleitor() throws Exception {
		System.out.println("CADASTRANDO ELEITOR");

		String nome = GUI.inputStr("Digite o Numero da Seção Eleitoral");
		int cpf = GUI.inputInt("Digite o Numero da Seção Eleitoral");
		int titulo = GUI.inputInt("Digite o Numero da Seção Eleitoral");

		fachada.cadastrarEleitor(nome, cpf, titulo);
	}

	private static void cadastraPartido() {
		System.out.println("CADASTRANDO PARTIDO");
		// TODO Auto-generated method stub

	}

	private static void cadastraCandidato() {
		System.out.println("CADASTRANDO CANDIDATO");
		// TODO Auto-generated method stub

	}

}
