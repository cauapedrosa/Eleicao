package view;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import excecoes.ExcecaoEntradaInvalida;

public class GUI {

	public static int inputInt(String msg) throws ExcecaoEntradaInvalida {
		String input = JOptionPane.showInputDialog(msg);
		if (input == null)
			throw new ExcecaoEntradaInvalida();
		return Integer.parseInt(input);
	}

	public static String inputStr(String msg) throws ExcecaoEntradaInvalida {
		String input = JOptionPane.showInputDialog(msg);
		if (input == null)
			throw new ExcecaoEntradaInvalida();
		return input;
	}

	public static void messagePopup(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	public static void printToConsole(String msg) {
		System.out.println(msg);
	}

	public static String menuCadastros() {
		JDialog.setDefaultLookAndFeelDecorated(true);
		Object[] selectionValues = { "Cadastrar Zona", "Cadastrar Se��o", "Cadastrar Eleitor",
				"Cadastrar Partido", "Cadastrar Candidato", "Editar Cadastros",
				"Verificar Cadastros", };
		String initialSelection = "SELECIONE";
		Object selection = JOptionPane.showInputDialog(null, "Selecione uma Opera��o: ",
				"ELEI��ES 2016", JOptionPane.QUESTION_MESSAGE, null, selectionValues,
				initialSelection);
		return (String) selection;
	}

	public static void errorMsgPopup(String message) {
		JOptionPane.showMessageDialog(null, message, "ERROR!", JOptionPane.ERROR_MESSAGE);
	}

	public static String mainMenu() {
		JDialog.setDefaultLookAndFeelDecorated(true);
		Object[] selectionValues = { "Menu de Cadastros", "Menu de Eleicoes", };
		String initialSelection = "initialSelection";
		Object selection = JOptionPane.showInputDialog(null,
				"\n Selecione uma Opera��o abaixo \n\n", "ELEI��ES 2016",
				JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
		return (String) selection;
	}

}
