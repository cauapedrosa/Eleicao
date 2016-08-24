package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modelo.FachadaCartorioEleitoral;

public class TesteZona {

	private FachadaCartorioEleitoral cartorio;

	@Before
	public void configura() {
		cartorio = new FachadaCartorioEleitoral();

	}

	@Test
	public void cadastraZona101DuasVezes() {
		try {
			cartorio.cadastraZonaEleitoral(101, "Estreito");
			assertEquals(1, cartorio.numeroDeZonasEleitorais());
			cartorio.cadastraZonaEleitoral(101, "Estreito");
		} catch (Exception e) {
			assertEquals(1, cartorio.numeroDeZonasEleitorais());
		}
	}

	@Test
	public void cadastraZonas101E102() throws Exception {
		cartorio.cadastraZonaEleitoral(101, "Estreito");
		cartorio.cadastraZonaEleitoral(102, "Centro");
		assertEquals(2, cartorio.numeroDeZonasEleitorais());
	}

	@Test
	public void cadastra3Zonas_DepoisUmaRepetida() {
		try {
			cartorio.cadastraZonaEleitoral(101, "Estreito");
			cartorio.cadastraZonaEleitoral(102, "Centro");
			cartorio.cadastraZonaEleitoral(103, "Carvoeira");
			cartorio.cadastraZonaEleitoral(102, "NaoCentro");
		} catch (Exception e) {
			assertEquals(3, cartorio.numeroDeZonasEleitorais());
		}

	}

	@Test
	public void cadastraZona101_cadastraDnvComOutraLocalizacao() {
		try {
			cartorio.cadastraZonaEleitoral(101, "Estreito");
			cartorio.cadastraZonaEleitoral(101, "NaoEstreito");
		} catch (Exception e) {
			assertEquals(1, cartorio.numeroDeZonasEleitorais());
		}
	}

}
