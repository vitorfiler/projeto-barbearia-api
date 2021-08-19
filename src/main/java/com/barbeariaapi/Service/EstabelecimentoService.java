package com.barbeariaapi.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.barbeariaapi.Model.Estabelecimento;

@Service
public interface EstabelecimentoService {
	public void cadastrarEstabelecimento(Estabelecimento estabelecimento);
	
	public Optional<Estabelecimento> buscarEstabelecimentoPeloId(Long id);
	
	public String recuperarSenha(String email);
	
}
