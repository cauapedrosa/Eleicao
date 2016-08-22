package model;

public class Eleitor {

	private String nome;
	private int cpf;
	private int titulo;
	private Zona zona;
	private Secao secao;
	private String endereco;
	private String municipio;

	public Eleitor(String nome, int cpf, int titulo) {
		this.nome = nome;
		this.cpf = cpf;
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return String.format(
				"Nome: %s\n CPF: %d\n Titulo: %d\n Zona: %d\n Secao %d\n Endereco: %s\n Municipio %s",
				nome, cpf, titulo, zona.toString(), secao, endereco, municipio);
	}

	public void setZona(Zona zona) {
		this.zona = zona;
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

	public float getCpf() {
		return cpf;
	}

	public float getTitulo() {
		return titulo;
	}

	public int getNumZona() {
		return zona.getNumero();
	}

	public Zona getZona() {
		return zona;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eleitor other = (Eleitor) obj;
		if (titulo != other.titulo)
			return false;
		return true;
	}

}
