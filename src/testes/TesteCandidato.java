package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.FachadaCartorio;
import exceptions.ExceptionMsg;
import model.Candidato;

public class TesteCandidato {

	private FachadaCartorio cartorio;

	@Before
	public void configura() throws ExceptionMsg {
		cartorio = new FachadaCartorio();

		cartorio.cadastrarEleitor("Jorge", 123, 12345);
		cartorio.cadastrarPartido(13, "PT");
	}

	@Test
	public void cadastraCandidato() {

		try {
			int cpf = 123;
			String nome = "Jorge";
			int numPartido = 13;
			int numero = 100;

			cartorio.cadastrarCandidato(cpf, nome, numPartido, numero);
			assertEquals(1, cartorio.numeroDeCandidatos());
		} catch (ExceptionMsg e) {
		}
	}

	@Test
	public void atribuiPartidoACandidato() {
		try {
			int cpf = 123;
			String nome = "Jorge";
			int numPartido = 13;
			int numero = 100;

			cartorio.cadastrarCandidato(cpf, nome, numPartido, numero);
			Candidato candidato = cartorio.getCandidatoNumero(100);
			assertEquals(13, candidato.getPartido().getNumero());
		} catch (ExceptionMsg e) {
		}
	}

}
