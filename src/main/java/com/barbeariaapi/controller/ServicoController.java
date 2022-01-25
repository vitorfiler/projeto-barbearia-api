package com.barbeariaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barbeariaapi.model.Servico;
import com.barbeariaapi.service.ServicoService;

@RestController
@RequestMapping("/servicos")
public class ServicoController {


	@Autowired
	ServicoService servicoService;
	
	@GetMapping("/todos")
	public List<Servico> buscarTodos(@RequestParam(name="estabelecimento_ID") Long estabelecimentoId){
		return servicoService.buscarTodosServicos(estabelecimentoId);
	}
	
	@GetMapping
	public Servico buscarPeloId(@RequestParam(name="servico_ID") Long servicoId){
		return servicoService.buscarServicoPeloId(servicoId);
	}
	
	@PostMapping
	public Servico cadastrar(@RequestBody Servico servico){
		return servicoService.cadastrarServico(servico);
	}
	
	@PutMapping
	public Servico alterar(@RequestBody Servico servico){
		return servicoService.alterarServico(servico);
	}
	
	@DeleteMapping
	public void deletarPeloId(@RequestParam(name="servico_ID") Long servicoId){
		servicoService.deletarServicoPeloId(servicoId);
	}
	
	@GetMapping("/filtro")
	public List<Servico> filtrar(){
		return servicoService.filtrarServicos();
	}
}
