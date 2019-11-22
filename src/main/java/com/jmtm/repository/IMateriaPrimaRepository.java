package com.jmtm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jmtm.model.MateriaPrima;

public interface IMateriaPrimaRepository extends JpaRepository<MateriaPrima, Integer> {
	
	@Query("select mp from MateriaPrima mp where mp.ruta.id = :ruta")
	List<MateriaPrima> buscarPorRuta(@Param("ruta") Integer ruta);
}
