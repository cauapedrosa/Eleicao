package model;

import controller.Main;

public class Candidato {
	private int cpf;
	private int numero;
	private int numPartido;
	private String nome;

	public Candidato(int cpf, int numPartido, int numero, String nome) {

		if (Main.fachada.getEleitor(cpf) != null) {
			this.cpf = cpf;
			this.nome = nome;
			this.numPartido = numPartido;
			this.numero = numero;
		}
	}

	public float getCpf() {
		return cpf;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidato other = (Candidato) obj;
		if (cpf != other.cpf)
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}

}
