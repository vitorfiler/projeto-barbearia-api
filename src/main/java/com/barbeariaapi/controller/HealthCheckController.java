package com.barbeariaapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck(){
		return new ResponseEntity<String>("Application UP", HttpStatus.OK);
	}
}
