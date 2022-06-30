package com.barbeariaapi.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.barbeariaapi.model.Estabelecimento;

@Service
public interface EstabelecimentoService {
	public void cadastrarEstabelecimento(Estabelecimento estabelecimento) throws Exception;
	
	public Optional<Estabelecimento> buscarEstabelecimentoPeloId(Long id);
	
	public Map<String, String> recuperarSenha(String email);
	
	public String redefinirSenha(Map<String, String> parametros);
	
	public Estabelecimento atualizarEstabelecimento(Estabelecimento estabelecimento, MultipartFile capa) throws Exception;
	
	public Estabelecimento completarCadastroEstabelecimento(Map<String, String> params, Long estabelecimentoID);
	
	public Estabelecimento receberFile(MultipartFile capa) throws Exception;
	
}
