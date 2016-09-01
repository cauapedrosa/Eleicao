package testes;

import org.junit.Before;
import org.junit.Test;

import modelo.Eleitor;
import modelo.FachadaCartorioEleitoral;
import modelo.Urna;

public class TesteEleicoes {
	private FachadaCartorioEleitoral cartorio;

	@Before
	public void configura() throws Exception {
		cartorio = new FachadaCartorioEleitoral();

		cartorio.cadastrarEleitor("Jorge1", 1001, 10002);
		cartorio.cadastrarEleitor("Jorge2", 1002, 10002);
		cartorio.cadastrarEleitor("Jorge3", 1003, 10003);
		cartorio.cadastrarEleitor("Jorge4", 1004, 10004);
		cartorio.cadastrarEleitor("Jorge5", 1005, 10005);
		cartorio.cadastrarEleitor("Jorge6", 1006, 10006);
		cartorio.cadastrarEleitor("Jorge7", 1007, 10007);
		cartorio.cadastrarEleitor("Jorge8", 1008, 10008);
		cartorio.cadastrarEleitor("Jorge9", 1009, 10009);

		cartorio.cadastrarPartido("Partido Um", "P1", 01);
		cartorio.cadastrarPartido("Partido Dois", "P2", 02);

		cartorio.cadastrarCandidatoPrefeito(1001, "Jorge1", 01);
		cartorio.cadastrarCandidatoPrefeito(1002, "Jorge2", 02);

		cartorio.cadastrarCandidatoVereador(1003, "Jorge3", 01, 1001);
		cartorio.cadastrarCandidatoVereador(1004, "Jorge4", 02, 1002);

		cartorio.cadastraZonaEleitoral(101, "UFSC");
		cartorio.cadastraSecaoEleitoral(101);

		for (int i = 0; i < cartorio.eleitores.size(); i++) {
			Eleitor eleitor = cartorio.eleitores.get(i);
			cartorio.setZonaDoEleitor(eleitor.getCpf(), 101);
		}
	}

	@Test
	public void test() throws Exception {
		Urna urna = cartorio.secoes.get(0).getUrna();

		// System.out.println("Secoes: " + cartorio.secoes.size());
		// System.out.println("Eleitores: " + cartorio.eleitores.size());
		// System.out.println("Candidatos: " + cartorio.candidatos.size());

		for (int cont = 0; cont <= 6; cont++) {
			Eleitor eleitor = cartorio.eleitores.get(cont);
			cartorio.vota(urna, eleitor, 01, 1001);
		}
		for (int cont = 7; cont <= 8; cont++) {
			Eleitor eleitor = cartorio.eleitores.get(cont);
			cartorio.vota(urna, eleitor, 02, 1002);
		}

		// System.out.println("Cand 1: " + cartorio.contaVotosPrefeito(urna, 01));
		// System.out.println("Cand 2: " + cartorio.contaVotosPrefeito(urna, 02));

		assert (cartorio.contaVotosPrefeito(urna, 01) > cartorio.contaVotosPrefeito(urna, 02));
	}

}
