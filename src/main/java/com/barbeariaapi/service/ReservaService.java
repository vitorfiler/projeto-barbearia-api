package com.barbeariaapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barbeariaapi.dto.ReservaDTO;
import com.barbeariaapi.exceptions.BadRequestException;
import com.barbeariaapi.model.Cliente;
import com.barbeariaapi.model.Produto;
import com.barbeariaapi.model.ProdutoReserva;
import com.barbeariaapi.model.Reserva;
import com.barbeariaapi.repository.ClienteRepository;
import com.barbeariaapi.repository.ProdutoRepository;
import com.barbeariaapi.repository.ProdutoReservaRepository;
import com.barbeariaapi.repository.ReservaRepository;
import com.barbeariaapi.service.ReservaService;
import com.barbeariaapi.utis.CdIdentificadorUtils;

@Component
public class ReservaService{

	private static final String TODOS = "TODOS";
	
	@Autowired
	ReservaRepository reservaRepository;
	
	@Autowired
	ProdutoReservaRepository produtoReservaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public List<ReservaDTO> buscarTodas(Long estabelecimentoId){
		try {
			List<Reserva> reservas = reservaRepository.findAllByEstabelecimentoID(estabelecimentoId);
			List<ReservaDTO> reservasDTO = reservas.stream().map(r-> new ReservaDTO(r)).collect(Collectors.toList());
			reservasDTO.forEach(reserva->reserva.setProdutos(produtoRepository.buscarProdutosDeUmaReserva(estabelecimentoId, reserva.getId())));
			return reservasDTO;
		} catch (Exception e) {
			throw new BadRequestException("Falha ao buscar Reservas", e);
		}
	}
	
	public ReservaDTO buscarPeloId(Long estabelecimentoID, Long reservaId) {
		try {
			Reserva reserva = reservaRepository.findById(reservaId).get();
			ReservaDTO reservaDTO = new ReservaDTO(reserva);
			reservaDTO.setProdutos(produtoRepository.buscarProdutosDeUmaReserva(estabelecimentoID, reserva.getId()));
			return reservaDTO;
		} catch (Exception e) {
			throw new BadRequestException("Falha ao buscar Reserva", e);
		}
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
				reservaDTO = new ReservaDTO(reserva);
				reservaDTO.setProdutos(produtosParaRetorno);
				return reservaDTO;
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new BadRequestException("Falha ao cadastrar Reserva", e);
		}
	}
	
	@SuppressWarnings("unused")
	public ReservaDTO alterar(ReservaDTO reservaDTO) {
		try {
			Reserva reserva = new Reserva(buscarPeloId(reservaDTO.getEstabelecimentoID(), reservaDTO.getId()));
			if(reserva != null) {
				List<Produto> produtosParaRetorno = new ArrayList<>();
				List<Produto> produtosNaReserva = reservaDTO.getProdutos(); 
				
				reservaDTO.setCodReserva(reserva.getCodReserva());
				reserva = new Reserva(reservaDTO);
				reserva = reservaRepository.save(reserva);
				
				produtosParaRetorno = alterarProdutoReserva(reservaDTO).stream()
						.map(r->produtoRepository.findById(r.getProdutoID()).get())
						.collect(Collectors.toList());
				reservaDTO = new ReservaDTO(reserva);
				reservaDTO.setProdutos(produtosParaRetorno);
				return reservaDTO;
			}
			throw new BadRequestException("Reserva não encontrada");
		} catch (Exception e) {
			throw new BadRequestException("Falha ao cadastrar Reserva", e);
		}
	}
	
	public void deletarPeloId(Long reservaId) {
		
	}
	
	public List<ReservaDTO> filtrar(Long estabelecimentoID, String filtro, String status, String dtInicial,
			String dtFinal){
		List<Reserva> reservas = new ArrayList<>();
		List<ReservaDTO> reservasDTO = new ArrayList<>();
		List<ReservaDTO> reservasFiltradas = new ArrayList<>();
		
		if (status.isEmpty()) {
			return reservasDTO;
		}
		else if (!status.equals(TODOS) && !dtInicial.isEmpty() && !dtFinal.isEmpty()) {
			reservas = reservaRepository.findAllFiltro(estabelecimentoID, dtInicial, dtFinal, status);
		} else if (status.equals(TODOS) && !dtInicial.isEmpty() && !dtFinal.isEmpty()) {
			reservas = reservaRepository.findAllByDtAtendimento(estabelecimentoID, dtInicial, dtFinal);
		} else if (dtInicial.isEmpty() && dtFinal.isEmpty() && status.equals(TODOS)) {
			reservas = reservaRepository.findAllByEstabelecimentoID(estabelecimentoID);
		} else {
			reservas = reservaRepository.findAllByStatus(estabelecimentoID, status);
		}
		
		reservasDTO = reservas.stream().map(r-> new ReservaDTO(r)).collect(Collectors.toList());
		reservasDTO.forEach(r->{
			r.setProdutos(produtoRepository.buscarProdutosDeUmaReserva(estabelecimentoID, r.getId()));
		});
		
		reservasDTO.forEach(r->{
			Optional<Cliente> cliente = clienteRepository.findById(r.getClienteID());
			cliente.ifPresent(c-> r.setNomeCliente(c.getNome()));
			
			List<Produto> produtosFiltrados =  r.getProdutos().stream()
				.filter(p-> p.getNome().toLowerCase().contains(filtro.toLowerCase()))
				.collect(Collectors.toList());
			
			if(r.getNomeCliente().toLowerCase().contains(filtro.toLowerCase())) {
				reservasFiltradas.add(r);
			} 
			else if(produtosFiltrados.size() > 0 ) {
				reservasFiltradas.add(r);
			}
		});
		return reservasFiltradas;
	}
	
	private List<ProdutoReserva> criarProdutoReserva(Reserva reserva, List<Produto> produtosSolicitados) {
		try {				
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

	private List<ProdutoReserva> alterarProdutoReserva(ReservaDTO reserva) {
		try {				
			List<ProdutoReserva> reservas = produtoReservaRepository.findByReservaID(reserva.getId());
			List<Produto> produtos = reserva.getProdutos();
			reservas.forEach(r->{
				r.setProdutoID(produtos.stream().mapToLong(p-> p.getId()).findFirst().orElseGet(null));
				r.setQtd(produtos.stream().mapToInt(p-> p.getQtdEstoque()).findFirst().orElseGet(null));
				produtoReservaRepository.save(r);
				produtos.remove(produtos.stream().findFirst().get());
			});
			
			return reservas;
		} catch (Exception e) {
			throw new BadRequestException("Falha ao criar Reserva", e);
		}
	}
}
