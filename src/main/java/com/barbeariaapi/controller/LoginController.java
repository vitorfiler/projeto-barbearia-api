package com.barbeariaapi.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
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
	public ResponseEntity<Login> login(@RequestBody Map<String, String> parametros) {
		String nomeUsuario = parametros.get("username");
		String senha = parametros.get("password");
		Estabelecimento estabelecimento = loginService.loadUserByUsername(nomeUsuario, senha);
		String token = getJWTToken(parametros.get("username"));
		Login user = new Login();
		user.setToken(token);		
		user.setEstabelecimento(estabelecimento.getEstabelecimento());
		user.setEmail(estabelecimento.getEmail());
		user.setNomeProprietario(estabelecimento.getNomeProprietario());
		user.setEstabelecimento_ID(estabelecimento.getId());
		user.setCadastroCompleto(estabelecimento.getCadastroCompleto());
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	private String getJWTToken(String username) {
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
				.setExpiration(new Date(System.currentTimeMillis() + 999999999))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return token;
	}
	
	
//	public Estabelecimento autenticar(String usuario, String senha) throws UsernameNotFoundException {
//		Estabelecimento user = estabelecimentoRepository.findByEmail(usuario)
//				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com e-mail informado"));
//		return new Estabelecimento(user);
//	}
}
