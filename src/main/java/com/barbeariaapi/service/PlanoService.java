package com.barbeariaapi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.barbeariaapi.model.Plano;

@Service
public interface PlanoService {

	public List<Plano> buscarTodos();
	
	public void contratar(Long estabelecimentoID, Long planoID) throws Exception;
	
	public Plano criarPlano(Plano plano);
}
