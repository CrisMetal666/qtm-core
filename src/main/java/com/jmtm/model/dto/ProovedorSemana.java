package com.jmtm.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProovedorSemana {

	private String proovedorNombre;
	private String intervaloTiempo;
	private int totalDinero;
	private String materiaPrima;
	
	public ProovedorSemana(String proovedorNombre, String intervaloTiempo, int totalDinero, String materiaPrima) {
		this.proovedorNombre = proovedorNombre;
		this.intervaloTiempo = intervaloTiempo;
		this.totalDinero = totalDinero;
		this.materiaPrima = materiaPrima;
	}
	
	
}
