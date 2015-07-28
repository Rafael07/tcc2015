package br.com.teste.entidades;

public class UnidadeBasica {

	private String nome;
	private String rua;
	private String bairro;
	private String cidade;
	private long cnpj;
	private int cnesUnidade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public long getCnpj() {
		return cnpj;
	}
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	public int getCnesUnidade() {
		return cnesUnidade;
	}
	public void setCnesUnidade(int cnesUnidade) {
		this.cnesUnidade = cnesUnidade;
	}
	
	
}
