package com.jmtm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(path = "buscar-todo")
	public List<MateriaPrima> buscarTodo() {
		
		return service.buscarTodo();
	}
	
	@GetMapping(path = "ruta/{ruta}")
	public List<MateriaPrima> buscarPorRuta(@PathVariable Integer ruta) {
		
		return service.buscarPorRuta(ruta);
	}
}
