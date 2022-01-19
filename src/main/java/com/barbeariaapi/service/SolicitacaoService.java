package com.barbeariaapi.service;

import org.springframework.stereotype.Service;

import com.barbeariaapi.dto.SolicitacaoDTO;
import com.barbeariaapi.model.Solicitacao;

@Service
public interface SolicitacaoService {

	public SolicitacaoDTO criarSolicitacao(Solicitacao solicitacao);
}
