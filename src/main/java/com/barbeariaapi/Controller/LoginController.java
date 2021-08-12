package com.barbeariaapi.Controller;

import java.util.Map;
import java.util.Optional;
import java.util.Date;
import java.util.List;
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

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.barbeariaapi.Model.Estabelecimento;
import com.barbeariaapi.Model.Login;
import com.barbeariaapi.Repository.EstabelecimentoRepository;
import com.barbeariaapi.Service.LoginService;


@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public Login login(@RequestBody Map<String, String> parametros) {
		String nomeUsuario = parametros.get("username");
		String senha = parametros.get("password");
//		Estabelecimento estabelecimento = loginService.loadUserByUsername(nomeUsuario);
//		if(estabelecimento != null) {
			String token = getJWTToken(parametros.get("username"));
			Login user = new Login();
			user.setNomeUsuario(parametros.get("username"));
			user.setToken(token);		
			return user;
//		}
//		return new ResponseEntity("Usuário ou senha não encontrados", HttpStatus.BAD_REQUEST);
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
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
	
	
//	public Estabelecimento autenticar(String usuario, String senha) throws UsernameNotFoundException {
//		Estabelecimento user = estabelecimentoRepository.findByEmail(usuario)
//				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com e-mail informado"));
//		return new Estabelecimento(user);
//	}
}
