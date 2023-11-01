package com.barbeariaapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barbeariaapi.dto.AgendamentoDTO;
import com.barbeariaapi.model.Agendamento;
import com.barbeariaapi.model.Cliente;
import com.barbeariaapi.repository.AgendamentoRepository;
import com.barbeariaapi.repository.ClienteRepository;
import com.barbeariaapi.service.AgendamentoService;
import com.barbeariaapi.utis.DateUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component("AgendamentoController")
public class AgendamentoServiceImpl implements AgendamentoService {

	@Autowired
	AgendamentoRepository agendamentoRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	private ObjectMapper objectMapper;

	private static final String TODOS = "TODOS";

	public AgendamentoDTO criarAgendamento(Agendamento agendamento) {
		if (agendamento.getId() == null && agendamento.getCdAgendamento() == null) {
			agendamento.setCdAgendamento(gerarCodigoAgendamento(agendamento));
			agendamentoRepository.save(agendamento);
		}
		return objectMapper.convertValue(agendamentoRepository.save(agendamento), AgendamentoDTO.class);
	}

	public String gerarCodigoAgendamento(Agendamento agendamento) {
		String cdAgendamento = UUID.randomUUID().toString();
		return cdAgendamento;
	}

	public List<Agendamento> buscarAgendamentos(Long estabelecimentoID) {
		List<Agendamento> agendamentos = agendamentoRepository.findAllByEstabelecimentoIDOrderByDtAtendimentoDesc(estabelecimentoID);
		return adicionarClienteAoRetornoAgendamentos(agendamentos);
	}

	public List<Agendamento> filtrarAgendamentos(Long estabelecimentoID, String filtro, String status, String dtInicial,
			String dtFinal) {
		List<Agendamento> agendametos = new ArrayList<>();
		if (status.isEmpty()) {
			return agendametos;
		}

		if (!status.equals(TODOS) && !dtInicial.isEmpty() && !dtFinal.isEmpty()) {
			agendametos = agendamentoRepository.findAllFiltro(estabelecimentoID, dtInicial, dtFinal, status);
		} else if (status.equals(TODOS) && !dtInicial.isEmpty() && !dtFinal.isEmpty()) {
			agendametos = agendamentoRepository.findAllByDtAtendimento(estabelecimentoID, dtInicial, dtFinal);
		} else if (dtInicial.isEmpty() && dtFinal.isEmpty() && status.equals(TODOS)) {
			agendametos = agendamentoRepository.findAllByEstabelecimentoIDOrderByDtAtendimentoDesc(estabelecimentoID);
		} else {
			agendametos = agendamentoRepository.findAllByStatus(estabelecimentoID, status);
		}

		List<Agendamento> agendamentosFiltrados = new ArrayList<>();
		agendametos.forEach(agendamento -> {
			Optional<Cliente> cliente = clienteRepository.findById(agendamento.getClienteID());
			if (agendamento.getNomeServico().toLowerCase().contains(filtro.toLowerCase())) {
				agendamentosFiltrados.add(agendamento);
			} else if (agendamento.getResponsavel().toLowerCase().contains(filtro.toLowerCase())) {
				agendamentosFiltrados.add(agendamento);
			} else if (cliente.isPresent()) {
				if (cliente.get().getNome().toLowerCase().contains(filtro.toLowerCase())) {
					agendamentosFiltrados.add(agendamento);
				} else if (cliente.get().getCpf().toLowerCase().contains(filtro.toLowerCase())) {
					agendamentosFiltrados.add(agendamento);
				}
			}
			agendamento.setCliente(cliente.get());
			agendamentosFiltrados.forEach(s -> s.setCliente(cliente.get()));
		});
		return agendamentosFiltrados;
	}

	public Agendamento alterarAgendamento(Agendamento agendamento) {
		try {
			Optional<Agendamento> resposta = agendamentoRepository.findById(agendamento.getId());
			if (resposta.isPresent()) {
				if(resposta.get().getCliente() != null) {					
					Optional<Cliente> cliente = clienteRepository.findById(agendamento.getClienteID());
					agendamento.setCliente(cliente.get());
				}
				agendamentoRepository.save(agendamento);
				return agendamento;
			} else {
				throw new IllegalArgumentException(
						"Agendamento: " + agendamento.getCdAgendamento() + ", não encontrada no banco de dados");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha ao alterar Agendamento " + e);
		}
	}

	public Agendamento buscarPeloId(Long agendamentoID) {
		try {
			Optional<Agendamento> agendamento = agendamentoRepository.findById(agendamentoID);
			if (agendamento.isPresent()) {
				Optional<Cliente> cliente = clienteRepository.findById(agendamento.get().getClienteID());
				agendamento.get().setCliente(cliente.get());
				return agendamento.get();
			} else {
				throw new IllegalArgumentException("Agendamento não encontrada");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha ao buscar Agendamento " + e);
		}
	}

	private List<Agendamento> adicionarClienteAoRetornoAgendamentos(List<Agendamento> agendamentos) {
		if (agendamentos == null) {
			return agendamentos;
		}
		agendamentos.forEach(agendamento -> {
			Optional<Cliente> cliente = clienteRepository
					.findById(agendamento.getClienteID() != null ? agendamento.getClienteID() : 0);
			if (cliente.isPresent()) {
				agendamento.setCliente(cliente.get());
			}
		});
		return agendamentos;
	}

	public void deletarPeloId(Long agendamentoId) {
		try {
			Optional<Agendamento> agendamento = agendamentoRepository.findById(agendamentoId);
			if (agendamento.isPresent()) {
				agendamentoRepository.deleteById(agendamentoId);
			} else {
				throw new IllegalArgumentException("Agendamento não encontrada");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha ao deletar Agendamento " + e);
		}
	}
	
	public List<Agendamento> agendamentosDoDia(Long estabelecimentoID){
		try {
			String hoje = DateUtils.diaDeHoje();
			List<Agendamento> agendamentosDia = agendamentoRepository.findAllToday(hoje, estabelecimentoID);
			if(agendamentosDia != null) {
				agendamentosDia.forEach(a->{
					if(a.getClienteID() != null) {						
						Cliente cliente = clienteRepository.findById(a.getClienteID()).get();
						a.setCliente(cliente);
					}
				});
			}
			return agendamentosDia;
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha ao listar Agendamentos " + e);
		}
	}

}
