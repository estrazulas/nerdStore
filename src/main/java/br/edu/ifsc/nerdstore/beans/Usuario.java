package br.edu.ifsc.nerdstore.beans;

import br.edu.ifsc.nerdstore.util.Util;

public class Usuario {

	private String id;
	private String email;
	private String senha;

	public Usuario(){
		this("","");
	}

	public Usuario(String email, String senha) {
		this.id = Util.geraUID();
		this.email = email;
		this.senha = senha;
	}
	public String getSenha() {
		return senha;
	}

	public String getEmail() {
		return email;
	}
	public String getId() {
		return id;
	}
	
}
