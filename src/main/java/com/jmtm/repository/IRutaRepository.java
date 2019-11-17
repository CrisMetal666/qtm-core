package com.jmtm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jmtm.model.Ruta;

public interface IRutaRepository extends JpaRepository<Ruta, Integer> {

	@Query("select r.id from Ruta r where r.nombre = :nombre")
	Optional<Integer> buscarIdPorNombre(@Param("nombre") String nombre);
}
