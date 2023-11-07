package com.barbeariaapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barbeariaapi.exceptions.BadRequestException;
import com.barbeariaapi.model.Beneficio;
import com.barbeariaapi.model.Plano;
import com.barbeariaapi.repository.BeneficioRepository;
import com.barbeariaapi.service.BeneficioService;

@Component
public class BeneficioServiceImpl implements BeneficioService {
	
	@Autowired
	BeneficioRepository beneficioRepository;
	
	
	public Beneficio cadastrarBeneficio(Beneficio beneficio, Plano planoID) {
		try {
			return beneficioRepository.save(beneficio, planoID);
		} catch (Exception e) {
			throw new BadRequestException("Falha ao cadastrar benefício", e);
			
		}
	}

}
