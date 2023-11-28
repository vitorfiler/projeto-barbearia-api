package com.barbeariaapi.dominadash;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "compilacao")
public class Compilacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String autor;

	private String status;

	private String funcao;

//	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
//	@JoinColumn(name = "compilacao_id")
//	private Set<ParametroCompilacao> parametros;
//	
	@OneToMany(mappedBy="compilacao")
	private Set<ParametroCompilacao> parametros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Set<ParametroCompilacao> getParametros() {
		return parametros;
	}

	public void setParametros(Set<ParametroCompilacao> parametros) {
		this.parametros = parametros;
	}
}