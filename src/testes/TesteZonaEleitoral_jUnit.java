package testes;

import java.util.List;

import interfaces.CartorioEleitoral;
import interfaces.ISecao;
import interfaces.IZonaEleitoral;

import org.junit.*;

import static org.junit.Assert.*;

import modelo.FachadaCartorioEleitoral;

public class TesteZonaEleitoral_jUnit {

	private CartorioEleitoral cartorio;

	@Before
	public void configurar() {
		cartorio = new FachadaCartorioEleitoral();
	}

	@Test
	public void cadastraZona101DuasVezes() throws Exception {
		try {
			cartorio.cadastraZonaEleitoral(101, "Estreito");
			assertEquals(1, cartorio.numeroDeZonasEleitorais());
			cartorio.cadastraZonaEleitoral(101, "Estreito");
			fail();
		} catch (Exception excecao) {
			assertEquals(1, cartorio.numeroDeZonasEleitorais());
		}
	}

	@Test
	public void cadastraZona101e102() throws Exception {
		cartorio.cadastraZonaEleitoral(101, "Estreito");
		cartorio.cadastraZonaEleitoral(102, "Centro");
		assertEquals(2, cartorio.numeroDeZonasEleitorais());
		IZonaEleitoral zona = cartorio.getZona(101);
		assertEquals(101, zona.getNumero());
		IZonaEleitoral zona102 = cartorio.getZona(102);
		assertEquals(102, zona102.getNumero());
	}

	@Test
	public void cadastraZona101eDuasSecoes() throws Exception {
		cartorio.cadastraZonaEleitoral(101, "Estreito");
		assertEquals(1, cartorio.numeroDeZonasEleitorais());
		IZonaEleitoral zona = cartorio.getZona(101);
		assertEquals(101, zona.getNumero());
		cartorio.cadastraSecaoEleitoral(101);
		cartorio.cadastraSecaoEleitoral(101);
		int numeroSecoes = cartorio.numeroDeSecoesDeUmaZona(101);
		assertEquals(2, numeroSecoes);
		List<? extends ISecao> secoes = cartorio.getSecoesDeUmaZona(101);
		assertEquals(1, secoes.get(0).getNumero());
		assertEquals(2, secoes.get(1).getNumero());
	}

}
