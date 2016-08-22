package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.FachadaCartorio;

public class TesteSecao {

	private FachadaCartorio cartorio;

	@Before
	public void configura() throws Exception {
		cartorio = new FachadaCartorio();

		cartorio.cadastraZona(101, "UFSC");
		cartorio.cadastraZona(102, "Carvoeira");
		cartorio.cadastraZona(103, "Estreito");
	}

	@Test
	public void cadastraUmaSecao() throws Exception {
		cartorio.cadastrarSecao(101);
		assertEquals(1, cartorio.numeroDeSecoes());
	}
}
