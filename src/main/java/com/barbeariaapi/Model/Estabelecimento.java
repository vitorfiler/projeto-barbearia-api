package com.barbeariaapi.Model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="Estabelecimento")
public class Estabelecimento {
	
	@Column(name="nome")
	private String nomeProprietario;
	
	@Column(name="estabelecimento")
	private String estabelecimento;
	
	@Column(name="email")
	private String email;
	
	@Column(name="CPF_CNPJ")
	private String cpf_cnpj;
	
	@Column(name="senha")
	private String senha;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nome) {
		this.nomeProprietario = nome;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Estabelecimento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estabelecimento(String string, String string2, ArrayList arrayList) {
		// TODO Auto-generated constructor stub
	}
}
