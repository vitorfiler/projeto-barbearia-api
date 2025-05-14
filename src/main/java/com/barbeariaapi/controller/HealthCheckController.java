package com.barbeariaapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbeariaapi.tenant.DataSourceContextHolder;

@RestController
public class HealthCheckController {

	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck(){
		String dbKey = DataSourceContextHolder.get();
	    System.out.println("Usando o banco de dados: " + dbKey);  // Log para verificar
		return new ResponseEntity<String>("Application UP: " + dbKey, HttpStatus.OK);
	}
}
