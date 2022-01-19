package com.barbeariaapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Cliente")
@Table
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="dtCriacao")
	private Date dtCriacao;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="dtNascimento")
	private Date dtNascimento;
	
	@Column(name="ativo")
	private boolean ativo;
	
	@OneToOne
	@JoinColumn(name="enderecoID", referencedColumnName="id")
	private Endereco endereco;
	
	
}
