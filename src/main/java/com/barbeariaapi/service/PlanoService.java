package com.barbeariaapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.barbeariaapi.model.Plano;

@Service
public interface PlanoService {

	public List<Plano> buscarTodos();
	
}
