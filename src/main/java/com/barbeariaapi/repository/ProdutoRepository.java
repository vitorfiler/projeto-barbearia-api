package com.barbeariaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.barbeariaapi.model.Cliente;
import com.barbeariaapi.model.Produto;
import com.barbeariaapi.model.Servico;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long> {
	
	List<Produto> findAllByEstabelecimentoID(Long id);
	
	@Query(
			value = "select * from produto p where p.id in ("
					+ " select pr.produto_ID from produto_reserva pr where pr.reserva_ID = ?2"
					+ " ) and p.estabelecimento_ID = ?1", 
			  nativeQuery = true)
	List<Produto> buscarProdutosDeUmaReserva(Long estabelecimentoID, Long reservaID);
	
	@Query(value = "SELECT * FROM produto p WHERE "
			+ " p.estabelecimento_ID = ?2 AND p.ativo = ?1", 
			nativeQuery = true)
	List<Produto> findAllByAtivo(Boolean ativo, Long estabelecimentoID);
	
	@Query(value = "select * from produto p where p.estabelecimento_ID = ?1 and p.promocional" , 
			nativeQuery = true)
	List<Produto> buscarProdutosPromocionais(Long id);
}
