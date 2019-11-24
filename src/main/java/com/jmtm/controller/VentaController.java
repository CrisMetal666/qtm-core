package com.jmtm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jmtm.model.Venta;
import com.jmtm.model.dto.ProovedorSemana;
import com.jmtm.service.VentaService;

@RestController
@RequestMapping("api/venta")
public class VentaController {

	@Autowired
	private VentaService service;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Venta venta) {

		service.crear(venta);
	}

	@PutMapping
	public void actualizar(@RequestBody Venta venta) {

		service.actualizar(venta);
	}

	@GetMapping(path = "proovedor/{id}")
	public List<Venta> buscarVentasProovedor(@PathVariable Integer id) {

		return service.buscarVentasProovedor(id);
	}

	@GetMapping(path = "calcular-semana")
	public List<ProovedorSemana> calcularSemana() {

		return service.calcularSemana();
	}
	
	@GetMapping(path = "venta-del-dia")
	public ProovedorSemana buscarVentasDelDia() {
		
		return service.buscarVentasDelDia();
	}
	
	@GetMapping(path = "cantidad-articulos-dia")
	public ProovedorSemana buscarCantidadArticulosVendidos() {
		
		return service.buscarCantidadArticulosVendidos();
	}
}
