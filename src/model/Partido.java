package model;

import java.util.ArrayList;

import exceptions.ExceptionMsg;

public class Partido {
	private String nome;
	private int numero;
	private Candidato candidatoPrefeito;
	private ArrayList<Candidato> candidatosVereador;

	public Partido(int numero, String nome) {
		this.nome = nome;
		this.numero = numero;
		this.candidatosVereador = new ArrayList<Candidato>();
	}

	public String getNome() {
		return nome;
	}

	public int getNumero() {
		return numero;
	}

	public Candidato getCandidatoPrefeito() {
		return candidatoPrefeito;
	}

	public void setCandidatoPrefeito(Candidato candidatoPrefeito) {
		this.candidatoPrefeito = candidatoPrefeito;
	}

	public Candidato getCandidatoVereador(int index) {
		return candidatosVereador.get(index);
	}

	public void setCandidatoVereador(Candidato candidatoVereador) throws ExceptionMsg {
		if (candidatosVereador.size() < 3) {
			candidatosVereador.add(candidatoVereador);
		} else {
			throw new ExceptionMsg("Partido ja possui 4 Vereadores");
		}
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
