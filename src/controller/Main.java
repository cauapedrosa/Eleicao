package controller;

import exceptions.ExceptionMsg;
import model.Zona;
import view.GUI;

public class Main {

	public static FachadaCartorio fachada = new FachadaCartorio();

	public static void main(String[] args) throws Exception {

		boolean loopFlag = true;
		while (loopFlag) {

			String opcaoSelecionada = GUI.mainMenu();

			if (opcaoSelecionada != null) {
				switch (opcaoSelecionada) {
				case "Cadastrar Zona":
					cadastrarZona();
					break;
				case "Cadastrar Seção":
					cadastrarSecao();
					break;
				case "Cadastrar Eleitor":
					cadastrarEleitor();
					break;
				case "Cadastrar Partido":
					cadastraPartido();
					break;
				case "Cadastrar Candidato":
					cadastraCandidato();
					break;
				case "Editar Cadastros":
					editarCadastros();
					break;
				case "Verificar Cadastros":
					verificarCadastros();
					break;
				default:
					loopFlag = false;
					break;
				}
			} else {
				loopFlag = false;
			}
		}

	}

	private static void cadastrarZona() throws Exception {
		int numeroZonaEleitoral = GUI.inputInt("Digite o Numero da Zona Eleitoral");
		String localizacao = GUI.inputStr("Digite a localizacao da Zona Eleitoral");
		fachada.cadastraZona(numeroZonaEleitoral, localizacao);
		GUI.printToConsole(
				String.format("Zona Cadastrada: %d - %s \n" + "Numero de Zonas aumentado para: %d",
						numeroZonaEleitoral, localizacao, fachada.numeroDeZonas()));
	}

	private static void cadastrarSecao() throws Exception {

		int numero = GUI
				.inputInt("Digite o Número da Zona Eleitoral em que deseja cadastrar uma Seção");
		fachada.cadastrarSecao(numero);
		GUI.printToConsole(String.format(
				"Numero Total de Seções aumentado para: %d \n"
						+ "Numero de Seções da Zona %d aumentado para %d",
				fachada.numeroDeSecoes(), numero,
				fachada.numeroDeSecoesDeUmaZona(fachada.getZona(numero))));

	}

	private static void cadastrarEleitor() throws Exception {

		String nome = GUI.inputStr("Digite o Nome do Eleitor");
		int cpf = GUI.inputInt("Digite o CPF do Eleitor");
		int titulo = GUI.inputInt("Digite o Titulo do Eleitor");

		fachada.cadastrarEleitor(nome, cpf, titulo);

		GUI.printToConsole(String.format(
				"Eleitor Cadastrado: %s \nCPF: %d \nTitulo: %d \n"
						+ "Numero de Eleitores aumentado para %d",
				nome, cpf, titulo, fachada.numeroDeEleitores()));
	}

	private static void cadastraPartido() throws Exception {

		String nomePartido = GUI.inputStr("Digite o Nome do Partido");
		int numeroPartido = GUI.inputInt("Digite o Numero do Partido");
		String siglaPartido = GUI.inputStr("Digite a Sigla do Partido (até 5 caracteres");

		if (numeroPartido == 0 || numeroPartido > 99 || nomePartido == null)
			throw new ExceptionMsg("Partido Invalido");
		else {
			fachada.cadastrarPartido(nomePartido, siglaPartido, numeroPartido);
		}
		GUI.printToConsole(String.format(
				"Partido Cadastrado: %d - %s \n" + "Numero de Partidos Aumentado Para: %d",
				numeroPartido, nomePartido, fachada.numeroDePartidos()));

	}

	private static void cadastraCandidato() throws Exception {
		int cpf = GUI.inputInt("Digite o CPF do Candidato");
		if (fachada.getEleitor(cpf) == null) {
			throw new ExceptionMsg("CPF Não Encontrado");
		}
		String nome = fachada.getEleitor(cpf).getNome();
		int numPartido = GUI.inputInt("Digite o Numero do Partido do Candidato");
		if (fachada.getPartido(numPartido) == null) {
			throw new ExceptionMsg("Partido Não Encontrado");
		}
		int numero = GUI.inputInt("Digite o Numero de Candidato do Candidato");
		if (numero == 0 || numero > 999) {
			throw new ExceptionMsg("Numero de Candidato Inválido");
		}

		fachada.cadastrarCandidato(cpf, nome, numPartido, numero);

		GUI.printToConsole(String.format(
				"Candidato Cadastrado: %s \nCPF: %d \nNumero do Candidato: %d \nNumero do Partido: %d\n"
						+ "Numero de Candidatos Aumentado Para: %d",
				nome, cpf, numero, numPartido, fachada.numeroDeCandidatos()));
	}

