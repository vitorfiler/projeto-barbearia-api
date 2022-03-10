package com.barbeariaapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.barbeariaapi.dto.ReservaDTO;
import com.sun.istack.NotNull;

@Entity(name="Reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="dt_abertura")
	private Date dtAbertura;
	
	@Column(name="dt_finalizacao")
	private Date dtFinalizacao;
	
	@Column(name="cod_vendedor")
	private String codVendedor;
	
	@Column(name="cod_reserva")
	private String codReserva;
	
	@Column(name="status_reserva")
	private String statusReserva;
	
	@Column(name="valor_total_reserva")
	private Integer valorTotalReserva;
	
	@Column(name="motivo_cancelamento")
	private String motivoCancelamento;
	
	@Column(name="solicita_cancelamento")
	private Boolean solicitaCancelamento;

	@NotNull
	@Column(name="estabelecimento_ID")
	private Long estabelecimentoID;
	
	@NotNull
	@Column(name="cliente_ID")
	private Long clienteID;
	
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

	public Reserva() {
		super();
	}

	public Reserva(ReservaDTO reservaDTO) {
		super();
		this.id = reservaDTO.getId();
		this.dtAbertura = reservaDTO.getDtAbertura();
		this.dtFinalizacao = reservaDTO.getDtFinalizacao();
		this.codVendedor = reservaDTO.getCodVendedor();
		this.statusReserva = reservaDTO.getStatusReserva();
		this.valorTotalReserva = reservaDTO.getValorTotalReserva();
		this.motivoCancelamento = reservaDTO.getMotivoCancelamento();	
		this.codReserva = reservaDTO.getCodReserva();
		this.solicitaCancelamento = reservaDTO.getSolicitaCancelamento();
		this.estabelecimentoID = reservaDTO.getEstabelecimentoID();
		this.clienteID = reservaDTO.getClienteID();
	}
	
}
