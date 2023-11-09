package com.barbeariaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.barbeariaapi.model.base.BaseEntity;
@Entity(name= "arquivo_servico")
public class ArquivoServico extends BaseEntity {
	
	private String nome;
	
	@Column(name="path_s3")
	private String pathS3;
	
	private String tipo;
	
	@Column(name="dt_inclusao")
	private String dtInclusao;
	
	@Column(name="usuario_inclusao")
	private String usuarioInclusao;
	
	@ManyToOne
    @JoinColumn(name="servico_id", nullable=false)
    private Servico servico;
	
	public ArquivoServico() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPathS3() {
		return pathS3;
	}

	public void setPathS3(String pathS3) {
		this.pathS3 = pathS3;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDtInclusao() {
		return dtInclusao;
	}

	public void setDtInclusao(String dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	public String getUsuarioInclusao() {
		return usuarioInclusao;
	}

	public void setUsuarioInclusao(String usuarioInclusao) {
		this.usuarioInclusao = usuarioInclusao;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
}

