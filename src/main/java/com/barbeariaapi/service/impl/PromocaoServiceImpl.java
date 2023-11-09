package com.barbeariaapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barbeariaapi.model.Promocao;
import com.barbeariaapi.repository.ProdutoRepository;
import com.barbeariaapi.repository.ServicoRepository;
import com.barbeariaapi.service.PromocaoService;

@Component
public class PromocaoServiceImpl implements PromocaoService{

	@Autowired
	ServicoRepository servicoRepoitory;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	
	public Promocao obterPromocao(Long estabelecimentoID) {
		Promocao promocao = new Promocao();
		promocao.setProdutos(produtoRepository.buscarProdutosPromocionais(estabelecimentoID));
		promocao.setServicos(servicoRepoitory.buscarServicosPromocionais(estabelecimentoID));
		return promocao;
	}
}
