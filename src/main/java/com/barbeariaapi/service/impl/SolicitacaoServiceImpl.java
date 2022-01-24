package com.barbeariaapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barbeariaapi.dto.SolicitacaoDTO;
import com.barbeariaapi.model.Cliente;
import com.barbeariaapi.model.Solicitacao;
import com.barbeariaapi.repository.ClienteRepository;
import com.barbeariaapi.repository.SolicitacaoRepository;
import com.barbeariaapi.service.SolicitacaoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component("SolicitacoesController")
public class SolicitacaoServiceImpl implements SolicitacaoService{

	@Autowired
	SolicitacaoRepository solicitacaoRepository;

	@Autowired
	ClienteRepository clienteRepository;

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
	
	public List<Solicitacao> getSolicitacoes(Long estabelecimentoID){
		List<Solicitacao> solicitacoes = solicitacaoRepository.findAllByEstabelecimentoID(estabelecimentoID);
		solicitacoes.forEach(solicitacao->{
			Optional<Cliente> cliente = clienteRepository.findById(solicitacao.getClienteID());
			solicitacao.setCliente(cliente.get());
		});
		return solicitacoes;
	}
	
	public List<Solicitacao> filtrarSolicitacoes(Long estabelecimentoID, String filtro){
		List<Solicitacao> solicitacoes = getSolicitacoes(estabelecimentoID);
		if(filtro.isEmpty()) {
			return solicitacoes;
		}
		List<Solicitacao> solicitacoesFiltradas = new ArrayList<>();
		solicitacoes.forEach(solicitacao->{
			Optional<Cliente> cliente = clienteRepository.findById(solicitacao.getClienteID());
			if(solicitacao.getNomeServico().toLowerCase().contains(filtro.toLowerCase())) {
				solicitacoesFiltradas.add(solicitacao);
			}
			else if(solicitacao.getResponsavel().toLowerCase().contains(filtro.toLowerCase())) {
				solicitacoesFiltradas.add(solicitacao);				
			}
			else if(cliente.isPresent()) {				
				if(cliente.get().getNome().toLowerCase().contains(filtro.toLowerCase())) {
					solicitacoesFiltradas.add(solicitacao);								
				}
			}
		});
		return solicitacoesFiltradas;
	}
}
