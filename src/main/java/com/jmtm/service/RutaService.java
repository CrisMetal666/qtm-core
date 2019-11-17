package com.jmtm.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmtm.exception.YaExisteEntityException;
import com.jmtm.model.Ruta;
import com.jmtm.repository.IRutaRepository;

@Service
public class RutaService {

	@Autowired
	private IRutaRepository repo;

	public void registrar(Ruta ruta) {

		if (existeRuta(ruta.getNombre())) {

			throw new YaExisteEntityException("Ya existe una ruta con el nombre -> " + ruta.getNombre());
		}

		repo.save(ruta);
	}

	public void actualizar(Ruta ruta) {

		if(ruta.getId() == null) {
			
			throw new NullPointerException("La ruta no tiene asignado el id");
		}

		repo.save(ruta);
	}

	public boolean existeRuta(String nombre) {

		Optional<Integer> ruta = repo.buscarIdPorNombre(nombre);

		return ruta.isPresent();
	}
	
	public void eliminar(Integer id) {
		
		Optional<Ruta> ruta = repo.findById(id);
		
		if(!ruta.isPresent()) {
			
			throw new EntityNotFoundException("No existe la ruta con el id -> " + id);
		}
		
		repo.deleteById(id);
	}
	
	public List<Ruta> buscarTodos() {
		
		return repo.findAll();
	}
}
