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
	
	@Column(name="cod_produto")
	private String codProduto;
	
	@Column(name="nome_produto")
	private String nomeProduto;
	
	@Column(name="ds_produto")
	private String dsProduto;
	
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

	public String getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDsProduto() {
		return dsProduto;
	}

	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
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
