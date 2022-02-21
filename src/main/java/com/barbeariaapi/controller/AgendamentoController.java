package com.barbeariaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barbeariaapi.dto.AgendamentoDTO;
import com.barbeariaapi.model.Agendamento;
import com.barbeariaapi.service.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

	@Autowired
	private AgendamentoService agendamentoService;
	
	@PostMapping
	public AgendamentoDTO criarAgendamento(@RequestBody Agendamento agendamento) {
		return agendamentoService.criarAgendamento(agendamento);
	}
	
	@GetMapping("/todas")
	public List<Agendamento> buscarAgendamentos(@RequestParam(name = "estabelecimento_ID") Long estabelecimentoID){
		return agendamentoService.buscarAgendamentos(estabelecimentoID);
	}
	
	@GetMapping("/filtro")
	public List<Agendamento> filtraAgendamento(
			@RequestParam(name = "estabelecimento_ID", required = true) Long estabelecimentoID, 
			@RequestParam(name = "filtro", required = true) String filtro,
			@RequestParam(name = "status", required = true) String status,
			@RequestParam(name = "dt_inicial", required = true) String dtInicial,
			@RequestParam(name = "dt_final", required = true) String dtFinal){
		
		return agendamentoService.filtrarAgendamentos(estabelecimentoID, filtro, status, dtInicial, dtFinal);
	}
	
	@PutMapping
	public Agendamento alterarAgendamento(@RequestBody Agendamento agendamento) {
		return agendamentoService.alterarAgendamento(agendamento);
	}
	
	@GetMapping()
	public Agendamento buscarPeloId(@RequestParam(name="agendamento_ID", required= true) Long agendamentoId) {
		return agendamentoService.buscarPeloId(agendamentoId);
	}
	
	@DeleteMapping
	public void deletarPeloId(@RequestParam(name="agendamento_ID")Long agendamentoId) {
		agendamentoService.deletarPeloId(agendamentoId);
	}
}
