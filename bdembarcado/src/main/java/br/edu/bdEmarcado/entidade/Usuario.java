package br.edu.bdEmarcado.entidade;

public class Usuario {

	/*
	  	Neste código, eu criei o objeto Usuário. Ele tem os atributos id, nome,
	  	email e senha.
	  	
	  	Logo abaixo da declaração dos atributos, fazemos os Getters and Setters correspondentes.
	 */

	private int id;
	private String nome;
	private String email;
	private String senha;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
