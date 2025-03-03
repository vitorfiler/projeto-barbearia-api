package com.barbeariaapi;
import com.barbeariaapi.model.Agendamento;
import com.barbeariaapi.model.Estabelecimento;

public class MockUtils {
	
	public static Agendamento gerarAgendamento() {
		return new Agendamento(1L, "", "corte", "Junio", 50L, 60.0, "2024-04-02", "15:00", "Vítor", "ACEITO", 1L, 1L);
	}
	
	public static Estabelecimento gerarEstabelecimento() {
		return new Estabelecimento(1L, null, "Vítor Nunes Macêdo", "Barbearia do Vitin", "teste@gmail.com", "99999999901", 
				"12345", false, true, null, null, null, null, "48999999999", "48999999999", null, null, null);
	}

}
