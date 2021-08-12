package com.barbeariaapi.Service.Impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.barbeariaapi.Model.Estabelecimento;
import com.barbeariaapi.Repository.EstabelecimentoRepository;
import com.barbeariaapi.Service.LoginService;

@Component("LoginController")
public class LoginServiceImpl implements LoginService{

	@Autowired
	EstabelecimentoRepository estabelecimentoRepository;
	
	public Estabelecimento loadUserByUsername(String username) throws UsernameNotFoundException {
		Estabelecimento estabelecimento = estabelecimentoRepository.findByEmail(username);
		if (estabelecimento.getEmail().equals(username)) {
			return estabelecimento;
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
