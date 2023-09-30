package com.barbeariaapi.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.barbeariaapi.model.Estabelecimento;

@Service
public interface LoginService {

	public Estabelecimento loadUserByUsername(String username, String password) throws UsernameNotFoundException, Exception;
}
