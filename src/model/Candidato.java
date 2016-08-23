package model;

public class Candidato {
	private Eleitor eleitor;
	private Partido partido;
	private int numero;

	public Candidato(int numero, Eleitor eleitor, Partido partido) {
		this.numero = numero;
		this.eleitor = eleitor;
		this.partido = partido;
	}

	public String getNome() {
		return eleitor.getNome();
	}

	public int getCpf() {
		return eleitor.getCpf();
	}

	public int getNumero() {
		return numero;
	}

	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (obj == null)
	// return false;
	// if (getClass() != obj.getClass())
	// return false;
	// Candidato other = (Candidato) obj;
	// if (numero != other.numero)
	// return false;
	// return true;
	// }
}
