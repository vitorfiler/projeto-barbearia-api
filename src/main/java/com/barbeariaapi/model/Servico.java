package com.barbeariaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity(name="Servico")
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome_servico")
	private String nomeServico;
	
	@Column(name="categoria")
	private String categoria;
	
	@Column(name="cd_Servico")
	private String cdServico;
	
	@Column(name="descricao")
	private String dsServico;
	
	@Column(name="tempo_Estimado")
	private String tempoEstimado;
	
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

	
	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCdServico() {
		return cdServico;
	}

	public void setCdServico(String cdServico) {
		this.cdServico = cdServico;
	}

	public String getDsServico() {
		return dsServico;
	}

	public void setDsServico(String dsServico) {
		this.dsServico = dsServico;
	}

	public String getTempoEstimado() {
		return tempoEstimado;
	}

	public void setTempoEstimado(String tempoEstimado) {
		this.tempoEstimado = tempoEstimado;
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

	public Servico() {
		super();
	}
}
