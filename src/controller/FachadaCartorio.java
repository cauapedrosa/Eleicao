package controller;

import java.util.ArrayList;

import exceptions.ExceptionJaCadastrado;
import model.Eleitor;
import model.Partido;
import model.Secao;
import model.Zona;

public class FachadaCartorio {
	private ArrayList<Zona> zonas;
	private ArrayList<Eleitor> eleitores;
	private ArrayList<Secao> secoes;
	private ArrayList<Partido> partidos;

	public FachadaCartorio() {
		this.zonas = new ArrayList<Zona>();
		this.secoes = new ArrayList<Secao>();
		this.eleitores = new ArrayList<Eleitor>();
		this.partidos = new ArrayList<Partido>();
	}

	public void cadastraZona(int numeroZona, String localizacao) throws ExceptionJaCadastrado {
		Zona zona = getZona(numeroZona);

		if (zona == null) {
			zona = new Zona(numeroZona, localizacao);
			this.zonas.add(zona);
		} else {
			throw new ExceptionJaCadastrado("Zona já cadastrada");
		}
	}

	public Zona getZona(int numeroZona) {
		for (int cont = 0; cont < this.zonas.size(); cont++) {
			Zona zona = this.zonas.get(cont);
			if (zona.getNumero() == numeroZona) {
				return zona;
			}
		}
		return null;
	}

	public void cadastrarSecao(int numeroZona) throws ExceptionJaCadastrado {
		Zona zona = getZona(numeroZona);
		if (zona != null) {
			Secao secao = zona.criarNovaSecao();
			this.secoes.add(secao);
		} else {
			throw new ExceptionJaCadastrado("Seção já cadastrada");
		}
	}

	public Secao getSecao(int numeroSecao) {
		for (int cont = 0; cont < this.secoes.size(); cont++) {
			Secao secao = this.secoes.get(cont);
			if (secao.getNumero() == numeroSecao) {
				return secao;
			}
		}
		return null;
	}

	public void cadastrarPartido(int numeroPartido, String nomePartido)
			throws ExceptionJaCadastrado {

		Partido partido = getPartido(numeroPartido);

		if (partido == null) {
			partido = new Partido(numeroPartido, nomePartido);
			this.partidos.add(partido);
		} else {
			throw new ExceptionJaCadastrado("Partido já cadastrado");
		}
	}

	public Partido getPartido(int numeroPartido) {
		for (int cont = 0; cont < this.zonas.size(); cont++) {
			Partido partido = this.partidos.get(cont);
			if (partido.getNumero() == numeroPartido) {
				return partido;
			}
		}
		return null;
	}

	public void cadastrarEleitor(String nome, int cpf, int titulo) throws ExceptionJaCadastrado {
		Eleitor eleitor = getEleitor(cpf);
		if (eleitor == null) {
			eleitor = new Eleitor(nome, cpf, titulo);
			this.eleitores.add(eleitor);
		} else {
			throw new ExceptionJaCadastrado("CPF já cadastrado");
		}
	}

	private Eleitor getEleitor(int titulo) {
		for (int cont = 0; cont < this.eleitores.size(); cont++) {
			Eleitor eleitor = this.eleitores.get(cont);
			if (eleitor.getTitulo() == titulo) {
				return eleitor;
			}
		}
		return null;
	}

	public int numeroDeZonas() {
		return zonas.size();
	}

	public int numeroDeSecoes() {
		return this.secoes.size();
	}

	public int numeroDeEleitores() {
		return this.eleitores.size();
	}

	public int numeroDePartidos() {
		return this.partidos.size();
	}
}