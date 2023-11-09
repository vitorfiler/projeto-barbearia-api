package com.barbeariaapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="beneficio")
public class Beneficio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	@Column(name="cod_beneficio")
	private String codBeneficio;
	
	@Column(name="ds_beneficio")
	private String dsBeneficio;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="dt_criacao")
	private Date dtCriacao;
	
	@Column(name="dt_ultima_atualizacao")
	private Date dtUltimaAtualizacao;

    @ManyToOne
    @JoinColumn(name="plano_id", nullable=false)
    private Plano plano;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodBeneficio() {
		return codBeneficio;
	}

	public void setCodBeneficio(String codBeneficio) {
		this.codBeneficio = codBeneficio;
	}

	public String getDsBeneficio() {
		return dsBeneficio;
	}

	public void setDsBeneficio(String dsBeneficio) {
		this.dsBeneficio = dsBeneficio;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public Date getDtUltimaAtualizacao() {
		return dtUltimaAtualizacao;
	}

	public void setDtUltimaAtualizacao(Date dtUltimaAtualizacao) {
		this.dtUltimaAtualizacao = dtUltimaAtualizacao;
	}
	
	@JsonIgnore
	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public Beneficio() {
		super();
	}
	
}