	private static void editarCadastros() throws Exception {
		boolean loopFlag = true;
		while (loopFlag) {

			int opcaoSelecionada = GUI.inputInt(
					"1 - Atualizar Cadastro de Eleitor \n" + "2 - Atualizar Cadastro de Partido \n"
							+ "3 - Atualizar Cadastro de Candidato \n"
							+ "4 - Atualizar Cadastro de Zona/Secao \n" + "0 - Sair");

			switch (opcaoSelecionada) {
			case 0:
				loopFlag = false;
				break;
			case 1:
				atualizarCadastroEleitor();
				break;
			case 2:
				atualizarCadastroPartido();
				break;
			case 3:
				atualizarCadastroCandidato();
				break;
			case 4:
				atualizarCadastroZonaSecao();
				break;
			default:
				opcaoSelecionada = 0;
				break;
			}
		}
	}

	private static void atualizarCadastroEleitor() throws Exception {
		boolean loopFlag = true;
		int cpf, numZona;
		while (loopFlag) {
			int opcaoSelecionada = GUI.inputInt("1 - Definir Zona do Eleitor \n"
					+ "2 - Definir Secao do Eleitor \n" + "3 - Definir Municipio do Eleitor \n"
					+ "4 - Definir Endereco do Eleitor \n" + "0 - Sair");

			switch (opcaoSelecionada) {
			case 0:
				loopFlag = false;
				break;
			case 1:
				cpf = GUI.inputInt("Insira o CPF do Eleitor");
				numZona = GUI.inputInt("Insira o Numero da Zona");
				fachada.setZonaDoEleitor(cpf, numZona);
				break;
			case 2:
				cpf = GUI.inputInt("Insira o CPF do Eleitor");
				numZona = GUI.inputInt("Insira o Numero da Zona");
				int numSecao = GUI.inputInt("Insira o Numero da Secao");
				fachada.setSecaoDoEleitor(cpf, numSecao);
				break;
			case 3:
				cpf = GUI.inputInt("Insira o CPF do Eleitor");
				String municipio = GUI.inputStr("Insira o Municipio do Eleitor");
				fachada.setMunicipioDoEleitor(cpf, municipio);
				break;
			case 4:
				cpf = GUI.inputInt("Insira o CPF do Eleitor");
				String endereco = GUI.inputStr("Insira o Endereco do Eleitor");
				fachada.setEnderecoDoEleitor(cpf, endereco);
				break;
			default:
				opcaoSelecionada = 0;
				break;
			}
		}
	}

	private static void atualizarCadastroPartido() throws Exception {
		boolean loopFlag = true;
		int numPartido;
		while (loopFlag) {
			int opcaoSelecionada = GUI.inputInt(
					"1 - Alterar o Numero de um Partido \n" + "2 - Alterar o Nome de um Partido \n"
							+ "3 - Alterar a Sigla de um Partido" + "0 - Sair");

			switch (opcaoSelecionada) {
			case 0:
				loopFlag = false;
				break;
			case 1:
				numPartido = GUI.inputInt("Digite o Numero do Partido");
				int novoNumPartido = GUI.inputInt("Digite o Novo Numero do Partido");
				fachada.alterarNumeroPartido(numPartido, novoNumPartido);
				break;
			case 2:
				numPartido = GUI.inputInt("Digite o Numero do Partido");
				String novoNomePartido = ("Digite o Novo Nome do Partido");
				fachada.alterarNomePartido(numPartido, novoNomePartido);
				break;
			case 3:
				numPartido = GUI.inputInt("Digite o Numero do Partido");
				String novaSiglaPartido = ("Digite a Nova Sigla do Partido");
				fachada.alterarSiglaPartido(numPartido, novaSiglaPartido);
				break;
			default:
				opcaoSelecionada = 0;
				break;
			}
		}
	}

