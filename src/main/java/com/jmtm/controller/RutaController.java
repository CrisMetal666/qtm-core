package com.jmtm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmtm.model.Ruta;
import com.jmtm.service.RutaService;

@RestController
@RequestMapping("api/ruta")
public class RutaController {

	@Autowired
	private RutaService service;
	
	@PostMapping
	public void crear(@RequestBody Ruta ruta) {
		
		service.registrar(ruta);
	}
	
	@PutMapping
	public void actualizar(@RequestBody Ruta ruta) {
		
		service.actualizar(ruta);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		
		service.eliminar(id);
	}
}
