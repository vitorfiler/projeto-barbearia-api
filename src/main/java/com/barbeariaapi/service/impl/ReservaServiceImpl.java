package com.barbeariaapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barbeariaapi.dto.ReservaDTO;
import com.barbeariaapi.exceptions.BadRequestException;
import com.barbeariaapi.model.Produto;
import com.barbeariaapi.model.ProdutoReserva;
import com.barbeariaapi.model.Reserva;
import com.barbeariaapi.repository.ProdutoRepository;
import com.barbeariaapi.repository.ProdutoReservaRepository;
import com.barbeariaapi.repository.ReservaRepository;
import com.barbeariaapi.service.ReservaService;
import com.barbeariaapi.utis.CdIdentificadorUtils;

@Component
public class ReservaServiceImpl implements ReservaService{

	@Autowired
	ReservaRepository reservaRepository;
	
	@Autowired
	ProdutoReservaRepository produtoReservaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<ReservaDTO> buscarTodas(Long estabelecimentoId){
		try {
			List<Produto> produtosParaRetorno =  
					produtoReservaRepository.findAllByEstabelecimentoID(estabelecimentoId).stream()
						.map(r->produtoRepository.findById(r.getProdutoID()).get())
						.collect(Collectors.toList());
			List<Reserva> reservas = reservaRepository.findAllByEstabelecimentoID(estabelecimentoId);
			List<ReservaDTO> reservasDTO = reservas.stream()
					.map(r-> new ReservaDTO(r, produtosParaRetorno))
					.collect(Collectors.toList());
			
			return reservasDTO;
		} catch (Exception e) {
			throw new BadRequestException("Falha ao buscar Reservas", e);
		}
	}
	
	public Reserva buscarPeloId(Long estabelecimentoID, Long reservaId) {
		return null;
	}
	
	public ReservaDTO cadastrar(ReservaDTO reservaDTO) {
		try {
			if(reservaDTO.getId() == null && reservaDTO.getProdutos() !=null) {
				List<Produto> produtosParaRetorno = new ArrayList<>();
				List<Produto> produtosNaReserva = reservaDTO.getProdutos(); 

				Reserva reserva = new Reserva(reservaDTO);
				reserva.setCodReserva(CdIdentificadorUtils.gerarCodigo());
				reserva = reservaRepository.save(reserva);
				
				produtosParaRetorno = criarProdutoReserva(reserva, produtosNaReserva).stream()
						.map(r->produtoRepository.findById(r.getProdutoID()).get())
						.collect(Collectors.toList());
				
				return new ReservaDTO(reserva, produtosParaRetorno);
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new BadRequestException("Falha ao cadastrar Reserva", e);
		}
	}

	private List<ProdutoReserva> criarProdutoReserva(Reserva reserva, List<Produto> produtosSolicitados) {
		try {				
//			List<Long> idProdutos = produtosSolicitados;
			
//					get(0).get("qtd");
			List<ProdutoReserva> reservas = new ArrayList<>();
			produtosSolicitados.forEach(produto->{
				ProdutoReserva produtoReserva = new ProdutoReserva(
						reserva.getId(),
						produto.getId(),
						produto.getQtdEstoque(),
						reserva.getEstabelecimentoID());

				produtoReservaRepository.save(produtoReserva);
				reservas.add(produtoReserva);
			});
			return reservas;
		} catch (Exception e) {
			throw new BadRequestException("Falha ao criar Reserva", e);
		}
	}
	
	public Reserva alterar(Reserva reserva) {
		return null;
	}
	
	public void deletarPeloId(Long reservaId) {
		
	}
	
	public List<Reserva> filtrar(){
		return null;
	}

}
