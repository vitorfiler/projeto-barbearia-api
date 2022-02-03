package com.barbeariaapi.service.impl;

import java.util.ArrayList;
import java.util.Date;
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
import com.barbeariaapi.utis.DateUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component("SolicitacoesController")
public class SolicitacaoServiceImpl implements SolicitacaoService{

	@Autowired
	SolicitacaoRepository solicitacaoRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	private ObjectMapper objectMapper;

	private static final String TODOS = "TODOS";
	
	public SolicitacaoDTO criarSolicitacao(Solicitacao solicitacao) {
		if(solicitacao.getId() == null && solicitacao.getCdSolicitacao() == null) {			
			solicitacao.setCdSolicitacao(gerarCodigoSolicitacao(solicitacao));
			solicitacao.setDtAtendimento(new Date());
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
		return adicionarClienteAoRetornoSolicitacoes(solicitacoes);
	}
	
	public List<Solicitacao> filtrarSolicitacoes(Long estabelecimentoID, String filtro, String status, String dtInicial, String dtFinal){
		List<Solicitacao> solicitacoes = new ArrayList<>();
		if(status.isEmpty()) {
			return solicitacoes;
		}else if(!dtInicial.isEmpty() && !dtFinal.isEmpty()) {
			DateUtils.validarDuasDatas(dtInicial, dtFinal);
		}
		
		if(!status.equals(TODOS) && !dtInicial.isEmpty() && !dtFinal.isEmpty()){			
			solicitacoes = solicitacaoRepository.findAllFiltro(estabelecimentoID, dtInicial, dtFinal, status);
		}
		else if(status.equals(TODOS) || !dtInicial.isEmpty() && !dtFinal.isEmpty()) {
			solicitacoes = solicitacaoRepository.findAllByDtAtendimento(estabelecimentoID, dtInicial, dtFinal);
		}
		else if(dtInicial.isEmpty() && dtFinal.isEmpty() && status.equals(TODOS)) {
			solicitacoes = solicitacaoRepository.findAllByEstabelecimentoID(estabelecimentoID);			
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
				}else if(cliente.get().getCpf().toLowerCase().contains(filtro.toLowerCase())) {
					solicitacoesFiltradas.add(solicitacao);								
				}
			}
			solicitacao.setCliente(cliente.get());
			solicitacoesFiltradas.forEach(s->s.setCliente(cliente.get()));
		});
		return solicitacoesFiltradas;
	}
	
	public Solicitacao alterarSolicitacao(Solicitacao solicitacao) {
		try {			
			Optional<Solicitacao> resposta = solicitacaoRepository.findById(solicitacao.getId());
			if(resposta.isPresent()) {
				Optional<Cliente> cliente = clienteRepository.findById(solicitacao.getClienteID());
				solicitacaoRepository.save(solicitacao);
				solicitacao.setCliente(cliente.get());
				return solicitacao;
			}else {
				throw new IllegalArgumentException("Solicitação: "+ solicitacao.getCdSolicitacao() +", não encontrada no banco de dados");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha ao alterar Solicitação "+ e);
		}
	}
	
	public Solicitacao buscarPeloId(Long solicitacaoId) {
		try {
			Optional<Solicitacao> solicitacao = solicitacaoRepository.findById(solicitacaoId);
			if(solicitacao.isPresent()) {
				Optional<Cliente> cliente = clienteRepository.findById(solicitacao.get().getClienteID());
				solicitacao.get().setCliente(cliente.get());
				return solicitacao.get();
			}else {
				throw new IllegalArgumentException("Solicitacao não encontrada");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha ao buscar solicitação " +e);
		}
	}
	
	private List<Solicitacao> adicionarClienteAoRetornoSolicitacoes(List<Solicitacao> solicitacoes) {
		solicitacoes.forEach(solicitacao->{
			Optional<Cliente> cliente = clienteRepository.findById(solicitacao.getClienteID());
			solicitacao.setCliente(cliente.get());
		});
		return solicitacoes;
	}
	
	public void deletarPeloId(Long solicitacaoId) {
		try {
			Optional<Solicitacao> solicitacao = solicitacaoRepository.findById(solicitacaoId);
			if(solicitacao.isPresent()) {				
				solicitacaoRepository.deleteById(solicitacaoId);
			}else {
				throw new IllegalArgumentException("Solicitacao não encontrada");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha ao deletar Solicitacao "+e);
		}
	}
	
}
