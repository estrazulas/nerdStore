package br.edu.ifsc.nerdstore.beans;

public class Produto {

	private String id;
	private String nome;
	private String urlImagem;
	private Double preco;
	

	public Produto() {
		this("","","",0d);
	}
	
	public Produto(String id, String nome, String urlImagem, Double preco) {
		this.id = id;
		this.nome = nome;
		this.urlImagem = urlImagem;
		this.preco = preco;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
}
