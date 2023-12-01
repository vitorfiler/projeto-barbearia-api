package com.barbeariaapi.dominadash;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="param_compilacao")
public class ParametroCompilacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer ordem;
	
	private String chave;
	
	private String valor;
	
	private String tipo;
    
    @ManyToOne
    @JoinColumn(name="compilacao_id", nullable=false)
    private Compilacao compilacao;

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public Compilacao getCompilacao() {
		return compilacao;
	}

	public void setCompilacao(Compilacao compilacao) {
		this.compilacao = compilacao;
	}

	public ParametroCompilacao() {
		super();
	}
}