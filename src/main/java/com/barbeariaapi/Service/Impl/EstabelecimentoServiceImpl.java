package com.barbeariaapi.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barbeariaapi.Model.Estabelecimento;
import com.barbeariaapi.Repository.EstabelecimentoRepository;
import com.barbeariaapi.Service.EstabelecimentoService;

@Component("EstabelcimentoController")
public class EstabelecimentoServiceImpl implements EstabelecimentoService{

	@Autowired
	EstabelecimentoRepository estabelecimentoRepository;
	
	public void cadastrarEstabelecimento(Estabelecimento estabelecimento) {
		estabelecimentoRepository.save(estabelecimento);
	}
	
	public Optional<Estabelecimento> buscarEstabelecimentoPeloId(Long id) {
		return estabelecimentoRepository.findById(id);
	}

}
