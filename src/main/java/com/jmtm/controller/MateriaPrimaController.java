package com.jmtm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmtm.model.MateriaPrima;
import com.jmtm.service.MateriaPrimaService;

@RestController
@RequestMapping("api/materia-prima")
public class MateriaPrimaController {

	@Autowired
	private MateriaPrimaService service;
	
	@PostMapping
	public void guardar(@RequestBody MateriaPrima materiaPrima) {
		
		service.guardar(materiaPrima);
	}
}
