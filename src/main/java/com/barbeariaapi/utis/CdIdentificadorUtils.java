package com.barbeariaapi.utis;

import java.util.UUID;

public class CdIdentificadorUtils {

	public static String gerarCodigo(){
		String codigo = UUID.randomUUID().toString();
		return codigo;
	}
}
