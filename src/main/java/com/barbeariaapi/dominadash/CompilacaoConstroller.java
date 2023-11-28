package com.barbeariaapi.dominadash;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/compilacao")
public class CompilacaoConstroller {

	@Autowired
	CompilacaoRepository compilacaoRepository;

	@Autowired
	ParamCompilacaoRepository paramCompilacaoRepository;

	@PostMapping()
	public ResponseEntity<Compilacao> adicionar(@RequestBody Compilacao compilacao) throws Exception {
		try {
			compilacaoRepository.save(compilacao);
			if (compilacao != null && compilacao.getParametros().size() > 0) {
				compilacao.getParametros().forEach(p -> {
					p.setCompilacao(compilacao);
					p = paramCompilacaoRepository.save(p);
				});
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return new ResponseEntity<>(compilacao, HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<Compilacao> atualizar(@RequestBody Compilacao compilacao) throws Exception {
		try {
			if (compilacao != null && compilacao.getId() != null) {
				Compilacao response = compilacaoRepository.findById(compilacao.getId()).get();
				if (response != null) {
					
					compilacao.getParametros().forEach(p->{
						p.setCompilacao(compilacao);
						paramCompilacaoRepository.save(p);
					});
					
					compilacaoRepository.save(compilacao);
				}
			}
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

	@DeleteMapping
	public void deletar(@RequestParam(name = "id") Long id) throws Exception {
		try {
			compilacaoRepository.deleteById(id);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@DeleteMapping("/param")
	public void deletarParametro(@RequestParam(name = "id") Long id) throws Exception {
		try {
			paramCompilacaoRepository.deleteById(id);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}
