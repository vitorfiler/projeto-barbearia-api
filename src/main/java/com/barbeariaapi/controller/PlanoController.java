package com.barbeariaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbeariaapi.model.Plano;
import com.barbeariaapi.service.PlanoService;

@RestController
@RequestMapping("/planos")
public class PlanoController {

	@Autowired
	PlanoService planoService;
	
	@GetMapping
	public List<Plano> buscarTodos(){
		return planoService.buscarTodos();
	}
	
//	@GetMapping
//	public Servico buscarPeloId(@RequestParam(name="estabelecimento_ID")Long estabelecimentoID, Long servicoId){
//		return modeloService.buscarPeloId(estabelecimentoID, servicoId);
//	}
	
//	@PostMapping
//	public Servico cadastrar(Servico servico){
//		return modeloService.cadastrar(servico);
//	}
//	
//	@PutMapping
//	public Servico alterar(Servico servico){
//		return modeloService.alterar(servico);
//	}
//	
//	@DeleteMapping
//	public void deletarPeloId(Long id){
//		modeloService.deletarPeloId(id);
//	}
//	
//	@GetMapping("/filtro")
//	public List<Servico> filtrar(){
//		return modeloService.filtrar();
//	}
	
}
