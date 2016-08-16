package controller;

import view.GUI;

public class Main {
	public static void main(String[] args) {
		boolean loopFlag = true;

		while (loopFlag) {

			int flag = GUI.inputInt("============================================\n"
					+ "Digite o numero correspondente a  operacao desejada:\n"
					+ "============================================\n" + "0 - Sair\n"
					+ "1 - Cadastrar Eleitor\n" + "2 - Cadastrar Partido\n"
					+ "3 - cadastraCandidato\n" + "4 - cadastraZona\n"
					+ "5 - cadastraSecao\n" + "6 - verificaCadastros\n");

			switch (flag) {
			case 0:
				loopFlag = false;
				break;

			case 1:
				cadastraEleitor();
				break;

			case 2:
				cadastraPartido();
				break;

			case 3:
				cadastraCandidato();
				break;

			case 4:
				cadastraZona();
				break;

			case 5:
				cadastraSecao();
				break;

			case 6:
				verificaCadastros();
				break;

			default:
				loopFlag = false;
				break;
			}
		}
	}

	private static void verificaCadastros() {
		// TODO Auto-generated method stub
		
	}

	private static void cadastraSecao() {
		// TODO Auto-generated method stub
		
	}

	private static void cadastraZona() {
		// TODO Auto-generated method stub
		
	}

	private static void cadastraCandidato() {
		// TODO Auto-generated method stub
		
	}

	private static void cadastraPartido() {
		// TODO Auto-generated method stub
		
	}

	private static void cadastraEleitor() {
		// TODO Auto-generated method stub
		
	}
}
