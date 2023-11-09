package com.barbeariaapi.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity(name="produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="qtd_estoque")
	private Integer qtdEstoque;
	
	@Column(name="valor")
	private String valor;
	
	@Column(name="valor_promocional")
	private String valorPromocional;
	
	@Column(name="ativo")
	private Boolean ativo;
	
	@Column(name="promocional")
	private Boolean promocional;

	@NotNull
	@Column(name="estabelecimento_ID")
	private Long estabelecimentoID;

	@OneToMany(mappedBy="produto")
    private Set<ArquivoProduto> arquivos;
	
	@Column(name="foto_s3_aws")
	private String fotoS3Aws;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getValorPromocional() {
		return valorPromocional;
	}

	public void setValorPromocional(String valorPromocional) {
		this.valorPromocional = valorPromocional;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Boolean getPromocional() {
		return promocional;
	}

	public void setPromocional(Boolean promocional) {
		this.promocional = promocional;
	}

	public Long getEstabelecimentoID() {
		return estabelecimentoID;
	}

	public void setEstabelecimentoID(Long estabelecimentoID) {
		this.estabelecimentoID = estabelecimentoID;
	}
	
	@JsonIgnore
	public Set<ArquivoProduto> getArquivos() {
		return arquivos;
	}

	public void setArquivos(Set<ArquivoProduto> arquivos) {
		this.arquivos = arquivos;
	}

	public String getFotoS3Aws() {
		return fotoS3Aws;
	}

	public void setFotoS3Aws(String fotoS3Aws) {
		this.fotoS3Aws = fotoS3Aws;
	}

	public Produto() {
		super();
	}

}
