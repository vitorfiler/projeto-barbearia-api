package com.barbeariaapi.Service;

import org.springframework.stereotype.Service;

import com.barbeariaapi.Model.Estabelecimento;

@Service
public interface EstabelecimentoService {
	public void cadastrarEstabelecimento(Estabelecimento estabelecimento);
}
