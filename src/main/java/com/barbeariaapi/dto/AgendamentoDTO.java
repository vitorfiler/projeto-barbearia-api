package com.barbeariaapi.dto;

public class AgendamentoDTO {

	private Long id;
	private String nomeCliente;
	private String nomeServico;
	private String tempoEstimado;
	private Double valor;
	private String dtAtendimento;
	private String hrAtendimento;
	private String responsavel;
	private String status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getNomeServico() {
		return nomeServico;
	}
	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	public String getTempoEstimado() {
		return tempoEstimado;
	}
	public void setTempoEstimado(String tempoEstimado) {
		this.tempoEstimado = tempoEstimado;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
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
	public AgendamentoDTO(Long id, String nomeCliente, String nomeServico, String tempoEstimado, Double valor,
			String dtAtendimento, String hrAtendimento, String responsavel, String status) {
		super();
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.nomeServico = nomeServico;
		this.tempoEstimado = tempoEstimado;
		this.valor = valor;
		this.dtAtendimento = dtAtendimento;
		this.hrAtendimento = hrAtendimento;
		this.responsavel = responsavel;
		this.status = status;
	}
	public AgendamentoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AgendamentoDTO(String nomeCliente, String nomeServico, String tempoEstimado, Double valor,
			String dtAtendimento, String hrAtendimento, String responsavel, String status) {
		super();
		this.nomeCliente = nomeCliente;
		this.nomeServico = nomeServico;
		this.tempoEstimado = tempoEstimado;
		this.valor = valor;
		this.dtAtendimento = dtAtendimento;
		this.hrAtendimento = hrAtendimento;
		this.responsavel = responsavel;
		this.status = status;
	}
	
}
