package com.barbeariaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping
	public List<Solicitacao> getSolicitacoes(@RequestParam(name = "estabelecimento_id") Long estabelecimentoID){
		return solicitacaoService.getSolicitacoes(estabelecimentoID);
	}
}
