package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modelo.Eleitor;
import modelo.FachadaCartorioEleitoral;
import modelo.Secao;

public class TesteSecao {

	private FachadaCartorioEleitoral cartorio;

	@Before
	public void configura() throws Exception {
		cartorio = new FachadaCartorioEleitoral();

		cartorio.cadastraZonaEleitoral(101, "UFSC");
		cartorio.cadastraZonaEleitoral(102, "Carvoeira");
		cartorio.cadastraZonaEleitoral(103, "Estreito");
	}

	@Test
	public void cadastraUmaSecao() throws Exception {
		( cartorio).cadastraSecaoEleitoral(101);
		assertEquals(1, cartorio.numeroDeSecoes());
	}

	@Test
	public void cadastraTresSecoesNaZona101() throws Exception {
		cartorio.cadastraSecaoEleitoral(101);
		cartorio.cadastraSecaoEleitoral(101);
		cartorio.cadastraSecaoEleitoral(101);
		assertEquals(3, cartorio.numeroDeSecoes());
	}

	@Test
	public void cadastraTresSecoesEmTresZonas() throws Exception {
		cartorio.cadastraSecaoEleitoral(101);
		cartorio.cadastraSecaoEleitoral(101);
		cartorio.cadastraSecaoEleitoral(101);
		cartorio.cadastraSecaoEleitoral(102);
		cartorio.cadastraSecaoEleitoral(102);
		cartorio.cadastraSecaoEleitoral(102);
		cartorio.cadastraSecaoEleitoral(103);
		cartorio.cadastraSecaoEleitoral(103);
		cartorio.cadastraSecaoEleitoral(103);
		assertEquals(9, cartorio.numeroDeSecoes());
	}

	@Test
	public void atribuiEleitorASecao() throws Exception {
		cartorio.cadastraSecaoEleitoral(101);
		cartorio.cadastrarEleitor("Jorge", 123, 123);
		cartorio.setSecaoDoEleitor(123, 1);

		Secao secao = cartorio.getSecao(1);
		Eleitor eleitor = cartorio.getEleitor(123);

		assertEquals(true, secao.verificaSeEleitorVotaNestaSecao(eleitor));
	}
}
