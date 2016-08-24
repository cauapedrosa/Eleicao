package excecoes;

public class ExceptionInvalidInput extends Exception {
	private static final long serialVersionUID = 1L;

	public ExceptionInvalidInput() {
		super();
	}

	public ExceptionInvalidInput(String msg) {
		super("Exception: " + msg);
	}
}
