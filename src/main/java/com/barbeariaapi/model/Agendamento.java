package com.barbeariaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sun.istack.NotNull;


@Entity(name="agendamento")
@Table
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="cd_solicitacao")
	private String cdAgendamento;
	
	@Column(name="nome_servico")
	private String nomeServico;
	
	@Column(name="nome_cliente")
	private String nomeCliente;
	
	@Column(name="tempo_estimado")
	private Long tempoEstimado;
	
	@Column(name="valor")
	private Double valor;
	
	@Column(name="dt_atendimento")
	private String dtAtendimento;
	
	@Column(name="hr_atendimento")
	private String hrAtendimento;
	
	@Column(name="responsavel")
	private String responsavel;
	
	@Column(name="status")
	private String status;
	
	@NotNull
	@Column(name="cliente_ID")
	private Long clienteID;
	
	@NotNull
	@Column(name="estabelecimento_ID")
	private Long estabelecimentoID;

	@Transient
	private Cliente cliente;
//	
//	@OneToOne
//	@JoinColumn(name="estabelecimentoID", referencedColumnName="id")
//	private Estabelecimento estabelecimento;
	
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

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Long getTempoEstimado() {
		return tempoEstimado;
	}

	public void setTempoEstimado(Long tempoEstimado) {
		this.tempoEstimado = tempoEstimado;
	}

	public String getDtAtendimento() {
		return dtAtendimento;
	}

	public void setDtAtendimento(String dtAtendimento) {
		this.dtAtendimento = dtAtendimento;
	}

	public String getHrAtendimento() {
		return hrAtendimento;
	}

	public void setHrAtendimento(String hrAtendimento) {
		this.hrAtendimento = hrAtendimento;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
//	public Cliente getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(Cliente cliente) {
//		this.cliente = cliente;
//	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Long getClienteID() {
		return clienteID;
	}

	public void setClienteID(Long clienteID) {
		this.clienteID = clienteID;
	}

	public Long getEstabelecimentoID() {
		return estabelecimentoID;
	}

	public void setEstabelecimentoID(Long estabelecimentoID) {
		this.estabelecimentoID = estabelecimentoID;
	}

	public String getCdAgendamento() {
		return cdAgendamento;
	}

	public void setCdAgendamento(String cdAgendamento) {
		this.cdAgendamento = cdAgendamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Agendamento() {
		super();
	}
}
