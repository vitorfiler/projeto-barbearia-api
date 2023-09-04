package com.barbeariaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barbeariaapi.model.Endereco;
import com.barbeariaapi.repository.EnderecoRepository;
import com.barbeariaapi.service.EnderecoService;

@Component("EnderecoController")
public class EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;
	
	public Endereco cadastrar(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
//	public List<Servico> buscarTodos(Long estabelecimentoId){
//		return null;
//	}
//	
//	public Servico buscarPeloId(Long estabelecimentoID, Long servicoId) {
//		return null;
//	}
//	
//	public Servico alterar(Servico servico) {
//		return null;
//	}
//	
//	public void deletarPeloId(Long servicoId) {
//		
//	}
}
