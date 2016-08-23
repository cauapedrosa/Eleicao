package exceptions;

import controller.Main;
import view.GUI;

public class ExceptionInvalidInput extends Exception {
	private static final long serialVersionUID = 1L;

	public ExceptionInvalidInput() {
		super();
	}

	public ExceptionInvalidInput(String msg) throws Exception {
		GUI.messagePopup(String.format("Exception: %s", msg));
		Main.main(null);
	}
}
