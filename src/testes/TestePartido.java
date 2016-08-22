package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.FachadaCartorio;
import exceptions.ExceptionMsg;

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
	public void Cadastra2PartidosComMesmoNumero() throws Exception {
		cartorio.cadastrarPartido(13, "PT");
		cartorio.cadastrarPartido(13, "PMDB");
		assertEquals(1, cartorio.numeroDePartidos());
	}
}
