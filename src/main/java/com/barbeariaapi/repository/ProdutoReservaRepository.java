package com.barbeariaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.barbeariaapi.model.Produto;
import com.barbeariaapi.model.ProdutoReserva;
import com.barbeariaapi.model.Reserva;

@Repository
public interface ProdutoReservaRepository extends JpaRepository <ProdutoReserva, Long> {
	
	List<ProdutoReserva> findAllByEstabelecimentoID(Long estabelecimentoID);
	
//	@Query(
//			value = "select * from produto p where p.id in ("
//					+ " select pr.produto_ID from produto_reserva pr where pr.reserva_ID = ?2"
//					+ " ) and p.estabelecimento_ID = ?1", 
//			  nativeQuery = true)
	List<ProdutoReserva> findByReservaID(Long reservaID);
}
