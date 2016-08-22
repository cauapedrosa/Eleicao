package exceptions;

public class ExceptionMsg extends Exception {
	private static final long serialVersionUID = 1L;

	public ExceptionMsg() {
		super();
	}

	public ExceptionMsg(String msg) {
		super("Exception: " + msg);
	}
}
