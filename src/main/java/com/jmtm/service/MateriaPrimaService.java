package com.jmtm.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmtm.model.MateriaPrima;
import com.jmtm.repository.IMateriaPrimaRepository;

@Service
public class MateriaPrimaService {

	@Autowired
	private IMateriaPrimaRepository repo;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Transactional
	public void guardar(MateriaPrima materiaPrima) {
		
		usuarioService.crearProovedor(materiaPrima.getUsuario());
		
		repo.save(materiaPrima);
	}
}
