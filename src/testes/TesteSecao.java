package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.FachadaCartorio;
import model.Eleitor;
import model.Secao;

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

	@Test
	public void cadastraTresSecoesNaZona101() throws Exception {
		cartorio.cadastrarSecao(101);
		cartorio.cadastrarSecao(101);
		cartorio.cadastrarSecao(101);
		assertEquals(3, cartorio.numeroDeSecoes());
	}

	@Test
	public void cadastraTresSecoesEmTresZonas() throws Exception {
		cartorio.cadastrarSecao(101);
		cartorio.cadastrarSecao(101);
		cartorio.cadastrarSecao(101);
		cartorio.cadastrarSecao(102);
		cartorio.cadastrarSecao(102);
		cartorio.cadastrarSecao(102);
		cartorio.cadastrarSecao(103);
		cartorio.cadastrarSecao(103);
		cartorio.cadastrarSecao(103);
		assertEquals(9, cartorio.numeroDeSecoes());
	}

	@Test
	public void atribuiEleitorASecao() throws Exception {
		cartorio.cadastrarSecao(101);
		cartorio.cadastrarEleitor("Jorge", 123, 123);
		cartorio.setSecaoDoEleitor(123, 1);

		Secao secao = cartorio.getSecao(1);
		Eleitor eleitor = cartorio.getEleitor(123);

		assertEquals(true, secao.verificaSeEleitorVotaNestaSecao(eleitor));
	}
}