	private static void atualizarCadastroCandidato() throws Exception {
		boolean loopFlag = true;
		int cpf;
		while (loopFlag) {
			int opcaoSelecionada = GUI.inputInt("1 - Alterar Partido do Candidato \n"
					+ "2 - Alterar Numero do Candidato \n" + "0 - Sair");

			switch (opcaoSelecionada) {
			case 0:
				loopFlag = false;
				break;
			case 1:
				cpf = GUI.inputInt("Digite o CPF do Candidato");
				int numPartido = GUI.inputInt("Digite o Numero do Novo Partido do Candidato");
				fachada.setPartidoDoCandidato(cpf, numPartido);
				break;
			case 2:
				cpf = GUI.inputInt("Digite o CPF do Candidato");
				int numero = GUI.inputInt("Digite o Novo Numero do Candidato");
				fachada.setNumeroDoCandidato(cpf, numero);
				break;
			default:
				opcaoSelecionada = 0;
				break;
			}
		}
	}

	private static void atualizarCadastroZonaSecao() throws Exception {
		boolean loopFlag = true;
		while (loopFlag) {
			int opcaoSelecionada = GUI.inputInt("1 - Alterar o Local de uma Zona \n"
					+ "2 - Remover TODOS os Eleitores de TODAS as Secoes \n" + "0 - Sair");

			switch (opcaoSelecionada) {
			case 0:
				loopFlag = false;
				break;
			case 1:
				int numZona = GUI.inputInt("Digite o Numero da Zona");
				String localizacao = GUI.inputStr("Digite a Nova Localizacao da Zona");
				fachada.alterarLocalDeUmaZona(numZona, localizacao);
				break;
			case 2:
				// TODO Implementar Funcao
				// fachada.limparEleitoresDasSecoes();
				GUI.messagePopup("Funcao Ainda Não Implementada");
				break;
			default:
				opcaoSelecionada = 0;
				break;
			}
		}
	}

	private static void verificarCadastros() throws Exception {
		boolean loopFlag = true;
		while (loopFlag) {

			int opcaoSelecionada = GUI.inputInt("1 - Verificar Zona \n" + "2 - Verificar Seção \n"
					+ "3 - Verificar Eleitor \n" + "4 - Verificar Partido \n"
					+ "5 - Verificar Candidato \n" + "0 - Sair");

			switch (opcaoSelecionada) {
			case 0:
				loopFlag = false;
				break;
			case 1:
				verificarZona();
				break;
			case 2:
				verificarSecao();
				break;
			case 3:
				verificarEleitor();
				break;
			case 4:
				verificarPartido();
				break;
			case 5:
				verificarCandidato();
				break;
			default:
				opcaoSelecionada = 0;
				break;
			}
		}
	}

	private static void verificarZona() throws Exception {
		boolean loopFlag = true;
		while (loopFlag) {
			int opcaoSelecionada = GUI
					.inputInt("Digite o numero da Opcao que voce deseja realizar: \n"
							+ "1 - Checar um Número de Zona \n" + "2 - Listar Todas as Zonas \n"
							+ "0 - Sair\n");

			switch (opcaoSelecionada) {
			case 0:
				loopFlag = false;
				break;
			case 1:
				int numeroZona = GUI.inputInt("Digite o numero da Zona que voce procura \n");
				String msg = "";
				Zona zona = fachada.getZona(numeroZona);
				if (zona == null) {
					throw new ExceptionMsg("Nenhuma Zona Encontrada");
				} else {
					msg += String.format("%d é uma Zona Existente\nLocalização: %s",
							zona.getNumero(), zona.getLocalizacao());
					GUI.messagePopup(msg);
				}
				break;
			case 2:
				String listaZonas = fachada.listarZonas();
				GUI.messagePopup(listaZonas);
			default:
				loopFlag = false;
				break;
			}
		}
	}

	private static void verificarSecao() throws Exception {
		boolean loopFlag = true;
		while (loopFlag) {
			int opcaoSelecionada = GUI
					.inputInt("Digite o numero da opcao que voce deseja realizar: \n"
							+ "1 - Ver a quantidade de Secoes de uma Zona específica \n"
							+ "2 - Listar todas as Secoes \n" + "0 - Sair \n");

			switch (opcaoSelecionada) {
			case 0:
				loopFlag = false;
				break;
			case 1:
				int numeroZona = GUI.inputInt("Digite o numero da Zona");
				if (fachada.getZona(numeroZona) == null) {
					throw new ExceptionMsg("Zona não Encontrada");
				} else {
					String listaSecoesDeUmaZona = fachada.qtdSecoesNumaZona(numeroZona);
					GUI.messagePopup(listaSecoesDeUmaZona);
				}
				break;
			case 2:
				String listaSecoes = fachada.listarTodasSecoes();
				GUI.messagePopup(listaSecoes);
			default:
				loopFlag = false;
				break;
			}
		}
	}

