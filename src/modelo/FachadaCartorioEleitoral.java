package modelo;

import java.util.ArrayList;
import java.util.List;

import controller.Main;
import interfaces.CartorioEleitoral;
import interfaces.ISecao;

public class FachadaCartorioEleitoral implements CartorioEleitoral {
	public ArrayList<ZonaEleitoral> zonas;
	public ArrayList<Eleitor> eleitores;
	public ArrayList<Secao> secoes;
	public ArrayList<Partido> partidos;
	public ArrayList<Candidato> candidatos;

	public FachadaCartorioEleitoral() {
		this.zonas = new ArrayList<ZonaEleitoral>();
		this.secoes = new ArrayList<Secao>();
		this.eleitores = new ArrayList<Eleitor>();
		this.partidos = new ArrayList<Partido>();
		this.candidatos = new ArrayList<Candidato>();
	}

	public void cadastraZonaEleitoral(int numeroZonaEleitoral, String localizacao)
			throws Exception {
		ZonaEleitoral zona = (ZonaEleitoral) getZona(numeroZonaEleitoral);
		if (zona == null) {
			zona = new ZonaEleitoral(numeroZonaEleitoral, localizacao);
			this.zonas.add(zona);
		} else {
			throw new Exception("Zona j� cadastrada");
		}
	}

	public ZonaEleitoral getZona(int numeroZonaEleitoral) throws Exception {
		try {
			for (int cont = 0; cont < this.zonas.size(); cont++) {
				ZonaEleitoral zona = this.zonas.get(cont);
				if (zona.getNumero() == numeroZonaEleitoral) {
					return zona;
				}
			}
		} catch (Exception e) {
			throw new Exception("Zona Invalida");
		}
		return null;

	}

	public String listarZonas() {
		String listaZonas = "Lista de Zonas: \n";
		for (int cont = 0; cont < zonas.size(); cont++) {
			ZonaEleitoral zona = zonas.get(cont);
			if (zona != null) {
				int num = zona.getNumero();
				String local = zona.getLocalizacao();
				listaZonas += String.format("Zona %d, Local: %s \n", num, local);
			}
		}
		return listaZonas;
	}

	public void cadastraSecaoEleitoral(int numeroZonaEleitoral) throws Exception {
		if (getZona(numeroZonaEleitoral) == null) {
			throw new Exception("Zona n�o encontrada");
		} else {
			ZonaEleitoral zona = (ZonaEleitoral) getZona(numeroZonaEleitoral);
			Secao secao = zona.criarNovaSecao();
			this.secoes.add(secao);
		}
	}

	public Secao getSecao(int numeroSecao) throws Exception {
		try {
			for (int cont = 0; cont < this.secoes.size(); cont++) {
				Secao secao = this.secoes.get(cont);
				if (secao.getNumero() == numeroSecao) {
					return secao;
				}
			}
		} catch (Exception e) {
			throw new Exception("Secao Invalida");
		}
		return null;
	}

	public String listarTodasSecoes() {
		String listaSecoes = String.format("Lista de Secoes:\n");

		for (int i = 0; i < Main.fachada.numeroDeZonasEleitorais(); i++) {
			ZonaEleitoral zona = Main.fachada.zonas.get(i);
			for (int cont = 0; cont < Main.fachada.secoes.size(); cont++) {
				Secao secao = Main.fachada.secoes.get(cont);
				if (secao != null) {
					int numSec = secao.getNumero();
					int numEleitores = secao.getNumEleitores();
					int numZona = zona.getNumero();
					listaSecoes += String.format("Secao N� %d/%02d - %02d eleitores \n", numZona,
							numSec, numEleitores);
				}
			}
		}
		listaSecoes += String.format("(Zona/Secao)\n");
		return listaSecoes;
	}

	public String qtdSecoesNumaZona(int numZona) throws Exception {
		ZonaEleitoral zona = getZona(numZona);
		String listaSecoesDeUmaZona = String.format("A Zona %d possui %d Secoes", numZona,
				zona.getNumeroSecoes());
		return listaSecoesDeUmaZona;
	}

