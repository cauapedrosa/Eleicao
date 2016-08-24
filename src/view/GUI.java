package view;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import exceptions.ExceptionInvalidInput;

public class GUI {

	public static int inputInt(String msg) throws ExceptionInvalidInput {
		String input = JOptionPane.showInputDialog(msg);
		if (input == null)
			throw new ExceptionInvalidInput();
		return Integer.parseInt(input);
	}

	public static String inputStr(String msg) throws ExceptionInvalidInput {
		String input = JOptionPane.showInputDialog(msg);
		if (input == null)
			throw new ExceptionInvalidInput();
		return input;
	}

	public static void messagePopup(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	public static void printToConsole(String msg) {
		System.out.println(msg);
	}

	public static String mainMenu() {
		JDialog.setDefaultLookAndFeelDecorated(true);
		Object[] selectionValues = { "Cadastrar Zona", "Cadastrar Seção", "Cadastrar Eleitor",
				"Cadastrar Partido", "Cadastrar Candidato", "Editar Cadastros",
				"Verificar Cadastros", };
		String initialSelection = "SELECIONE";
		Object selection = JOptionPane.showInputDialog(null, "Selecione uma Operação: ",
				"ELEIÇÕES 2016", JOptionPane.QUESTION_MESSAGE, null, selectionValues,
				initialSelection);
		return (String) selection;
	}

	public static void errorMsgPopup(String message) {
		JOptionPane.showMessageDialog(null, message, "ERROR!", JOptionPane.ERROR_MESSAGE);
	}

	// public static String verificaMenu() {
	// JDialog.setDefaultLookAndFeelDecorated(true);
	// Object[] selectionValues = { "Verificar Zona", "Verificar Seção",
	// "Verificar Eleitor",
	// "Verificar Partido", "Verificar Candidato", };
	// String initialSelection = "SELECIONE";
	// Object selection = JOptionPane.showInputDialog(null, "Selecione uma
	// Operação: ",
	// "ELEIÇÕES 2016 > VERIFICAR CADASTROS", JOptionPane.QUESTION_MESSAGE,
	// null,
	// selectionValues, initialSelection);
	// return (String) selection;
	// }

}
