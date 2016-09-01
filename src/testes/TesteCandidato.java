package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modelo.Candidato;
import modelo.FachadaCartorioEleitoral;

public class TesteCandidato {

	private FachadaCartorioEleitoral cartorio;

	@Before
	public void configura() throws Exception {
		cartorio = new FachadaCartorioEleitoral();

		cartorio.cadastrarEleitor("Jorge", 123, 12345);
		cartorio.cadastrarPartido("Partido dos Trabalhadores", "PT", 13);
	}

	@Test
	public void cadastraCandidato() {

		try {
			int cpf = 123;
			String nome = "Jorge";
			int numPartido = 13;

			cartorio.cadastrarCandidatoPrefeito(cpf, nome, numPartido);
			assertEquals(1, cartorio.numeroDeCandidatos());
		} catch (Exception e) {
		}
	}

	@Test
	public void atribuiPartidoACandidato() {
		try {
			int cpf = 123;
			String nome = "Jorge";
			int numPartido = 13;

			cartorio.cadastrarCandidatoPrefeito(cpf, nome, numPartido);
			Candidato candidato = cartorio.getCandidatoNumero(100);
			assertEquals(13, candidato.getPartido().getNumero());
		} catch (Exception e) {
		}
	}

}
