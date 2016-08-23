package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.FachadaCartorio;
import exceptions.ExceptionMsg;
import model.Eleitor;
import model.Zona;

public class TesteEleitor {

	private FachadaCartorio cartorio;

	@Before
	public void configura() throws Exception {
		cartorio = new FachadaCartorio();
		cartorio.cadastraZona(101, "UFSC");

	}

	@Test
	public void CadastraEleitor() throws ExceptionMsg {
		cartorio.cadastrarEleitor("Carol", 173043550, 113352414);
		assertEquals(1, cartorio.numeroDeEleitores());
	}

	@Test
	public void Cadastra2EleitoresComMesmoTitulo() {
		try {
			cartorio.cadastrarEleitor("Carol", 173043550, 113352414);
			cartorio.cadastrarEleitor("Jorge", 173043550, 256128806);
		} catch (ExceptionMsg e) {
			assertEquals(1, cartorio.numeroDeEleitores());
		}
	}

	@Test
	public void Cadastra2EleitoresComMesmoCPF() {
		try {
			cartorio.cadastrarEleitor("Carol", 173043550, 113352414);
			cartorio.cadastrarEleitor("Jorge", 173043550, 256128806);
		} catch (ExceptionMsg e) {
			assertEquals(1, cartorio.numeroDeEleitores());
		}
	}

	@Test
	public void AtribuiEleitorAZona() throws ExceptionMsg {
		cartorio.cadastrarEleitor("Jorge", 12345, 1234567);
		Eleitor eleitor = cartorio.getEleitor(12345);
		Zona zona = cartorio.getZona(101);
		eleitor.setZona(zona);
		assertEquals(101, eleitor.getNumZona());
	}

	@Test
	public void AtribuiEnderecoAEleitor() throws ExceptionMsg {
		cartorio.cadastrarEleitor("Carol", 173043550, 113352414);
	}
}
