package com.barbeariaapi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barbeariaapi.model.Servico;
import com.barbeariaapi.repository.ServicoRepoitory;
import com.barbeariaapi.service.ServicoService;

@Component("ServicoController")
public class ServicoService{

	@Autowired
	ServicoRepoitory servicoRepoitory;
	
	
	public List<Servico> buscarTodosServicos(Long estabelecimentoId){
		try {
			return servicoRepoitory.findAllByEstabelecimentoID(estabelecimentoId);
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha ao buscar Servicos", e);
		}
	}
	
	public Servico buscarServicoPeloId(Long servicoId) {
		try {
			 Optional<Servico> servico = servicoRepoitory.findById(servicoId);
			 if(servico.isPresent()) {
				 return servico.get();
			 }else {
				 throw new IllegalArgumentException("Servico não Encontrado");
			 }
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha ao buscar Servicos", e);
		}
	}
	
	public Servico cadastrarServico(Servico servico) {
		try {
			if(servico.getId() == null && servico.getCodigo() == null) {	
				servico.setCodigo(null);
				return servicoRepoitory.save(servico);
			}else {
				throw new IllegalArgumentException("Falha ao cadastrar Servico");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha ao cadastrar Servico", e);
		}
	}
	
	public Servico alterarServico(Servico servico) {
		try {			
			Optional<Servico> resposta = servicoRepoitory.findById(servico.getId());
			if(resposta.isPresent()) {
				servico.setCodigo(resposta.get().getCodigo());
				return servicoRepoitory.save(servico);
			}else {
				throw new IllegalArgumentException("Servico: "+ servico.getCodigo() +", não encontrado no banco de dados");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha ao alterar servico "+ e);
		}
	}
	
	public void deletarServicoPeloId(Long servicoId) {
		try {
			Optional<Servico> servico = servicoRepoitory.findById(servicoId);
			if(servico.isPresent()) {				
				servicoRepoitory.deleteById(servicoId);
			}else {
				throw new IllegalArgumentException("Servico não encontrado");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha ao deletar Servico "+e);
		}
	}
	
	public List<Servico> filtrarServicos(){
		try {
			return servicoRepoitory.findAll();
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha ao buscar Servicos", e);
		}
	}
	
	public String gerarCodigoServico(){
		String cdServico = UUID.randomUUID().toString();
		return cdServico;
	}
}
