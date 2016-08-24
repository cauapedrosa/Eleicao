package model;

import java.util.ArrayList;

import exceptions.ExceptionMsg;

public class Partido {
	private String nome;
	private String sigla;
	private int numero;
	private Candidato candidatoPrefeito;
	private ArrayList<Candidato> candidatosVereador;

	public Partido(String nome, String sigla, int numero) {
		this.nome = nome;
		this.sigla = sigla;
		this.numero = numero;
		this.candidatosVereador = new ArrayList<Candidato>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.sigla = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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
