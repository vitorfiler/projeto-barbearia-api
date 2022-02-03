package com.barbeariaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbeariaapi.model.Endereco;
import com.barbeariaapi.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;
	
	@PostMapping
	public Endereco cadastrar(@RequestBody Endereco endereco){
		return enderecoService.cadastrar(endereco);
	}
	
//	@GetMapping("/todos")
//	public List<Servico> buscarTodos(Long estabelecimentoId){
//		return modeloService.buscarTodos(estabelecimentoId);
//	}
//	
//	@GetMapping
//	public Servico buscarPeloId(@RequestParam(name="estabelecimento_ID")Long estabelecimentoID, Long servicoId){
//		return modeloService.buscarPeloId(estabelecimentoID, servicoId);
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
	
}
