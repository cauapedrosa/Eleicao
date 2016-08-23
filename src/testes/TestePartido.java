package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.FachadaCartorio;
import exceptions.ExceptionMsg;
import model.Candidato;
import model.Eleitor;
import model.Partido;

public class TestePartido {

	private FachadaCartorio cartorio;

	@Before
	public void configura() {
		cartorio = new FachadaCartorio();
	}

	@Test
	public void CadastraPartido() throws Exception {
		cartorio.cadastrarPartido(13, "PT");
		assertEquals(1, cartorio.numeroDePartidos());
	}

	@Test
	public void Cadastra2PartidosIguais() {
		try {
			cartorio.cadastrarPartido(13, "PT");
			cartorio.cadastrarPartido(13, "PT");
		} catch (ExceptionMsg e) {
			assertEquals(1, cartorio.numeroDePartidos());
		}
	}

	@Test
	public void Cadastra4PartidosDiferentes() throws Exception {
		cartorio.cadastrarPartido(13, "PT");
		cartorio.cadastrarPartido(15, "PMDB");
		cartorio.cadastrarPartido(45, "PSDB");
		cartorio.cadastrarPartido(43, "PV");
		assertEquals(4, cartorio.numeroDePartidos());
	}

	@Test
	public void Cadastra2PartidosComMesmoNumero() {
		try {
			cartorio.cadastrarPartido(13, "PT");
			cartorio.cadastrarPartido(13, "PMDB");
			fail();
		} catch (ExceptionMsg e) {
		}

	}

	@Test
	public void AtribuiCandidatoPrefeitoAoPartido() throws Exception {
		String nome = "Carol";
		int cpf = 123;
		int titulo = 12345;
		int numPartido = 13;
		String nomePartido = "PT";
		int numCandidato = 100;

		cartorio.cadastrarEleitor(nome, cpf, titulo);
		cartorio.cadastrarPartido(numPartido, nomePartido);
		cartorio.cadastrarCandidato(cpf, nome, numPartido, numCandidato);

		Partido partido = cartorio.getPartido(13);
		Candidato candidato = cartorio.getCandidatoNumero(100);
		partido.setCandidatoPrefeito(candidato);
		assertEquals(candidato, partido.getCandidatoPrefeito());
	}

	@Test
	public void AtribuiCandidatoVereadorAoPartido() throws Exception {
		String nome = "Carol";
		int cpf = 123;
		int titulo = 12345;
		int numPartido = 13;
		String nomePartido = "PT";
		int numCandidato = 100;

		cartorio.cadastrarEleitor(nome, cpf, titulo);
		cartorio.cadastrarPartido(numPartido, nomePartido);
		cartorio.cadastrarCandidato(cpf, nome, numPartido, numCandidato);

		Partido partido = cartorio.getPartido(13);
		Candidato candidato = cartorio.getCandidatoNumero(100);
		Eleitor eleitor = cartorio.getEleitor(cpf);

		assertEquals(candidato.getCpf(), eleitor.getCpf());
		assertEquals(13, partido.getNumero());

		partido.setCandidatoVereador(candidato);
		assertEquals(candidato, partido.getCandidatoVereador(0));
	}
}
