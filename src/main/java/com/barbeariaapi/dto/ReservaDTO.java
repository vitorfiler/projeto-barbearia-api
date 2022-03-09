package com.barbeariaapi.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

import com.barbeariaapi.model.Produto;
import com.barbeariaapi.model.Reserva;

public class ReservaDTO {

	private Long id;
	
	private Date dtAbertura;
	
	private Date dtFinalizacao;
	
	private String codVendedor;
	
	private String codReserva;
	
	private String statusReserva;
	
	private Integer valorTotalReserva;
	
	private String motivoCancelamento;
	
	private Boolean solicitaCancelamento;
	
	private Long estabelecimentoID;

	private Long clienteID;
	
	@Transient
	private List<Produto> produtos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(Date dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public Date getDtFinalizacao() {
		return dtFinalizacao;
	}

	public void setDtFinalizacao(Date dtFinalizacao) {
		this.dtFinalizacao = dtFinalizacao;
	}

	public String getCodVendedor() {
		return codVendedor;
	}

	public void setCodVendedor(String codVendedor) {
		this.codVendedor = codVendedor;
	}

	public String getCodReserva() {
		return codReserva;
	}

	public void setCodReserva(String codReserva) {
		this.codReserva = codReserva;
	}

	public String getStatusReserva() {
		return statusReserva;
	}

	public void setStatusReserva(String statusReserva) {
		this.statusReserva = statusReserva;
	}

	public Integer getValorTotalReserva() {
		return valorTotalReserva;
	}

	public void setValorTotalReserva(Integer valorTotalReserva) {
		this.valorTotalReserva = valorTotalReserva;
	}

	public String getMotivoCancelamento() {
		return motivoCancelamento;
	}

	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}

	public Boolean getSolicitaCancelamento() {
		return solicitaCancelamento;
	}

	public void setSolicitaCancelamento(Boolean solicitaCancelamento) {
		this.solicitaCancelamento = solicitaCancelamento;
	}

	public Long getEstabelecimentoID() {
		return estabelecimentoID;
	}

	public void setEstabelecimentoID(Long estabelecimentoID) {
		this.estabelecimentoID = estabelecimentoID;
	}

	public Long getClienteID() {
		return clienteID;
	}

	public void setClienteID(Long clienteID) {
		this.clienteID = clienteID;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public ReservaDTO() {
		super();
	}

	public ReservaDTO(Reserva reserva, List<Produto> produtos) {
		super();
		this.id = reserva.getId();
		this.dtAbertura = reserva.getDtAbertura();
		this.dtFinalizacao = reserva.getDtFinalizacao();
		this.codVendedor = reserva.getCodVendedor();
		this.statusReserva = reserva.getStatusReserva();
		this.valorTotalReserva = reserva.getValorTotalReserva();
		this.motivoCancelamento = reserva.getMotivoCancelamento();
		this.codReserva = reserva.getCodReserva();
		this.solicitaCancelamento = reserva.getSolicitaCancelamento();
		this.estabelecimentoID = reserva.getEstabelecimentoID();
		this.clienteID = reserva.getClienteID();
		this.produtos = produtos;
	}

	
}
