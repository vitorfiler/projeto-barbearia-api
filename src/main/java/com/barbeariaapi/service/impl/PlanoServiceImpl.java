package com.barbeariaapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barbeariaapi.model.Plano;
import com.barbeariaapi.repository.PlanoRepository;
import com.barbeariaapi.service.PlanoService;

@Component("PlanoController")
public class PlanoServiceImpl implements PlanoService{

	@Autowired
	PlanoRepository planoRepository;
	
	public List<Plano> buscarTodos(){
		return planoRepository.findAll();
	}
	
}
