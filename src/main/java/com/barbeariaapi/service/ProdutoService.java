package com.barbeariaapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.barbeariaapi.model.Produto;

@Service
public interface ProdutoService {

	public List<Produto> buscarTodos(Long estabelecimentoId);
	
	public Produto buscarPeloId(Long produtoId);
	
	public Produto cadastrar(Produto produto);
	
	public Produto alterar(Produto produto);
	
	public void deletarPeloId(Long produtoId);
	
	public List<Produto> filtrar();
}
