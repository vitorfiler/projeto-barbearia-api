package com.barbeariaapi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barbeariaapi.model.Estabelecimento;
import com.barbeariaapi.model.Login;
import com.barbeariaapi.service.LoginService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<Login> login(@RequestBody Map<String, String> parametros) throws UsernameNotFoundException, Exception {
		String nomeUsuario = parametros.get("username");
		String senha = parametros.get("password");
		Estabelecimento estabelecimento = loginService.loadUserByUsername(nomeUsuario, senha);
		Map<String, String> tokens = getJWTToken(parametros.get("username"));
		Login user = new Login();
		user.setToken(tokens.get("token"));
		user.setRefreshToken(tokens.get("refreshToken"));
		user.setEstabelecimento(estabelecimento.getEstabelecimento());
		user.setEmail(estabelecimento.getEmail());
		user.setNomeProprietario(estabelecimento.getNomeProprietario());
		user.setEstabelecimento_ID(estabelecimento.getId());
		user.setCadastroCompleto(estabelecimento.getCadastroCompleto());
		user.setPrimeiroLogin(estabelecimento.getPrimeiroLogin());
		user.setPlano_ID(estabelecimento.getPlanoID());
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	private Map<String, String> getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 720000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();
		
		String refreshToken = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1440000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();
		
		Map<String, String> tokens = new HashMap<>();
		tokens.put("token", token);
		tokens.put("refreshToken", refreshToken);
	    
		return tokens;
	}
	
	
//	public Estabelecimento autenticar(String usuario, String senha) throws UsernameNotFoundException {
//		Estabelecimento user = estabelecimentoRepository.findByEmail(usuario)
//				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com e-mail informado"));
//		return new Estabelecimento(user);
//	}
}
