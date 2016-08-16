package exceptions;

public class ExcecaoZonaEleitoralExistente extends Exception {

	private static final long serialVersionUID = 1L;

	public ExcecaoZonaEleitoralExistente(){
		super();
	}

	public ExcecaoZonaEleitoralExistente(String msg){
		super(msg);
	}
}
