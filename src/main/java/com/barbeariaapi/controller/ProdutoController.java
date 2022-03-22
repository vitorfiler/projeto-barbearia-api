package com.barbeariaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.barbeariaapi.model.Produto;
import com.barbeariaapi.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	
	@GetMapping("/todos")
	public List<Produto> buscarTodos(@RequestParam(name="estabelecimento_ID") Long estabelecimentoId){
		return produtoService.buscarTodos(estabelecimentoId);
	}
	
	@GetMapping
	public Produto buscarPeloId(@RequestParam(name="produto_ID") Long produtoId){
		return produtoService.buscarPeloId(produtoId);
	}
	
	@PostMapping
	public Produto cadastrar(@RequestBody Produto produto){
		return produtoService.cadastrar(produto);
	}
	
	@PutMapping
	public Produto alterar(@RequestBody Produto produto){
		return produtoService.alterar(produto);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarPeloId(@RequestParam(name="produto_ID") Long id){
		produtoService.deletarPeloId(id);
	}
	
	@GetMapping("/filtro")
	@ResponseStatus(HttpStatus.OK)
	public List<Produto> filtrar(@RequestParam(name="estabelecimento_ID") Long estabelecimentoID,
			@RequestParam(name="filtro") String filtroReserva,
			@RequestParam(name="categoria") String categoria){
		return produtoService.filtrar();
	}
	
}
