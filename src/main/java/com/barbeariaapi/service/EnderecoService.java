package com.barbeariaapi.service;

import org.springframework.stereotype.Service;

import com.barbeariaapi.model.Endereco;

@Service
public interface EnderecoService {

	public Endereco cadastrar(Endereco endereco);
	
//	public List<Servico> buscarTodos(Long estabelecimentoId);
//	
//	public Servico buscarPeloId(Long estabelecimentoID, Long servicoId);
//	
//	public Servico alterar(Servico servico);
//	
//	public void deletarPeloId(Long servicoId);
}
