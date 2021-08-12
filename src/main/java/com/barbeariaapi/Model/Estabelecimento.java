package com.barbeariaapi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Estabelecimento {
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="estabelecimento")
	private String estabelecimento;
	
	@Column(name="email")
	private String email;
	
	@Column(name="cpf_cnpj")
	private String cpf_cnpj;
	
	@Column(name="senha")
	private String senha;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Estabelecimento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estabelecimento(Estabelecimento user) {
		// TODO Auto-generated constructor stub
	}
}
