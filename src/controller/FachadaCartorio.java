package controller;

import java.util.ArrayList;

import exceptions.ExceptionEleitorInexistente;
import exceptions.ExceptionMsg;
import model.Candidato;
import model.Eleitor;
import model.Partido;
import model.Secao;
import model.Zona;

public class FachadaCartorio {
	private ArrayList<Zona> zonas;
	private ArrayList<Eleitor> eleitores;
	private ArrayList<Secao> secoes;
	private ArrayList<Partido> partidos;
	private ArrayList<Candidato> candidatos;

	public FachadaCartorio() {
		this.zonas = new ArrayList<Zona>();
		this.secoes = new ArrayList<Secao>();
		this.eleitores = new ArrayList<Eleitor>();
		this.partidos = new ArrayList<Partido>();
	}

	public void procurarZona() {
		//
		// int numero = GUI.inputInt("Digite o numero da Zona que voce
		// procura");
		//
		// Zona[] zonas = numeroDeZonas();
		//
		// if (zonas.length == 0) {
		// GUI.messagePopup("Nenhum zona encontrado\n");
		// return;
		// }
		//
		// String msg = "";
		// for (int i = 0; i < zonas.length; i++) {
		// msg += String.format("Zona %d:\n%s\n", i + 1, zonas[i].toString());
		// }
		//
		// GUI.messagePopup(msg);
	}

	private Zona[] procuraZona(int numero) {
		return null;
		// int count = 0;
		//
		// for (Zona zona : zonas) {
		// if (true) {
		// // TODO
		// count++;
		// }
		// }
		//
		// Zona[] found = new Zona[count];
		//
		// count = 0;
		//
		// for (Zona zona : zonas) {
		// if (true) {
		// // TODO
		// found[count] = zona;
		// count++;
		// }
		// }
		//
		// return found;
	}

	public void cadastraZona(int numeroZona, String localizacao) throws ExceptionMsg {
		Zona zona = getZona(numeroZona);
		if (zona == null) {
			zona = new Zona(numeroZona, localizacao);
			this.zonas.add(zona);
		} else {
			throw new ExceptionMsg("Zona já cadastrada");
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

	public void cadastrarSecao(int numeroZona) throws ExceptionMsg {
		Zona zona = getZona(numeroZona);
		if (zona != null) {
			Secao secao = zona.criarNovaSecao();
			this.secoes.add(secao);
		} else {
			throw new ExceptionMsg("Seção já cadastrada");
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

	public void cadastrarPartido(int numeroPartido, String nomePartido) throws ExceptionMsg {

		Partido partido = getPartido(numeroPartido);
		if (partidos.contains(partido))
			throw new ExceptionMsg("Partido já cadastrado");

		if (numeroPartido > 0 && nomePartido != null) {
			partido = new Partido(numeroPartido, nomePartido);
			this.partidos.add(partido);
		} else {
			throw new ExceptionMsg("Partido Inválido");
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

	public void cadastrarEleitor(String nome, int cpf, int titulo) throws ExceptionMsg {
		Eleitor eleitor = getEleitor(cpf);
		if (!eleitores.contains(eleitor)) {
			eleitor = new Eleitor(nome, cpf, titulo);
			this.eleitores.add(eleitor);
		} else {
			throw new ExceptionMsg("CPF já cadastrado");
		}

	}

	public Eleitor getEleitor(int cpf) {
		for (int cont = 0; cont < this.eleitores.size(); cont++) {
			Eleitor eleitor = this.eleitores.get(cont);
			if (eleitor.getTitulo() == cpf) {
				return eleitor;
			}
		}
		return null;
	}

	public Eleitor getEleitor(float titulo) {
		for (int cont = 0; cont < this.eleitores.size(); cont++) {
			Eleitor eleitor = this.eleitores.get(cont);
			if (eleitor.getTitulo() == titulo) {
				return eleitor;
			}
		}
		return null;
	}

	public void cadastrarCandidato(int cpf, String nome, int numPartido, int numero)
			throws Exception {

		if (getEleitor(cpf) == null) {
			throw new ExceptionEleitorInexistente();
		}

		Candidato candidato = getCandidato(cpf);

		if (!candidatos.contains(candidato)) {
			candidato = new Candidato(cpf, numero, numPartido, nome);
		}

	}

	private Candidato getCandidato(int cpf) {
		for (int cont = 0; cont < this.candidatos.size(); cont++) {
			Candidato candidato = this.candidatos.get(cont);
			if (candidato.getCpf() == cpf) {
				return candidato;
			}
		}
		return null;
	}

	public void atribuirEleitorAZona(Eleitor eleitor, Zona zona) {
		eleitor.setZona(zona);
	}

	public void atribuirEleitorASecao(Eleitor eleitor, Secao secao) {
		eleitor.setSecao(secao);
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