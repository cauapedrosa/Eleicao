package controller;

import java.util.ArrayList;

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
		this.candidatos = new ArrayList<Candidato>();
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

	public Zona getZona(int numeroZona) throws ExceptionMsg {
		try {
			for (int cont = 0; cont < this.zonas.size(); cont++) {
				Zona zona = this.zonas.get(cont);
				if (zona.getNumero() == numeroZona) {
					return zona;
				}
			}
		} catch (Exception e) {
			throw new ExceptionMsg("Zona Invalida");
		}
		return null;

	}

	public String listarZonas() {
		String listaZonas = "Lista de Zonas: \n";
		for (int cont = 0; cont < zonas.size(); cont++) {
			Zona zona = zonas.get(cont);
			if (zona != null) {
				int num = zona.getNumero();
				String local = zona.getLocalizacao();
				listaZonas += String.format("Zona %d, Local: %s \n", num, local);
			}
		}
		return listaZonas;
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

	public Secao getSecao(int numeroSecao) throws ExceptionMsg {
		try {
			for (int cont = 0; cont < this.secoes.size(); cont++) {
				Secao secao = this.secoes.get(cont);
				if (secao.getNumero() == numeroSecao) {
					return secao;
				}
			}
		} catch (Exception e) {
			throw new ExceptionMsg("Secao Invalida");
		}
		return null;
	}

	public String listarTodasSecoes() {
		String listaSecoes = String.format("Lista de Secoes:\n");

		for (int i = 0; i < Main.fachada.numeroDeZonas(); i++) {
			Zona zona = Main.fachada.zonas.get(i);
			for (int cont = 0; cont < Main.fachada.secoes.size(); cont++) {
				Secao secao = Main.fachada.secoes.get(cont);
				// Secao secao = zona.getSecao(cont);
				if (secao != null) {
					int numSec = secao.getNumero();
					int numEleitores = secao.getNumEleitores();
					int numZona = zona.getNumero();
					listaSecoes += String.format("Secao Nº %d/%02d - %02d eleitores \n", numZona,
							numSec, numEleitores);
				}
			}
		}
		listaSecoes += String.format("(Zona/Secao)\n");
		return listaSecoes;
	}

	public String qtdSecoesNumaZona(int numZona) throws ExceptionMsg {
		String listaSecoesDeUmaZona = "";
		Zona zona = getZona(numZona);
		listaSecoesDeUmaZona += String.format("A Zona %d possui %d Secoes", numZona,
				zona.getNumeroSecoes());
		// for (int cont = 0; cont < zona.getNumeroSecoes(); cont++) {
		// System.out.printf("1 - cont %02d, há %02d secoes \n", cont,
		// zona.getNumeroSecoes());
		// if (zona.getSecao(cont) != null) {
		// System.out.printf("2 - cont %02d, há %02d secoes \n", cont,
		// zona.getNumeroSecoes());
		// Secao secao = Main.fachada.getSecao(cont);
		// if (secao == null) {
		// System.out.println("SECAO NULA");
		// }
		// if (secao != null) {
		// int numero = secao.getNumero();
		// listaSecoesDeUmaZona += String.format("Secao %d \n", numero);
		// System.out.printf(listaSecoesDeUmaZona);
		//
		// }
		// }
		// System.out.printf("Terminando método listarSecoesDeUmaZona()");
		// }
		return listaSecoesDeUmaZona;
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

	public Eleitor getEleitor(int cpf) throws ExceptionMsg {
		try {
			for (int cont = 0; cont < this.eleitores.size(); cont++) {
				Eleitor eleitor = this.eleitores.get(cont);
				if (eleitor.getCpf() == cpf) {
					return eleitor;
				}
			}
		} catch (Exception e) {
			throw new ExceptionMsg("Eleitor Invalido");
		}
		return null;
	}

	public Eleitor getEleitor(float titulo) throws ExceptionMsg {
		try {
			for (int cont = 0; cont < this.eleitores.size(); cont++) {
				Eleitor eleitor = this.eleitores.get(cont);
				if (eleitor.getTitulo() == titulo) {
					return eleitor;
				}
			}
		} catch (Exception e) {
			throw new ExceptionMsg("Eleitor Invalido");
		}
		return null;
	}

	public String listarEleitores() {
		String listaEleitores = String.format("Lista de Eleitores:\n");

		for (int cont = 0; cont < Main.fachada.numeroDeEleitores(); cont++) {
			Eleitor eleitor = eleitores.get(cont);
			if (eleitor != null) {
				int cpf = eleitor.getCpf();
				int titulo = eleitor.getTitulo();
				String nome = eleitor.getNome();

				listaEleitores += String.format("Nome %s - CPF: %d - Titulo: %d \n", nome, cpf,
						titulo);
			}
		}

		return listaEleitores;
	}

	public void cadastrarPartido(String nomePartido, String siglaPartido, int numeroPartido)
			throws ExceptionMsg {
		Partido partido = getPartido(numeroPartido);

		if (partidos.contains(partido))
			throw new ExceptionMsg("Partido já cadastrado");
		if (numeroPartido > 0 && nomePartido != null)
			throw new ExceptionMsg("Numero do Partido Inválido");
		if (siglaPartido.length() >= 5)
			throw new ExceptionMsg("Sigla inválida");

		partido = new Partido(nomePartido, siglaPartido, numeroPartido);
		this.partidos.add(partido);
	}

	public Partido getPartido(int numPartido) throws ExceptionMsg {
		try {
			for (int cont = 0; cont < this.partidos.size(); cont++) {
				Partido partido = this.partidos.get(cont);
				if (partido.getNumero() == numPartido) {
					return partido;
				}
			}
		} catch (Exception e) {
			throw new ExceptionMsg("Partido Invalido");
		}
		return null;
	}

	public String listarPartidos() {
		String listaPartidos = String.format("Lista de Partidos:\n");

		for (int cont = 0; cont < Main.fachada.numeroDePartidos(); cont++) {
			Partido partido = partidos.get(cont);
			if (partido != null) {
				int numero = partido.getNumero();
				String nome = partido.getNome();

				listaPartidos += String.format("Partido: %s, número %02d", nome, numero);
			}
		}

		return listaPartidos;
	}

	public void cadastrarCandidato(int cpf, String nome, int numPartido, int numero)
			throws ExceptionMsg {

		if (candidatos.contains(getCandidatoNumero(numero)))
			throw new ExceptionMsg("Candidato Já Cadastrado");

		Eleitor eleitor = getEleitor(cpf);
		Partido partido = getPartido(numPartido);

		if (eleitor.getCpf() != cpf)
			throw new ExceptionMsg("Eleitor não encontrado");
		if (partido.getNumero() != numPartido)
			throw new ExceptionMsg("Partido não encontrado");

		Candidato candidato = new Candidato(numero, eleitor, partido);
		candidato.setEleitor(eleitor);
		this.candidatos.add(candidato);

	}

	public Candidato getCandidatoNumero(int numero) throws ExceptionMsg {
		try {
			for (int cont = 0; cont < this.candidatos.size(); cont++) {
				Candidato candidato = this.candidatos.get(cont);
				if (candidato.getNumero() == numero) {
					return candidato;
				}
			}
		} catch (Exception e) {
			throw new ExceptionMsg("Candidato Invalido");
		}
		return null;
	}

	public Candidato getCandidatoCPF(int cpf) throws ExceptionMsg {
		try {
			for (int cont = 0; cont < this.candidatos.size(); cont++) {
				Candidato candidato = this.candidatos.get(cont);
				if (candidato.getCpf() == cpf) {
					return candidato;
				}
			}
		} catch (Exception e) {
			throw new ExceptionMsg("Candidato Invalido");
		}
		return null;
	}

	public String listarCandidatos() {
		String listaCandidatos = String.format("Lista de Candidatos:\n");

		for (int cont = 0; cont < Main.fachada.numeroDeCandidatos(); cont++) {
			Candidato candidato = candidatos.get(cont);
			if (candidato != null) {
				String nome = candidato.getNome();
				int numero = candidato.getNumero();
				int numPartido = candidato.getPartido().getNumero();
				int cpf = candidato.getCpf();

				listaCandidatos += String.format("Nome: %s, Número: %04d, Partido: %d, CPF: %d\n",
						nome, numero, numPartido, cpf);
			}
		}

		return listaCandidatos;
	}

	public int numeroDeZonas() {
		return zonas.size();
	}

	public int numeroDeSecoesDeUmaZona(Zona zona) {
		return zona.getNumeroSecoes();
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

	public int numeroDeCandidatos() {
		return this.candidatos.size();
	}

	public void setEnderecoDoEleitor(int cpf, String endereco) throws Exception {
		if (getEleitor(cpf) == null)
			throw new ExceptionMsg("Eleitor Invalido");
		if (endereco == null)
			throw new ExceptionMsg("Endereco Invalido");
		Eleitor eleitor = getEleitor(cpf);
		eleitor.setEndereco(endereco);
	}

	public void setMunicipioDoEleitor(int cpf, String municipio) throws Exception {
		if (getEleitor(cpf) == null)
			throw new ExceptionMsg("Eleitor Invalido");
		if (municipio == null)
			throw new ExceptionMsg("Municipio Invalido");
		Eleitor eleitor = getEleitor(cpf);
		eleitor.setEndereco(municipio);
	}

	public void setSecaoDoEleitor(int cpf, int numSecao) throws Exception {
		if (getEleitor(cpf) == null)
			throw new ExceptionMsg("Eleitor Invalido");
		if (getSecao(numSecao) == null)
			throw new ExceptionMsg("Secao Invalida");
		Eleitor eleitor = getEleitor(cpf);
		Secao secao = getSecao(numSecao);
		secao.insereEleitor(eleitor);
	}

	public void setZonaDoEleitor(int cpf, int numZona) throws Exception {
		if (getEleitor(cpf) == null)
			throw new ExceptionMsg("Eleitor Invalido");
		if (getZona(numZona) == null)
			throw new ExceptionMsg("Zona Invalida");
		Eleitor eleitor = getEleitor(cpf);
		Zona zona = getZona(numZona);
		eleitor.setZona(zona);
	}

	public void setNumeroDoCandidato(int cpf, int numero) throws Exception {
		Candidato candidato = getCandidatoNumero(numero);
		if (candidato == null)
			throw new ExceptionMsg("Candidato Invalido");
		if (numero == 0 || numero > 9999)
			throw new ExceptionMsg("Numero de Candidato Invalido");
		candidato.setNumero(numero);
	}

	public void setPartidoDoCandidato(int cpf, int numPartido) throws Exception {
		Candidato candidato = getCandidatoCPF(cpf);
		Partido partido = getPartido(numPartido);

		if (candidato == null)
			throw new ExceptionMsg("Candidato Invalido");
		if (numPartido == 0 || numPartido > 9999)
			throw new ExceptionMsg("Numero de Candidato Invalido");
		if (partido == null)
			throw new ExceptionMsg("Partido Invalido");

		candidato.setPartido(partido);
	}

	public void alterarLocalDeUmaZona(int numZona, String localizacao) throws Exception {
		Zona zona = getZona(numZona);
		zona.setLocalizacao(localizacao);
	}

	public void alterarNumeroPartido(int numPartido, int novoNumPartido) throws Exception {
		Partido partido = getPartido(numPartido);
		partido.setNumero(numPartido);
	}

	public void alterarNomePartido(int numPartido, String novoNomePartido) throws Exception {
		Partido partido = getPartido(numPartido);
		partido.setNome(novoNomePartido);
	}

	public void alterarSiglaPartido(int numPartido, String novaSiglaPartido) throws Exception {
		Partido partido = getPartido(numPartido);
		partido.setSigla(novaSiglaPartido);
	}

}