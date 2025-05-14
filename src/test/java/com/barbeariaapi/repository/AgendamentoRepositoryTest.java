//package com.barbeariaapi.repository;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import com.barbeariaapi.MockUtils;
//import com.barbeariaapi.model.Agendamento;
//import com.barbeariaapi.model.Estabelecimento;
//
//@DataJpaTest
//@ActiveProfiles("test")
//public class AgendamentoRepositoryTest {
//
//	@Autowired
//	EntityManager entityManager;
//	
//	@Autowired
//	AgendamentoRepository agendamentoRepository;
//	
//	@Mock
//	MockUtils mockUtils;
//	
//	@Test
//	@DisplayName("should get Agendamento successfully from DB")
//	void findAllByEstabelecimentoIDOrderByDtAtendimentoDescSuccess() {
//		Estabelecimento estabelecimento = this.createEstabelecimento(MockUtils.gerarEstabelecimento());
//		System.out.println("########################## " + estabelecimento.getId() + " ##########################");
//		this.createAgendamento(MockUtils.gerarAgendamento());
//		
//		
//		List<Agendamento> agendamentos = this.agendamentoRepository
//				.findAllByEstabelecimentoIDOrderByDtAtendimentoDesc(estabelecimento.getId());
//		
//		assertThat(!agendamentos.isEmpty()).isTrue();
//	}
//	
//	private Agendamento createAgendamento(Agendamento agendamento) {
//		Agendamento newAgendamento = new Agendamento(agendamento);
//		this.entityManager.persist(newAgendamento);
//		return newAgendamento;
//	}
//	
//	private Estabelecimento createEstabelecimento(Estabelecimento data) {
//		Estabelecimento newEstabelecimento = new Estabelecimento(data);
//		this.entityManager.persist(newEstabelecimento);
//		return newEstabelecimento;
//	}
//
//}
