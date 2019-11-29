package com.jmtm.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
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
	
	public void actualizar(MateriaPrima materiaPrima) {
		
		if(materiaPrima.getId() == null) {
			throw new NullPointerException("El id de la materia prima es nulo");
		}
		
		repo.save(materiaPrima);
	}

	public List<MateriaPrima> buscarTodo() {

		return repo.findAll();
	}

	public List<MateriaPrima> buscarPorRuta(Integer ruta) {

		return repo.buscarPorRuta(ruta);
	}
	
	public MateriaPrima buscarPorUsuarioId(int id) {
		
		Optional<MateriaPrima> materiaPrima = repo.buscarPorUsuarioId(id);
		
		if(!materiaPrima.isPresent()) {
			throw new EntityNotFoundException("No existe el usuario con el id -> " +id);
		}
		
		return materiaPrima.get();
	}
}
