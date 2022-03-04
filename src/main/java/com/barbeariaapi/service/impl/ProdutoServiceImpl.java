package com.barbeariaapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barbeariaapi.exceptions.BadRequestException;
import com.barbeariaapi.model.Produto;
import com.barbeariaapi.repository.ProdutoRepository;
import com.barbeariaapi.service.ProdutoService;
import com.barbeariaapi.utis.CdIdentificadorUtils;

@Component
public class ProdutoServiceImpl implements ProdutoService{

	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<Produto> buscarTodos(Long estabelecimentoId) {
		try {
			return produtoRepository.findAllByEstabelecimentoID(estabelecimentoId);
		} catch (Exception e) {
			throw new BadRequestException("Falha ao buscar Produtos", e);
		}
	}

	@Override
	public Produto buscarPeloId(Long produtoId) {
		try {
			 Optional<Produto> produto = produtoRepository.findById(produtoId);
			 if(produto.isPresent()) {
				 return produto.get();
			 }else {
				 throw new Exception();
			 }
		} catch (Exception e) {
			throw new BadRequestException("Falha ao buscar produto", e);
		}
	}

	public Produto cadastrar(Produto produto) {
		try {
			if(produto.getId() == null && produto.getCodProduto() == null) {	
				produto.setCodProduto(CdIdentificadorUtils.gerarCodigo());
				return produtoRepository.save(produto);
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new BadRequestException("Falha ao cadastrar Produto", e);
		}
	}

	public Produto alterar(Produto produto) {
		try {			
			Optional<Produto> resposta = produtoRepository.findById(produto.getId());
			if(resposta.isPresent()) {
				produto.setCodProduto(resposta.get().getCodProduto());
				return produtoRepository.save(produto);
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new BadRequestException("Falha ao alterar produto "+ e);
		}
	}

	public void deletarPeloId(Long produtoId) {
		try {
			Optional<Produto> produto = produtoRepository.findById(produtoId);
			if(produto.isPresent()) {
				produto.get().setAtivo(false);
				produtoRepository.save(produto.get());
			}
			else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new BadRequestException("Falha ao deletar produto");
		}
	}

	public List<Produto> filtrar() {
		// TODO Auto-generated method stub
		return null;
	}

}
