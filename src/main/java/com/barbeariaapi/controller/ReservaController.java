package com.barbeariaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public List<ReservaDTO> filtrarReservas(
			@RequestParam(name="estabelecimento_ID") Long estabelecimentoID,
			@RequestParam(name="filtro") String filtroReserva,
			@RequestParam(name="status") String selecaoStatus,
			@RequestParam(name="dt_inicial", required=false) String dt_inicial,
			@RequestParam(name="dt_final", required=false) String dt_final) {
		return reservaService.filtrar(estabelecimentoID, 
				filtroReserva, selecaoStatus, dt_inicial, dt_final);
	}
	
	@GetMapping("/todas")
	public List<ReservaDTO> buscarReservas(@RequestParam(name="estabelecimento_ID") Long estabelecimentoID) {
		return reservaService.buscarTodas(estabelecimentoID);
	}
	
	@GetMapping
	public ReservaDTO buscarPeloId(@RequestParam(name="estabelecimento_ID") Long estabelecimentoID,
			@RequestParam(name="reserva_ID") Long reservaID) {
		return reservaService.buscarPeloId(estabelecimentoID, reservaID);
	}
	
	@PostMapping
	public ReservaDTO criarReserva(@RequestBody ReservaDTO reserva) {
		return reservaService.cadastrar(reserva);
	}
	
	@PutMapping
	public ReservaDTO alterarReserva(@RequestBody ReservaDTO reserva) {
		return reservaService.alterar(reserva);
	}

}
