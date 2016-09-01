package modelo;

import java.util.ArrayList;
import java.util.List;

public class Urna {
	private Secao secao;
	private boolean status;
	private List<Integer> votosPrefeito;
	private List<Integer> votosVereador;
	private ArrayList<Eleitor> eleitoresQueVotaram;

	public Urna(Secao secao) {
		this.secao = secao;
		this.status = false;
		this.votosPrefeito = new ArrayList<Integer>();
		this.votosVereador = new ArrayList<Integer>();

	}

	public Secao getSecao() {
		return secao;
	}

	public void setZona(Secao secao) {
		this.secao = secao;
	}

	public boolean isStatus() {
		return status;
	}

	public void abrirUrna() {
		this.status = true;
	}

	public void fecharUrna() {
		this.status = false;
	}

	public boolean eleitorVotou(Eleitor eleitor) {
		if (eleitoresQueVotaram.contains(eleitor)) {
			return true;
		} else {
			return false;
		}
	}

	public void cadastraVotos(int votoPref, int votoVere) {
		votosPrefeito.add(votoPref);
		votosVereador.add(votoVere);

	}

	public int contaVotosPrefeito(int numPrefeito) {
		int contagem = 0;
		for (int i = 0; i < votosPrefeito.size(); i++) {
			if (votosPrefeito.get(i) == numPrefeito)
				contagem++;
		}
		return contagem;
	}
}
