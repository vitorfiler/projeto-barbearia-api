package com.barbeariaapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.barbeariaapi.dto.SolicitacaoDTO;
import com.barbeariaapi.model.Solicitacao;

@Service
public interface SolicitacaoService {

	public SolicitacaoDTO criarSolicitacao(Solicitacao solicitacao);
	
	public List<Solicitacao> getSolicitacoes(Long estabelecimentoID);
	
	public List<Solicitacao> filtrarSolicitacoes(Long estabelecimentoID, String filtro, String status, String dtInicial, String dtFinal);
	
	public Solicitacao alterarSolicitacao(Solicitacao solicitacao);
	
	public Solicitacao buscarPeloId(Long solicitacaoId);
	
	public void deletarPeloId(Long solicitacaoId);
	
}
