package com.barbeariaapi.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import com.barbeariaapi.model.Estabelecimento;
import com.barbeariaapi.repository.EstabelecimentoRepository;
import com.barbeariaapi.service.EstabelecimentoService;
import com.barbeariaapi.utis.EmailUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component("EstabelcimentoController")
public class EstabelecimentoServiceImpl implements EstabelecimentoService{

	@Autowired
	EstabelecimentoRepository estabelecimentoRepository;
	
	public void cadastrarEstabelecimento(Estabelecimento estabelecimento) throws Exception {
		Estabelecimento estabelecimentoExistente = estabelecimentoRepository.findByEmail(estabelecimento.getEmail());
		if(estabelecimentoExistente == null) {			
			estabelecimentoRepository.save(estabelecimento);
		}else {			
			throw new Exception("Usuário com email "+estabelecimento.getEmail()+" já existe!");
		}
	}
	
	public Optional<Estabelecimento> buscarEstabelecimentoPeloId(Long id) {
		return estabelecimentoRepository.findById(id);
	}

	
	public Map<String, String> recuperarSenha(String email) {
		Map<String, String> parametros = new HashMap<>();
		Estabelecimento estabelecimento = estabelecimentoRepository.findByEmail(email);
		if(estabelecimento != null) {
			EmailUtils.enviarEmail(email);
			parametros.put("status", "Email enviado com sucesso!");
			parametros.put("hash", gerarHashRecuperacao(email));
		}else {
			parametros.put(email, "Email não encontrado no sistema!");
		}
		
		return parametros;
	}	
	
	public String redefinirSenha(Map<String, String> parametros) {
		String senha  = parametros.get("password");
		String email  = parametros.get("email");
		Estabelecimento estabelecimento = estabelecimentoRepository.findByEmail(email);
		if(estabelecimento != null) {
			estabelecimento.setSenha(senha);
			estabelecimentoRepository.save(estabelecimento);
			return "Senha alterada com sucesso!";
		}else {
			return "Falha ao alterar senha!";
		}
	}
	
	public Estabelecimento atualizarEstabelecimento(Estabelecimento estabelecimento) throws Exception {
		Estabelecimento estabelecimentoResponse = estabelecimentoRepository.findByEmail(estabelecimento.getEmail());
		if(estabelecimentoResponse != null) {
			estabelecimentoRepository.save(estabelecimentoResponse);
			return estabelecimentoResponse;
		}else {
			throw new Exception("Usuário com email "+estabelecimento.getEmail()+" não foi encontrado!");
		}
	}
	
	private String gerarHashRecuperacao(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String hash = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return hash;
	}
}