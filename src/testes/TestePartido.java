package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modelo.Candidato;
import modelo.Eleitor;
import modelo.FachadaCartorioEleitoral;
import modelo.Partido;

public class TestePartido {

	private FachadaCartorioEleitoral cartorio;

	@Before
	public void configura() {
		cartorio = new FachadaCartorioEleitoral();
	}

	@Test
	public void CadastraPartido() throws Exception {
		cartorio.cadastrarPartido("Partido dos Trabalhadores", "PT", 13);
		assertEquals(1, cartorio.numeroDePartidos());
	}

	@Test
	public void Cadastra2PartidosIguais() {
		try {
			cartorio.cadastrarPartido("Partido dos Trabalhadores", "PT", 13);
			cartorio.cadastrarPartido("Partido dos Trabalhadores", "PT", 13);
		} catch (Exception e) {
			assertEquals(1, cartorio.numeroDePartidos());
		}
	}

	@Test
	public void Cadastra4PartidosDiferentes() throws Exception {
		cartorio.cadastrarPartido("Partido dos Trabalhadores", "PT", 13);
		cartorio.cadastrarPartido("Partido do Movimento Democrático Brasileiro", "PMDB", 15);
		cartorio.cadastrarPartido("Partido da Social Democracia Brasileira", "PSDB", 45);
		cartorio.cadastrarPartido("Partido Verde", "PV", 43);
		assertEquals(4, cartorio.numeroDePartidos());
	}

	@Test
	public void Cadastra2PartidosComMesmoNumero() {
		try {
			cartorio.cadastrarPartido("Partido dos Trabalhadores", "PT", 13);
			cartorio.cadastrarPartido("Partido do Movimento Democrático Brasileiro", "PMDB", 13);
			fail();
		} catch (Exception e) {
		}

	}

	@Test
	public void AtribuiCandidatoPrefeitoAoPartido() throws Exception {
		String nome = "Carol";
		int cpf = 123;
		int titulo = 12345;
		int numeroPartido = 13;
		String nomePartido = "Partido dos Trabalhadores";
		String siglaPartido = "PT";

		cartorio.cadastrarEleitor(nome, cpf, titulo);
		cartorio.cadastrarPartido(nomePartido, siglaPartido, numeroPartido);
		cartorio.cadastrarCandidatoPrefeito(cpf, nome, numeroPartido);

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
		int numeroPartido = 13;
		String nomePartido = "Partido dos Trabalhadores";
		String siglaPartido = "PT";

		cartorio.cadastrarEleitor(nome, cpf, titulo);
		cartorio.cadastrarPartido(nomePartido, siglaPartido, numeroPartido);
		cartorio.cadastrarCandidatoPrefeito(cpf, nome, numeroPartido);

		Partido partido = cartorio.getPartido(13);
		Candidato candidato = cartorio.getCandidatoCPF(cpf);
		Eleitor eleitor = cartorio.getEleitor(cpf);

		assertEquals(candidato.getCpf(), eleitor.getCpf());
		assertEquals(13, partido.getNumero());

		partido.setCandidatoVereador(candidato);
		assertEquals(candidato, partido.getCandidatoVereador(0));
	}

	@Test
	public void AtribuiDoisCandidatosAUmPartido() throws Exception {
		cartorio.cadastrarEleitor("Carol", 123, 123);
		cartorio.cadastrarEleitor("Jorge", 999, 999);
		cartorio.cadastrarPartido("Partido dos Trabalhadores", "PT", 13);
		cartorio.cadastrarCandidatoPrefeito(123, "Carol", 13);
		cartorio.cadastrarCandidatoPrefeito(999, "Jorge", 13);

		Partido partido = cartorio.getPartido(13);
		Candidato candidatoPrefeito = cartorio.getCandidatoCPF(123);
		Candidato candidatoVereador = cartorio.getCandidatoCPF(999);

		partido.setCandidatoPrefeito(candidatoPrefeito);
		partido.setCandidatoVereador(candidatoVereador);

		assertEquals("Carol", partido.getCandidatoPrefeito().getNome());
		assertEquals("Jorge", partido.getCandidatoVereador(0).getNome());
	}

	@Test
	public void AtribuiCincoCandidatosAVereadorAoMesmoPartido() throws Exception {
		try {
			int num1 = 001;
			int num2 = 002;
			int num3 = 003;
			int num4 = 004;
			int num5 = 005;

			cartorio.cadastrarEleitor("Carol", num1, num1);
			cartorio.cadastrarEleitor("Jorge", num2, num2);
			cartorio.cadastrarEleitor("Julia", num3, num3);
			cartorio.cadastrarEleitor("Amanda", num4, num4);
			cartorio.cadastrarEleitor("Gabi", num5, num5);

			cartorio.cadastrarPartido("Partido dos Trabalhadores", "PT", 13);
			cartorio.cadastrarCandidatoPrefeito(num1, "Carol", 13);
			cartorio.cadastrarCandidatoPrefeito(num2, "Jorge", 13);
			cartorio.cadastrarCandidatoPrefeito(num3, "Julia", 13);
			cartorio.cadastrarCandidatoPrefeito(num4, "Amanda", 13);
			cartorio.cadastrarCandidatoPrefeito(num5, "Gabi", 13);

			Partido partido = cartorio.getPartido(13);
			Candidato candidato1 = cartorio.getCandidatoCPF(num1);
			Candidato candidato2 = cartorio.getCandidatoCPF(num2);
			Candidato candidato3 = cartorio.getCandidatoCPF(num3);
			Candidato candidato4 = cartorio.getCandidatoCPF(num4);
			Candidato candidato5 = cartorio.getCandidatoCPF(num5);

			partido.setCandidatoVereador(candidato1);
			partido.setCandidatoVereador(candidato2);
			partido.setCandidatoVereador(candidato3);
			partido.setCandidatoVereador(candidato4);
			partido.setCandidatoVereador(candidato5);
		} catch (Exception e) {
		}

	}
}