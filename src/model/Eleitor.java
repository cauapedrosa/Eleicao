package model;

public class Eleitor {

	private String nome;
	private int cpf;
	private int titulo;
	private Secao secao;
	private String endereco;
	private String municipio;

	public Eleitor(String nome, int cpf, int titulo) {
		this.nome = nome;
		this.cpf = cpf;
		this.titulo = titulo;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getNome() {
		return nome;
	}

	public int getCpf() {
		return cpf;
	}

	public int getTitulo() {
		return titulo;
	}

	public Secao getSecao() {
		return secao;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getMunicipio() {
		return municipio;
	}
}
