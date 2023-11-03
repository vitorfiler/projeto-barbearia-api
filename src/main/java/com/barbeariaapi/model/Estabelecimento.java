package com.barbeariaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="estabelecimento")
public class Estabelecimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="hash_senha")
	@Size(min = 3, max = 500)
	private String hashSenha;
	
	@Column(name="nome")
	@NotNull
	@Size(min = 3, max = 100)
	private String nomeProprietario;
	
	@Column(name="estabelecimento")
	@NotNull
	@Size(min = 3, max = 100)
	private String estabelecimento;
	
	@Column(name="email")
	@NotNull
	@Size(min = 3, max = 100)
	private String email;
	
	@Column(name="CPF_CNPJ")
	@NotNull
	@Size(min = 3, max = 100)
	private String cpf_cnpj;
	
	@Column(name="senha")
	@NotNull
	@Size(min = 3, max = 100)
//	@JsonIgnore
	private String senha;
	
	@Column(name="cadastro_completo")
	@NotNull
	private Boolean cadastroCompleto;
	
	@Column(name="primeiro_login")
	private Boolean primeiroLogin = true;

	@Column(name="endereco_ID")
	private Long enderecoID;
	
	@Column(name="plano_ID")
	private Long planoID;
	
	@Transient
	private Endereco endereco;
	
	@Transient
	private Plano plano;
	
	private String telefone;
	
	private String celular;
	
	private String descricao;
	
	public Boolean getCadastroCompleto() {
		return cadastroCompleto;
	}

	public void setCadastroCompleto(Boolean cadastroCompleto) {
		this.cadastroCompleto = cadastroCompleto;
	}

	public String getHashSenha() {
		return hashSenha;
	}

	public void setHashSenha(String hashSenha) {
		this.hashSenha = hashSenha;
	}

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
	
	public Long getEnderecoID() {
		return enderecoID;
	}

	public void setEnderecoID(Long enderecoID) {
		this.enderecoID = enderecoID;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public Long getPlanoID() {
		return planoID;
	}

	public void setPlanoID(Long planoID) {
		this.planoID = planoID;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Boolean getPrimeiroLogin() {
		return primeiroLogin;
	}

	public void setPrimeiroLogin(Boolean primeiroLogin) {
		this.primeiroLogin = primeiroLogin;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Estabelecimento() {
		super();
		// TODO Auto-generated constructor stub
	}
}
