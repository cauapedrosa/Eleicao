package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modelo.Eleitor;
import modelo.FachadaCartorioEleitoral;
import modelo.ZonaEleitoral;

public class TesteEleitor {

	private FachadaCartorioEleitoral cartorio;

	@Before
	public void configura() throws Exception {
		cartorio = new FachadaCartorioEleitoral();
		cartorio.cadastraZonaEleitoral(101, "UFSC");

	}

	@Test
	public void CadastraEleitor() throws Exception {
		cartorio.cadastrarEleitor("Carol", 173043550, 113352414);
		assertEquals(1, cartorio.numeroDeEleitores());
	}

	@Test
	public void Cadastra2EleitoresComMesmoTitulo() {
		try {
			cartorio.cadastrarEleitor("Carol", 173043550, 113352414);
			cartorio.cadastrarEleitor("Jorge", 173043550, 256128806);
		} catch (Exception e) {
			assertEquals(1, cartorio.numeroDeEleitores());
		}
	}

	@Test
	public void Cadastra2EleitoresComMesmoCPF() {
		try {
			cartorio.cadastrarEleitor("Carol", 173043550, 113352414);
			cartorio.cadastrarEleitor("Jorge", 173043550, 256128806);
		} catch (Exception e) {
			assertEquals(1, cartorio.numeroDeEleitores());
		}
	}

	@Test
	public void AtribuiEleitorAZona() throws Exception {
		cartorio.cadastrarEleitor("Jorge", 12345, 1234567);
		Eleitor eleitor = cartorio.getEleitor(12345);
		ZonaEleitoral zona = cartorio.getZona(101);
		eleitor.setZona(zona);
		assertEquals(101, eleitor.getNumZona());
	}

	@Test
	public void AtribuiEnderecoAEleitor() throws Exception {
		cartorio.cadastrarEleitor("Carol", 173043550, 113352414);
	}
}
