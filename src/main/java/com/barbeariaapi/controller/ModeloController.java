package com.barbeariaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barbeariaapi.model.Servico;
import com.barbeariaapi.service.ModeloService;

@RestController
@RequestMapping("/endpont")
public class ModeloController {

	@Autowired
	ModeloService modeloService;
	
	@GetMapping("/todos")
	public List<Servico> buscarTodos(Long estabelecimentoId){
		return modeloService.buscarTodos(estabelecimentoId);
	}
	
	@GetMapping
	public Servico buscarPeloId(@RequestParam(name="estabelecimento_ID")Long estabelecimentoID, Long servicoId){
		return modeloService.buscarPeloId(estabelecimentoID, servicoId);
	}
	
	@PostMapping
	public Servico cadastrar(Servico servico){
		return modeloService.cadastrar(servico);
	}
	
	@PutMapping
	public Servico alterar(Servico servico){
		return modeloService.alterar(servico);
	}
	
	@DeleteMapping
	public void deletarPeloId(Long id){
		modeloService.deletarPeloId(id);
	}
	
	@GetMapping("/filtro")
	public List<Servico> filtrar(){
		return modeloService.filtrar();
	}
	
}
