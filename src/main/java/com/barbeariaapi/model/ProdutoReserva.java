package com.barbeariaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="produto_reserva")
public class ProdutoReserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="reserva_ID")
	private Long reservaID;
	
	@Column(name="produto_ID")
	private Long produtoID;
	
	@Column(name="qtd")
	private Integer qtd;
	
	@Column(name="estabelecimento_ID")
	private Long estabelecimentoID;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getReservaID() {
		return reservaID;
	}

	public void setReservaID(Long reservaID) {
		this.reservaID = reservaID;
	}

	public Long getProdutoID() {
		return produtoID;
	}

	public void setProdutoID(Long produtoID) {
		this.produtoID = produtoID;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Long getEstabelecimentoID() {
		return estabelecimentoID;
	}

	public void setEstabelecimentoID(Long estabelecimentoID) {
		this.estabelecimentoID = estabelecimentoID;
	}

	public ProdutoReserva() {
		super();
	}

	public ProdutoReserva(Long reservaID, Long produtoID, Integer qtd, Long estabelecimentoID) {
		super();
		this.reservaID = reservaID;
		this.produtoID = produtoID;
		this.qtd = qtd;
		this.estabelecimentoID = estabelecimentoID;
	}
	
	public ProdutoReserva(Long id, Long reservaID, Long produtoID, Integer qtd, Long estabelecimentoID) {
		super();
		this.id = id;
		this.reservaID = reservaID;
		this.produtoID = produtoID;
		this.qtd = qtd;
		this.estabelecimentoID = estabelecimentoID;
	}

	
}
