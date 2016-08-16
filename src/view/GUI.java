package view;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class GUI {

	public static int inputInt(String msg) {
		String input = JOptionPane.showInputDialog(msg);
		return Integer.parseInt(input);
	}

	public static String inputStr(String msg) {
		return JOptionPane.showInputDialog(msg);
	}

	public static void messagePopup(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	public static String mainMenu() {
		JDialog.setDefaultLookAndFeelDecorated(true);
		Object[] selectionValues = { "Verificar Cadastros", "Cadastrar Eleitor",
				"Cadastrar Partido", "Cadastrar Candidato", "Cadastrar Zona", "Cadastrar Seção", };
		String initialSelection = "SELECIONE";
		Object selection = JOptionPane.showInputDialog(null, "Selecione uma Operação: ",
				"ELEIÇÕES 2016", JOptionPane.QUESTION_MESSAGE, null, selectionValues,
				initialSelection);
		System.out.println(selection);
		return (String) selection;
	}

}
