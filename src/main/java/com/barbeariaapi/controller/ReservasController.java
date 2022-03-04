package com.barbeariaapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
public class ReservasController {

	@GetMapping("/filtro")
	public ResponseEntity<String> filtrarReservas(@RequestParam(name="estabelecimento_ID") Long estabelecimentoID,
			@RequestParam(name="filtro_reserva") String filtroReserva,@RequestParam(name="selecao_status") String selecaoStatus,
			@RequestParam(name="dt_inicial", required=false) String dt_inicial, @RequestParam(name="dt_final", required=false) String dt_final) {
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@GetMapping("/todas")
	public ResponseEntity<String> buscarReservas(@RequestParam(name="estabelecimento_ID") Long estabelecimentoID) {
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
