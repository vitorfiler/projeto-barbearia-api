package com.barbeariaapi.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barbeariaapi.dto.SolicitacaoDTO;
import com.barbeariaapi.model.Solicitacao;
import com.barbeariaapi.repository.SolicitacaoRepository;
import com.barbeariaapi.service.SolicitacaoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component("SolicitacoesController")
public class SolicitacaoServiceImpl implements SolicitacaoService{

	@Autowired
	SolicitacaoRepository solicitacaoRepository;

	@Autowired
	private ObjectMapper objectMapper;
	
	public SolicitacaoDTO criarSolicitacao(Solicitacao solicitacao) {
		if(solicitacao.getId() == null && solicitacao.getCdSolicitacao() == null) {			
			solicitacao.setCdSolicitacao(gerarCodigoSolicitacao(solicitacao));
			solicitacaoRepository.save(solicitacao);
		}
		return objectMapper.convertValue(solicitacaoRepository.save(solicitacao), SolicitacaoDTO.class);
	}
	
	public String gerarCodigoSolicitacao(Solicitacao solicitacao){
		String cdSolicitacao = UUID.randomUUID().toString();
		return cdSolicitacao;
	}
	
}
