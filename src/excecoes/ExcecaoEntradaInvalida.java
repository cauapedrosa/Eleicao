package excecoes;

public class ExcecaoEntradaInvalida extends Exception {
	private static final long serialVersionUID = 1L;

	public ExcecaoEntradaInvalida() {
		super();
	}

	public ExcecaoEntradaInvalida(String msg) {
		super("Exception: " + msg);
	}
}
