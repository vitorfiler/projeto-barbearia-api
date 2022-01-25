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

import com.barbeariaapi.dto.SolicitacaoDTO;
import com.barbeariaapi.model.Solicitacao;
import com.barbeariaapi.service.SolicitacaoService;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

	@Autowired
	private SolicitacaoService solicitacaoService;
	
	@PostMapping
	public SolicitacaoDTO criarSolicitacao(@RequestBody Solicitacao solicitacao) {
		return solicitacaoService.criarSolicitacao(solicitacao);
	}
	
	@GetMapping("/todas")
	public List<Solicitacao> getSolicitacoes(@RequestParam(name = "estabelecimento_ID") Long estabelecimentoID){
		return solicitacaoService.getSolicitacoes(estabelecimentoID);
	}
	
	@GetMapping("/filtro")
//	@Query(value = "SELECT * FROM solicitacao WHERE estabelecimento_ID = :estabelecimentoID"
//            + " AND (' ' = :status OR status = :status) "
//            + " AND (' ' = :dt_atendimento OR dt_atendimento = :dt_atendimento)"
//            + " AND ()' ' = :valor OR valor LIKE %:valor% ", nativeQuery = true)
	public List<Solicitacao> filtraSolicitacoes(
			@RequestParam(name = "estabelecimento_ID", required = false) Long estabelecimentoID, 
			@RequestParam(name = "filtro", required = false) String filtro){
		
		return solicitacaoService.filtrarSolicitacoes(estabelecimentoID, filtro);
	}
	
	@PutMapping
	public Solicitacao alterarSolicitacao(@RequestBody Solicitacao solicitacao) {
		return solicitacaoService.alterarSolicitacao(solicitacao);
	}
	
	@GetMapping()
	public Solicitacao buscarPeloId(@RequestParam(name="solicitacao_ID", required= true) Long solicitacaoId) {
		return solicitacaoService.buscarPeloId(solicitacaoId);
	}
	
	@DeleteMapping
	public void deletarPeloId(@RequestParam(name="solicitacao_ID")Long solicitacaoId) {
		solicitacaoService.deletarPeloId(solicitacaoId);
	}
}
