package com.barbeariaapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.barbeariaapi.model.Servico;

@Service
public interface ServiceModelo {

	public List<Servico> buscarTodos(Long estabelecimentoId);
	
	public Servico buscarPeloId(Long estabelecimentoID, Long servicoId);
	
	public Servico cadastrar(Servico servico);
	
	public Servico alterar(Servico servico);
	
	public void deletarPeloId(Long servicoId);
	
	public List<Servico> filtrar();
}
