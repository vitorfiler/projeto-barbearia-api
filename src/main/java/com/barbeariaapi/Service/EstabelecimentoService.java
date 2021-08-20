package com.barbeariaapi.Service;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.barbeariaapi.Model.Estabelecimento;

@Service
public interface EstabelecimentoService {
	public void cadastrarEstabelecimento(Estabelecimento estabelecimento);
	
	public Optional<Estabelecimento> buscarEstabelecimentoPeloId(Long id);
	
	public Map<String, String> recuperarSenha(String email);
	
	public String redefinirSenha(Map<String, String> parametros);
	
}
