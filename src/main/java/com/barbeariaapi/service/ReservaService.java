package com.barbeariaapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.barbeariaapi.dto.ReservaDTO;

@Service
public interface ReservaService {

	public List<ReservaDTO> buscarTodas(Long estabelecimentoId);
	
	public ReservaDTO buscarPeloId(Long estabelecimentoID, Long servicoId);
	
	public ReservaDTO cadastrar(ReservaDTO reservaDTO);
	
	public ReservaDTO alterar(ReservaDTO reservaDTO);
	
	public void deletarPeloId(Long reserva);
	
	public List<ReservaDTO> filtrar();
}
