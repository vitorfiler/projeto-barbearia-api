package com.barbeariaapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.barbeariaapi.dto.ReservaDTO;
import com.barbeariaapi.model.Reserva;

@Service
public interface ReservaService {

	public List<ReservaDTO> buscarTodas(Long estabelecimentoId);
	
	public Reserva buscarPeloId(Long estabelecimentoID, Long servicoId);
	
	public ReservaDTO cadastrar(ReservaDTO reserva);
	
	public Reserva alterar(Reserva reserva);
	
	public void deletarPeloId(Long reserva);
	
	public List<Reserva> filtrar();
}
