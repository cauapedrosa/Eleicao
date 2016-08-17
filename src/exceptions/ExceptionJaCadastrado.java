package exceptions;

public class ExceptionJaCadastrado extends Exception {

	private static final long serialVersionUID = 1L;

	public ExceptionJaCadastrado() {
		super();
	}

	public ExceptionJaCadastrado(String msg) {
		super("Exception: " + msg);
	}
}
