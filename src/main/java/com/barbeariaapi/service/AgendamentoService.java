package com.barbeariaapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.barbeariaapi.dto.AgendamentoDTO;
import com.barbeariaapi.model.Agendamento;

@Service
public interface AgendamentoService {

	public AgendamentoDTO criarAgendamento(Agendamento agendamento);
	
	public List<Agendamento> buscarAgendamentos(Long estabelecimentoID);
	
	public List<Agendamento> filtrarAgendamentos(Long estabelecimentoID, String filtro, String status, String dtInicial, String dtFinal);
	
	public Agendamento alterarAgendamento(Agendamento agendamento);
	
	public Agendamento buscarPeloId(Long agendamentoId);
	
	public void deletarPeloId(Long agendamentoId);
	
}
