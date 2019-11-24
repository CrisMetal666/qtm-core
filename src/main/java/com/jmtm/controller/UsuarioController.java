package com.jmtm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmtm.model.Usuario;
import com.jmtm.service.UsuarioService;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@PostMapping(path = "negociante")
	public void guardarNegociante(@RequestBody Usuario usuario) {

		service.guardarNegociante(usuario);
	}

	@PostMapping(path = "proovedor")
	public void crearProovedor(@RequestBody Usuario usuario) {

		service.crearProovedor(usuario);
	}

	@PutMapping(path = "proovedor")
	public void actualizarProovedor(@RequestBody Usuario usuario) {

		service.actualizarProovedor(usuario);
	}

	@GetMapping(path = "proovedor")
	public List<Usuario> buscarProovedores() {

		return service.buscarProovedores();
	}
	
	@DeleteMapping(path = "proovedor/{id}")
	public void buscarProovedores(@PathVariable Integer id) {

		service.eliminarProovedor(id);
	}
}
