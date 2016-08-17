package model;

public class Partido {
	private String nome;
	private int numero;

	public Partido(int numero, String nome) {
		this.nome = nome;
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public int getNumero() {
		return numero;
	}

}
