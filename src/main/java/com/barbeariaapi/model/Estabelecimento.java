package com.barbeariaapi.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private Boolean cadastro_completo;
	
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
	
	@Column(name="foto_s3_aws")
	private String fotoS3Aws;
	
	private String descricao;
	
	@OneToMany(mappedBy="estabelecimento")
    private Set<ArquivoEstabelecimento> arquivos;
	
	public Boolean getCadastro_completo() {
		return cadastro_completo;
	}

	public void setCadastro_completo(Boolean cadastroCompleto) {
		this.cadastro_completo = cadastroCompleto;
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

	public String getFotoS3Aws() {
		return fotoS3Aws;
	}

	public void setFotoS3Aws(String fotoS3Aws) {
		this.fotoS3Aws = fotoS3Aws;
	}

	@JsonIgnore
	public Set<ArquivoEstabelecimento> getArquivos() {
		return arquivos;
	}

	public void setArquivos(Set<ArquivoEstabelecimento> arquivos) {
		this.arquivos = arquivos;
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

	public Estabelecimento(Long id, @Size(min = 3, max = 500) String hashSenha,
			@Size(min = 3, max = 100) String nomeProprietario,
			@Size(min = 3, max = 100) String estabelecimento, @Size(min = 3, max = 100) String email,
			@Size(min = 3, max = 100) String cpf_cnpj, @Size(min = 3, max = 100) String senha,
			Boolean cadastroCompleto, Boolean primeiroLogin, Long enderecoID, Long planoID, Endereco endereco,
			Plano plano, String telefone, String celular, String fotoS3Aws, String descricao,
			Set<ArquivoEstabelecimento> arquivos) {
		super();
		this.id = id;
		this.hashSenha = hashSenha;
		this.nomeProprietario = nomeProprietario;
		this.estabelecimento = estabelecimento;
		this.email = email;
		this.cpf_cnpj = cpf_cnpj;
		this.senha = senha;
		this.cadastro_completo = cadastroCompleto;
		this.primeiroLogin = primeiroLogin;
		this.enderecoID = enderecoID;
		this.planoID = planoID;
		this.endereco = endereco;
		this.plano = plano;
		this.telefone = telefone;
		this.celular = celular;
		this.fotoS3Aws = fotoS3Aws;
		this.descricao = descricao;
		this.arquivos = arquivos;
	}
	
	public Estabelecimento(Estabelecimento estabelecimento) {
		super();
		this.id = estabelecimento.getId();
		this.hashSenha = estabelecimento.getHashSenha();
		this.nomeProprietario = estabelecimento.getNomeProprietario();
		this.estabelecimento = estabelecimento.getEstabelecimento();
		this.email = estabelecimento.getEmail();
		this.cpf_cnpj = estabelecimento.getCpf_cnpj();
		this.senha = estabelecimento.getSenha();
		this.cadastro_completo = estabelecimento.getCadastro_completo();
		this.primeiroLogin = estabelecimento.getPrimeiroLogin();
		this.enderecoID = estabelecimento.getEnderecoID();
		this.planoID = estabelecimento.getPlanoID();
		this.endereco = estabelecimento.getEndereco();
		this.plano = estabelecimento.getPlano();
		this.telefone = estabelecimento.getTelefone();
		this.celular = estabelecimento.getCelular();
		this.fotoS3Aws = estabelecimento.getFotoS3Aws();
		this.descricao = estabelecimento.getDescricao();
		this.arquivos = estabelecimento.getArquivos();
	}
	
}
