package com.barbeariaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbeariaapi.model.Servico;
import com.barbeariaapi.service.ServiceModelo;

@RestController
@RequestMapping("/endpont")
public class ModeloController {

	@Autowired
	ServiceModelo serviceModelo;
	
	@GetMapping("/todos")
	public List<Servico> buscarTodos(Long estabelecimentoId){
		return serviceModelo.buscarTodos(estabelecimentoId);
	}
	
	@GetMapping
	public Servico buscarPeloId(Long estabelecimentoID, Long servicoId){
		return serviceModelo.buscarPeloId(estabelecimentoID, servicoId);
	}
	
	@PostMapping
	public Servico cadastrar(Servico servico){
		return serviceModelo.cadastrar(servico);
	}
	
	@PutMapping
	public Servico alterar(Servico servico){
		return serviceModelo.alterar(servico);
	}
	
	@DeleteMapping
	public void deletarPeloId(Long id){
		serviceModelo.deletarPeloId(id);
	}
	
	@GetMapping("/filtro")
	public List<Servico> filtrar(){
		return serviceModelo.filtrar();
	}
	
}
