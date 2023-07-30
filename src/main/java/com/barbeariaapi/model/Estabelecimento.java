package com.barbeariaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Entity(name="estabelecimento")
public class Estabelecimento {
	
	public Estabelecimento(int i, String string, String string2, String string3, String string4, String string5,
			String string6, boolean b, int j, int k) {
		// TODO Auto-generated constructor stub
	}

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

	@Column(name="endereco_ID")
	private Long enderecoID;
	
	@Lob
	@Column(name="imagem_capa")
	private byte[] imagemCapa;
	
	@Lob
	@Column(name="imagem_perfil")
	private byte[] imagemPerfil;
	
	@Column(name="plano_ID")
	private Long planoID;
	
	@Transient
	private Endereco endereco;
	
	@Transient
	private Plano plano;
	
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

	
	public Estabelecimento() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
