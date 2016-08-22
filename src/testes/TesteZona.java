package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.FachadaCartorio;
import exceptions.ExceptionMsg;

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
		} catch (ExceptionMsg e) {
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
	public void cadastra3Zonas_DepoisUmaRepetida() {
		try {
			cartorio.cadastraZona(101, "Estreito");
			cartorio.cadastraZona(102, "Centro");
			cartorio.cadastraZona(103, "Carvoeira");
			cartorio.cadastraZona(102, "NaoCentro");
		} catch (ExceptionMsg e) {
			assertEquals(3, cartorio.numeroDeZonas());
		}

	}

	@Test
	public void cadastraZona101_cadastraDnvComOutraLocalizacao() {
		try {
			cartorio.cadastraZona(101, "Estreito");
			cartorio.cadastraZona(101, "NaoEstreito");
		} catch (ExceptionMsg e) {
			assertEquals(1, cartorio.numeroDeZonas());
		}
	}

}
