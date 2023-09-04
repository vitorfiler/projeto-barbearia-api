package com.barbeariaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barbeariaapi.model.Promocao;
import com.barbeariaapi.repository.ProdutoRepository;
import com.barbeariaapi.repository.ServicoRepoitory;
import com.barbeariaapi.service.PromocaoService;

@Component
public class PromocaoService {

	@Autowired
	ServicoRepoitory servicoRepoitory;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	
	public Promocao obterPromocao(Long estabelecimentoID) {
		Promocao promocao = new Promocao();
		promocao.setProdutos(produtoRepository.buscarProdutosPromocionais(estabelecimentoID));
		promocao.setServicos(servicoRepoitory.buscarServicosPromocionais(estabelecimentoID));
		return promocao;
	}
}
