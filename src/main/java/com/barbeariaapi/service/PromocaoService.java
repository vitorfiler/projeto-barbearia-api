package com.barbeariaapi.service;

import org.springframework.stereotype.Service;

import com.barbeariaapi.model.Promocao;

@Service
public interface PromocaoService {

	public Promocao obterPromocao(Long estabelecimentoID);
}
