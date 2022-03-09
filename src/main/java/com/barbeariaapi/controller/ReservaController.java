package com.barbeariaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barbeariaapi.dto.ReservaDTO;
import com.barbeariaapi.service.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

	@Autowired
	ReservaService reservaService;
	
	@GetMapping("/filtro")
	public ResponseEntity<String> filtrarReservas(@RequestParam(name="estabelecimento_ID") Long estabelecimentoID,
			@RequestParam(name="filtro_reserva") String filtroReserva,@RequestParam(name="selecao_status") String selecaoStatus,
			@RequestParam(name="dt_inicial", required=false) String dt_inicial, @RequestParam(name="dt_final", required=false) String dt_final) {
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@GetMapping("/todas")
	public List<ReservaDTO> buscarReservas(@RequestParam(name="estabelecimento_ID") Long estabelecimentoID) {
		return reservaService.buscarTodas(estabelecimentoID);
	}
	
	@PostMapping
	public ReservaDTO criarReserva(@RequestBody ReservaDTO reserva) {
		return reservaService.cadastrar(reserva);
	}

}
