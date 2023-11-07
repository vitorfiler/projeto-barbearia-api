package com.barbeariaapi.service;

import org.springframework.stereotype.Service;

import com.barbeariaapi.model.Beneficio;
import com.barbeariaapi.model.Plano;

import java.util.List;

@Service
public interface BeneficioService {
	
	public Beneficio cadastrarBeneficio(Beneficio beneficio, Plano planoID);

}
