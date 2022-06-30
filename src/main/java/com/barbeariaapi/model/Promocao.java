package com.barbeariaapi.model;

import java.util.List;

public class Promocao {

	List<Servico> servicos;
	List<Produto> produtos;
	
	/**
	 * @return the servicos
	 */
	public List<Servico> getServicos() {
		return servicos;
	}
	
	/**
	 * @param servicos the servicos to set
	 */
	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
	/**
	 * @return the produtos
	 */
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	/**
	 * @param produtos the produtos to set
	 */
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public Promocao() {
		super();
	}
}
