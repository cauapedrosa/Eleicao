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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		if (numero != other.numero)
			return false;
		return true;
	}

}