	public void cadastrarEleitor(String nome, int cpf, int titulo) throws Exception {
		Eleitor eleitor = getEleitor(cpf);
		if (!eleitores.contains(eleitor)) {
			eleitor = new Eleitor(nome, cpf, titulo);
			this.eleitores.add(eleitor);
		} else {
			throw new Exception("CPF j� cadastrado");
		}

	}

	public Eleitor getEleitor(int cpf) throws Exception {
		try {
			for (int cont = 0; cont < this.eleitores.size(); cont++) {
				Eleitor eleitor = this.eleitores.get(cont);
				if (eleitor.getCpf() == cpf) {
					return eleitor;
				}
			}
		} catch (Exception e) {
			throw new Exception("Eleitor Invalido");
		}
		return null;
	}

	public Eleitor getEleitor(float titulo) throws Exception {
		try {
			for (int cont = 0; cont < this.eleitores.size(); cont++) {
				Eleitor eleitor = this.eleitores.get(cont);
				if (eleitor.getTitulo() == titulo) {
					return eleitor;
				}
			}
		} catch (Exception e) {
			throw new Exception("Eleitor Invalido");
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

	public void cadastrarPartido(String nomePartido, String siglaPartido, int numpartido)
			throws Exception {
		Partido partido = getPartido(numpartido);

		if (partidos.contains(partido))
			throw new Exception("Partido j� cadastrado");
		if (numpartido == 0 || numpartido > 99)
			throw new Exception(
					"Numero do Partido Inv�lido " + "(Igual a 0 ou Mais de Dois Digitos)");
		if (siglaPartido.length() >= 5)
			throw new Exception("Sigla inv�lida (Mais de Dois Digitos)");

		partido = new Partido(nomePartido, siglaPartido, numpartido);
		this.partidos.add(partido);
	}

	public Partido getPartido(int numPartido) throws Exception {
		try {
			for (int cont = 0; cont < this.partidos.size(); cont++) {
				Partido partido = this.partidos.get(cont);
				if (partido.getNumero() == numPartido) {
					return partido;
				}
			}
		} catch (Exception e) {
			throw new Exception("Partido Invalido");
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

				listaPartidos += String.format("Partido: %s, n�mero %02d", nome, numero);
			}
		}

		return listaPartidos;
	}

	public void cadastrarCandidatoPrefeito(int cpf, String nome, int numPartido) throws Exception {

		if (candidatos.contains(getCandidatoCPF(cpf)))
			throw new Exception("Candidato J� Cadastrado");

		Eleitor eleitor = getEleitor(cpf);
		Partido partido = getPartido(numPartido);

		if (eleitor.getCpf() != cpf)
			throw new Exception("Eleitor n�o encontrado");
		if (partido.getNumero() != numPartido)
			throw new Exception("Partido n�o encontrado");

		Candidato candidato = new Candidato(numPartido, eleitor, partido);
		candidato.setEleitor(eleitor);
		this.candidatos.add(candidato);

	}

	public void cadastrarCandidatoVereador(int cpf, String nome, int numPartido, int numCandidato)
			throws Exception {

		if (candidatos.contains(getCandidatoCPF(cpf)))
			throw new Exception("Candidato J� Cadastrado");

		Eleitor eleitor = getEleitor(cpf);
		Partido partido = getPartido(numPartido);

		if (eleitor.getCpf() != cpf)
			throw new Exception("Eleitor n�o encontrado");
		if (partido.getNumero() != numPartido)
			throw new Exception("Partido n�o encontrado");

		Candidato candidato = new Candidato(numPartido, eleitor, partido);
		candidato.setNumero(numCandidato);
		candidato.setEleitor(eleitor);
		this.candidatos.add(candidato);

	}

	public Candidato getCandidatoNumero(int numero) throws Exception {
		try {
			for (int cont = 0; cont < this.candidatos.size(); cont++) {
				Candidato candidato = this.candidatos.get(cont);
				if (candidato.getNumero() == numero) {
					return candidato;
				}
			}
		} catch (Exception e) {
			throw new Exception("Candidato Invalido");
		}
		return null;
	}

	public Candidato getCandidatoCPF(int cpf) throws Exception {
		try {
			for (int cont = 0; cont < this.candidatos.size(); cont++) {
				Candidato candidato = this.candidatos.get(cont);
				if (candidato.getCpf() == cpf) {
					return candidato;
				}
			}
		} catch (Exception e) {
			throw new Exception("Candidato Invalido");
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

				listaCandidatos += String.format("Nome: %s, N�mero: %04d, Partido: %d, CPF: %d\n",
						nome, numero, numPartido, cpf);
			}
		}

		return listaCandidatos;
	}

