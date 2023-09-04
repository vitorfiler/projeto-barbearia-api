package com.barbeariaapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barbeariaapi.model.Estabelecimento;
import com.barbeariaapi.model.Plano;
import com.barbeariaapi.repository.PlanoRepository;
import com.barbeariaapi.service.EstabelecimentoService;
import com.barbeariaapi.service.PlanoService;

@Component
public class PlanoService {

	@Autowired
	PlanoRepository planoRepository;
	
	@Autowired
	EstabelecimentoService estabelecimentoService;
	
	public List<Plano> buscarTodos(){
		return planoRepository.findAll();
	}
	
	public void contratar(Long estabelecimentoID, Long planoID) throws Exception{
		Optional<Estabelecimento> estabelecimento = estabelecimentoService.buscarEstabelecimentoPeloId(estabelecimentoID);
		if(estabelecimento.get()!=null) {
			estabelecimento.get().setPlanoID(planoID);
			estabelecimentoService.atualizarEstabelecimento(estabelecimento.get());
		}
	}

}
