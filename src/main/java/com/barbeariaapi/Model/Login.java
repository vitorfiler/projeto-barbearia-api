package com.barbeariaapi.Model;

public class Login {
	
	private String estabelecimento;
	private String token;
	private String email;
	private String nomeProprietario;
	
	public String getNomeProprietario() {
		return nomeProprietario;
	}
	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(String nomeUsuario) {
		this.estabelecimento = nomeUsuario;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
