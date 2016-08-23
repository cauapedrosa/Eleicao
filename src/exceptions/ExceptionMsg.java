package exceptions;

public class ExceptionMsg extends Exception {
	private static final long serialVersionUID = 1L;

	public ExceptionMsg() {
		super();
	}

	public ExceptionMsg(String msg) {
//		GUI.messagePopup(String.format("Exception: %s", msg));
		super("Exception: " + msg);
	}
}
