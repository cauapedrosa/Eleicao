package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.FachadaCartorio;
import exceptions.ExceptionJaCadastrado;

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
		} catch (ExceptionJaCadastrado e) {
			assertEquals(1, cartorio.numeroDePartidos());
		}
	}

	@Test
	public void Cadastra2PartidosDiferentes() throws Exception {
		cartorio.cadastrarPartido(13, "PT");
		cartorio.cadastrarPartido(45, "PxDB");
		assertEquals(2, cartorio.numeroDePartidos());
	}
}
