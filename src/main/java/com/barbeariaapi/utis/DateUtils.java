package com.barbeariaapi.utis;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	public static Boolean validarDuasDatas(String data1, String data2) {
		DateTimeFormatter parse = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		try {			
			LocalDateTime dateTime1 = LocalDate.parse(data1, parse).atStartOfDay();
			LocalDateTime dateTime2 = LocalDate.parse(data1, parse).atStartOfDay();
			if(dateTime1.isBefore(dateTime2)) {
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public static String diaDeHoje() {
		LocalDateTime hoje = LocalDateTime.now();
		String dia = "";
		String mes = "";
		if(hoje.getDayOfMonth() < 10) {
			dia = "0" + hoje.getDayOfMonth();
			if(hoje.getMonthValue() < 10) {
				mes = "0" + hoje.getMonthValue();
			}
		}
		return hoje.getYear()+ "-" + mes + "-" + dia;
	}
}
