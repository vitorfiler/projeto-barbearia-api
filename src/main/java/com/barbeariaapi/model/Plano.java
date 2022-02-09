package com.barbeariaapi.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="plano")
public class Plano {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="nome")
	private String nome;
	
	@Column(name="preco")
	private String preco;
	
	@Column(name="ds_plano")
	private String dsPlano;
	
	@Column(name="desconto")
	private String desconto;
	
	@OneToMany(mappedBy="plano")
    private Set<Beneficio> beneficios;
	
//	@Transient
//	private List<Beneficio> beneficios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getDsPlano() {
		return dsPlano;
	}

	public void setDsPlano(String dsPlano) {
		this.dsPlano = dsPlano;
	}

	public String getDesconto() {
		return desconto;
	}

	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}

	public Set<Beneficio> getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(Set<Beneficio> beneficios) {
		this.beneficios = beneficios;
	}

	public Plano() {
		super();
		// TODO Auto-generated constructor stub
	}
}