package com.jmtm;

import java.time.LocalDate;

public class TestWithMainMethod {

	public static void main(String[] args) {
		
		LocalDate fecha = LocalDate.of(2019,11,18);
		
		// 1 = monday, 7 = saturday
		System.out.println(fecha.getDayOfWeek().getValue());
		
		int diaActual = fecha.getDayOfWeek().getValue();
		
		LocalDate fechaLunes = fecha.plusDays(1-diaActual);
		
		System.out.println(fechaLunes.getDayOfWeek().getValue());

	}

}