	private static void verificarEleitor() throws Exception {
		boolean loopFlag = true;
		while (loopFlag) {
			int opcaoSelecionada = GUI
					.inputInt("Digite o numero da Opcao que voce deseja realizar: \n"
							+ "1 - Procurar Eleitor por CPF \n" + "2 - Listar Todos os Eleitores \n"
							+ "0 - Sair \n");

			switch (opcaoSelecionada) {
			case 0:
				loopFlag = false;
				break;
			case 1:
				int cpf = GUI.inputInt("Digite o CPF do Eleitor que deseja procurar");
				String msg = "";
				if (fachada.getEleitor(cpf) == null) {
					throw new ExceptionMsg("Nenhum Eleitor Encontrado");
				} else {
					// fachada.getEleitor(cpf)
					msg += String.format(
							"Nome: %s\n" + "CPF: %d \n" + "Titulo: %d \n" + "Zona: %03d \n"
									+ "Secao: %02d \n" + "Endereco: %s \n" + "Municipio: %s \n",
							fachada.getEleitor(cpf).getNome(), fachada.getEleitor(cpf).getCpf(),
							fachada.getEleitor(cpf).getTitulo(), fachada.getEleitor(cpf).getZona(),
							fachada.getEleitor(cpf).getSecao(),
							fachada.getEleitor(cpf).getEndereco(),
							fachada.getEleitor(cpf).getMunicipio());
					GUI.messagePopup(msg);
				}
				break;
			case 2:
				String listaEleitores = fachada.listarEleitores();
				GUI.messagePopup(listaEleitores);
				break;
			default:
				loopFlag = false;
				break;
			}
		}
	}

	private static void verificarPartido() throws Exception {
		boolean loopFlag = true;
		while (loopFlag) {
			int opcaoSelecionada = GUI
					.inputInt("Digite o numero da Opcao que voce deseja realizar: \n"
							+ "1 - Procurar Partido por Número \n"
							+ "2 - Listar Todos os Partidos \n" + "0 - Sair \n");

			switch (opcaoSelecionada) {
			case 0:
				loopFlag = false;
				break;
			case 1:
				int num = GUI.inputInt("Digite o Numero do Partido que deseja procurar");
				if (fachada.getPartido(num) == null) {
					throw new ExceptionMsg("Nenhum Partido Encontrado");
				} else {
					GUI.messagePopup(String.format("%d é um Partido Existente. \n Nome: %s", num,
							fachada.getPartido(num).getNome()));
				}
				break;
			case 2:
				String listaPartidos = fachada.listarPartidos();
				GUI.messagePopup(listaPartidos);
				break;
			default:
				loopFlag = false;
				break;
			}
		}
	}

	private static void verificarCandidato() throws Exception {
		boolean loopFlag = true;
		while (loopFlag) {
			int opcaoSelecionada = GUI
					.inputInt("Digite o numero da Opcao que voce deseja realizar: \n"
							+ "1 - Procurar Candidato por Número \n"
							+ "2 - Listar Todos os Candidatos \n" + "0 - Sair \n");

			switch (opcaoSelecionada) {
			case 0:
				loopFlag = false;
				break;
			case 1:
				int num = GUI.inputInt("Digite o Numero do Candidato que deseja procurar");
				if (fachada.getCandidatoNumero(num) == null) {
					throw new ExceptionMsg("Nenhum Candidato Encontrado");
				} else {
					GUI.messagePopup(String.format("%d é um Candidato Existente. \n Nome: %s", num,
							fachada.getCandidatoNumero(num).getNome()));
				}
				break;
			case 2:
				String listaCandidatos = fachada.listarCandidatos();
				GUI.messagePopup(listaCandidatos);
				break;
			default:
				loopFlag = false;
				break;
			}
		}
	}

}
