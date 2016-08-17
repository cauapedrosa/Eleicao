package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controller.FachadaCartorio;
import exceptions.ExceptionJaCadastrado;
import model.Eleitor;
import model.Zona;

public class TesteEleitor {

	private FachadaCartorio cartorio;
	private ArrayList<Eleitor> eleitores;

	@Before
	public void configura() {
		cartorio = new FachadaCartorio();
		eleitores = new ArrayList<Eleitor>();
	}

	@Test
	public void CadastraEleitor() throws ExceptionJaCadastrado {
		cartorio.cadastrarEleitor("Carol", 173043550, 113352414);
		assertEquals(1, cartorio.numeroDeEleitores());
	}

	@Test
	public void Cadastra2EleitoresComMesmoTitulo() {
		try {
			cartorio.cadastrarEleitor("Carol", 173043550, 113352414);
			cartorio.cadastrarEleitor("Jorge", 173043550, 256128806);
		} catch (ExceptionJaCadastrado e) {
			assertEquals(1, cartorio.numeroDeEleitores());
		}
	}

	@Test
	public void Cadastra2EleitoresComMesmoCPF() {
		try {
			cartorio.cadastrarEleitor("Carol", 173043550, 113352414);
			cartorio.cadastrarEleitor("Jorge", 173043550, 256128806);
		} catch (ExceptionJaCadastrado e) {
			assertEquals(1, cartorio.numeroDeEleitores());
		}
	}

	@Test
	public void AtribuiEleitorAZona() throws ExceptionJaCadastrado {
		cartorio.cadastrarEleitor("Carol", 173043550, 113352414);
		Eleitor eleitor = cartorio.getEleitor(113352414);
		cartorio.cadastraZona(101, "UFSC");
		Zona zona = cartorio.getZona(101);
		cartorio.atribuirEleitorAZona(eleitor, zona);
		assertEquals(101, eleitor.getNumZona());
	}

	@Test
	public void AtribuiEnderecoAEleitor() throws ExceptionJaCadastrado {
		cartorio.cadastrarEleitor("Carol", 173043550, 113352414);
	}
}
