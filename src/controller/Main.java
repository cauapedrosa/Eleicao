package controller;

import view.GUI;

public class Main {
	public static void main(String[] args) throws Exception {

		boolean loopFlag = true;
		while (loopFlag) {

			String opcaoSelecionada = GUI.mainMenu();

			if (opcaoSelecionada != null) {
				switch (opcaoSelecionada) {
				case "Verificar Cadastros":
					verificaCadastros();
					break;

				case "Cadastrar Eleitor":
					cadastraEleitor();
					break;

				case "Cadastrar Partido":
					cadastraPartido();
					break;

				case "Cadastrar Candidato":
					cadastraCandidato();
					break;

				case "Cadastrar Zona":
					cadastraZona();
					break;

				case "Cadastrar Seção":
					cadastraSecao();
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

	private static void verificaCadastros() {
		System.out.println("VERIFICANDO CADASTROS");
		// TODO Auto-generated method stub

	}

	private static void cadastraSecao() {
		System.out.println("CADASTRANDO SECAO");
		// TODO Auto-generated method stub

	}

	private static void cadastraZona() {
		System.out.println("CADASTRANDO ZONA");
		// TODO Auto-generated method stub

	}

	private static void cadastraCandidato() {
		System.out.println("CADASTRANDO CANDIDATO");
		// TODO Auto-generated method stub

	}

	private static void cadastraPartido() {
		System.out.println("CADASTRANDO PARTIDO");
		// TODO Auto-generated method stub

	}

	private static void cadastraEleitor() {
		System.out.println("CADASTRANDO ELEITOR");
		// TODO Auto-generated method stub

	}

}
