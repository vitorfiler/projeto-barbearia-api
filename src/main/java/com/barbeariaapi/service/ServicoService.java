package com.barbeariaapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.barbeariaapi.model.Servico;

@Service
public interface ServicoService {

	public List<Servico> buscarTodosServicos(Long estabelecimentoId);
	
	public Servico buscarServicoPeloId(Long servicoId);
	
	public Servico cadastrarServico(Servico servico);
	
	public Servico alterarServico(Servico servico);
	
	public void deletarServicoPeloId(Long servicoId);
	
	public List<Servico> filtrarServicos();
}
