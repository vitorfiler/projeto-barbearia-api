package com.barbeariaapi.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.barbeariaapi.model.Servico;
import com.barbeariaapi.service.ModeloService;

@Component("ModeloController")
public class ModeloService {

	public List<Servico> buscarTodos(Long estabelecimentoId){
		return null;
	}
	
	public Servico buscarPeloId(Long estabelecimentoID, Long servicoId) {
		return null;
	}
	
	public Servico cadastrar(Servico servico) {
		return null;
	}
	
	public Servico alterar(Servico servico) {
		return null;
	}
	
	public void deletarPeloId(Long servicoId) {
		
	}
	
	public List<Servico> filtrar(){
		return null;
	}
}
