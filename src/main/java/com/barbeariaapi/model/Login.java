package com.barbeariaapi.model;

public class Login {
	
	private Long estabelecimento_ID;
	private String estabelecimento;
	private String email;
	private String nomeProprietario;
	private String token;
	private Boolean cadastroCompleto;
	
	public Long getEstabelecimento_ID() {
		return estabelecimento_ID;
	}
	public void setEstabelecimento_ID(Long estabelecimento_ID) {
		this.estabelecimento_ID = estabelecimento_ID;
	}
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
	
	public Boolean getCadastroCompleto() {
		return cadastroCompleto;
	}
	public void setCadastroCompleto(Boolean cadastroCompleto) {
		this.cadastroCompleto = cadastroCompleto;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
}
