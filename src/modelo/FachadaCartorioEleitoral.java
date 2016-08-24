package modelo;

import java.util.ArrayList;
import java.util.List;

import controller.Main;
import exceptions.ExceptionMsg;
import interfaces.CartorioEleitoral;
import interfaces.ISecao;

public class FachadaCartorioEleitoral implements CartorioEleitoral {
	private ArrayList<ZonaEleitoral> zonas;
	private ArrayList<Eleitor> eleitores;
	private ArrayList<Secao> secoes;
	private ArrayList<Partido> partidos;
	private ArrayList<Candidato> candidatos;

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
			throw new ExceptionMsg("Zona já cadastrada");
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
			throw new ExceptionMsg("Zona Invalida");
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
			throw new ExceptionMsg("Zona não encontrada");
		} else {
			ZonaEleitoral zona = (ZonaEleitoral) getZona(numeroZonaEleitoral);
			Secao secao = zona.criarNovaSecao();
			this.secoes.add(secao);
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

		for (int i = 0; i < Main.fachada.numeroDeZonasEleitorais(); i++) {
			ZonaEleitoral zona = Main.fachada.zonas.get(i);
			for (int cont = 0; cont < Main.fachada.secoes.size(); cont++) {
				Secao secao = Main.fachada.secoes.get(cont);
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

	public String qtdSecoesNumaZona(int numZona) throws Exception {
		ZonaEleitoral zona = getZona(numZona);
		String listaSecoesDeUmaZona = String.format("A Zona %d possui %d Secoes", numZona,
				zona.getNumeroSecoes());
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
		if (numeroPartido == 0 || numeroPartido > 99)
			throw new ExceptionMsg(
					"Numero do Partido Inválido " + "(Igual a 0 ou Mais de Dois Digitos)");
		if (siglaPartido.length() >= 5)
			throw new ExceptionMsg("Sigla inválida (Mais de Dois Digitos)");

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
		ZonaEleitoral zona = getZona(numZona);
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
		// TODO Auto-generated method stub
		return null;
	}

}