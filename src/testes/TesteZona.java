package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.FachadaCartorio;
import exceptions.ExceptionJaCadastrado;

public class TesteZona {

	private FachadaCartorio cartorio;

	@Before
	public void configura() {
		cartorio = new FachadaCartorio();

	}

	@Test
	public void cadastraZona101DuasVezes() {
		try {
			cartorio.cadastraZona(101, "Estreito");
			assertEquals(1, cartorio.numeroDeZonas());
			cartorio.cadastraZona(101, "Estreito");
		} catch (ExceptionJaCadastrado e) {
			assertEquals(1, cartorio.numeroDeZonas());

		}
	}

	@Test
	public void cadastraZonas101E102() throws Exception {
		cartorio.cadastraZona(101, "Estreito");
		cartorio.cadastraZona(102, "Centro");
		assertEquals(2, cartorio.numeroDeZonas());
	}

	@Test
	public void cadastra3Zonas_DepoisUmaRepetida() throws Exception {
		cartorio.cadastraZona(101, "Estreito");
		cartorio.cadastraZona(102, "Centro");
		cartorio.cadastraZona(103, "Carvoeira");
		cartorio.cadastraZona(102, "NaoCentro");
		assertEquals(3, cartorio.numeroDeZonas());
	}

	@Test
	public void cadastraZona101_cadastraDnvComOutraLocalizacao() throws Exception {
		cartorio.cadastraZona(101, "Estreito");
		cartorio.cadastraZona(101, "NaoEstreito");
		assertEquals(1, cartorio.numeroDeZonas());
	}

}
