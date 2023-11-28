package com.barbeariaapi.dominadash;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/compilacao")
public class CompilacaoConstroller {

	@Autowired
	CompilacaoRepository compilacaoRepository;
	
	@PostMapping()
	public ResponseEntity<Compilacao> adicionarCompilacao(@RequestBody Compilacao compilacao) throws Exception {
		try {
			compilacaoRepository.save(compilacao);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return new ResponseEntity<>(compilacao, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Compilacao>> buscar() throws Exception {
		List<Compilacao> compilacoes = new ArrayList<>();
		try {
			compilacoes = compilacaoRepository.findAll();
		} catch (Exception e) {
			throw new Exception(e);
		}
		return new ResponseEntity<>(compilacoes, HttpStatus.OK);
	}
		
}
