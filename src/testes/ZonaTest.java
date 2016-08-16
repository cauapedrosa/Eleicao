package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.FachadaCartorioEleitoral;
import model.ZonaEleitoral;

public class ZonaTest {

	private FachadaCartorioEleitoral cartorio;

	@Before
	public void configura() {
		cartorio = new FachadaCartorioEleitoral();

	}

	@Test
	public void cadastraZona101DuasVezes() {
		cartorio.cadastraZonaEleitoral(101, "Estreito");
		assertEquals(1, cartorio.numeroDeZonasEleitorais());
		cartorio.cadastraZonaEleitoral(101, "Estreito");
		assertEquals(1, cartorio.numeroDeZonasEleitorais());
	}

	@Test
	public void cadastraZonas101E102() {
		cartorio.cadastraZonaEleitoral(101, "Estreito");
		cartorio.cadastraZonaEleitoral(102, "Centro");
		assertEquals(2, cartorio.numeroDeZonasEleitorais());
	}

	@Test
	public void cadastra3Zonas_DepoisUmaRepetida() {
		cartorio.cadastraZonaEleitoral(101, "Estreito");
		cartorio.cadastraZonaEleitoral(102, "Centro");
		cartorio.cadastraZonaEleitoral(103, "Carvoeira");
		cartorio.cadastraZonaEleitoral(102, "NaoCentro");
		assertEquals(3, cartorio.numeroDeZonasEleitorais());
	}

	@Test
	public void cadastraZona101_cadastraDnvComOutraLocalizacao() {
		cartorio.cadastraZonaEleitoral(101, "Estreito");
		cartorio.cadastraZonaEleitoral(101, "NaoEstreito");
		assertEquals(1, cartorio.numeroDeZonasEleitorais());
	}

}