	public int numeroDeZonasEleitorais() {
		return zonas.size();
	}

	public int numeroDeSecoesDeUmaZona(int numeroZonaEleitoral) {
		ZonaEleitoral zona = null;
		try {
			zona = getZona(numeroZonaEleitoral);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			throw new Exception("Eleitor Invalido");
		if (endereco == null)
			throw new Exception("Endereco Invalido");
		Eleitor eleitor = getEleitor(cpf);
		eleitor.setEndereco(endereco);
	}

	public void setMunicipioDoEleitor(int cpf, String municipio) throws Exception {
		if (getEleitor(cpf) == null)
			throw new Exception("Eleitor Invalido");
		if (municipio == null)
			throw new Exception("Municipio Invalido");
		Eleitor eleitor = getEleitor(cpf);
		eleitor.setEndereco(municipio);
	}

	public void setSecaoDoEleitor(int cpf, int numSecao) throws Exception {
		if (getEleitor(cpf) == null)
			throw new Exception("Eleitor Invalido");
		if (getSecao(numSecao) == null)
			throw new Exception("Secao Invalida");
		Eleitor eleitor = getEleitor(cpf);
		Secao secao = getSecao(numSecao);
		secao.insereEleitor(eleitor);
	}

	public void setZonaDoEleitor(int cpf, int numZona) throws Exception {
		if (getEleitor(cpf) == null)
			throw new Exception("Eleitor Invalido");
		if (getZona(numZona) == null)
			throw new Exception("Zona Invalida");
		Eleitor eleitor = getEleitor(cpf);
		ZonaEleitoral zona = getZona(numZona);
		eleitor.setZona(zona);
	}

	public void setNumeroDoCandidato(int cpf, int numero) throws Exception {
		Candidato candidato = getCandidatoNumero(numero);
		if (candidato == null)
			throw new Exception("Candidato Invalido");
		if (numero == 0 || numero > 9999)
			throw new Exception("Numero de Candidato Invalido");
		candidato.setNumero(numero);
	}

	public void setPartidoDoCandidato(int cpf, int numPartido) throws Exception {
		Candidato candidato = getCandidatoCPF(cpf);
		Partido partido = getPartido(numPartido);

		if (candidato == null)
			throw new Exception("Candidato Invalido");
		if (numPartido == 0 || numPartido > 9999)
			throw new Exception("Numero de Candidato Invalido");
		if (partido == null)
			throw new Exception("Partido Invalido");

		candidato.setPartido(partido);
	}

	public void alterarLocalDeUmaZona(int numZona, String localizacao) throws Exception {
		ZonaEleitoral zona = getZona(numZona);
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

	@Override
	public List<? extends ISecao> getSecoesDeUmaZona(int numeroZonaEleitoral) throws Exception {
		return getZona(numeroZonaEleitoral).getSecoes();
	}

	public void limparEleitoresDasSecoes() {
		for (int i = 0; i < secoes.size(); i++) {
			Secao secao = secoes.get(i);
			secao.limparEleitores();
		}
	}

	// ######################################

	public void abrirUrnas() {
		for (int cont = 0; cont < this.secoes.size(); cont++) {
			Secao secao = this.secoes.get(cont);
			Urna urna = secao.getUrna();
			urna.abrirUrna();
		}
		return;
	}

	public void vota(Urna urna, Eleitor eleitor, int votoPref, int votoVere) throws Exception {
//		if (urna.eleitorVotou(eleitor)) {
//			return;
//		} else {
			urna.cadastraVotos(votoPref, votoVere);
//		}
	}

	public int contaVotosPrefeito(Urna urna, int numPrefeito) {
		int qtdVotos;
		qtdVotos = urna.contaVotosPrefeito(numPrefeito);
		return qtdVotos;
	}

}
