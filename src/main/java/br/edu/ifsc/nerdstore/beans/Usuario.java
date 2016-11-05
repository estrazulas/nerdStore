package br.edu.ifsc.nerdstore.beans;

public class Usuario {

	private String email;
	private String senha;

	public Usuario(){
		this("","");
	}
	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public String getEmail() {
		return email;
	}
}
