package com.barbeariaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity(name="Produto")
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

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
