package com.jmtm.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jmtm.model.Venta;

public interface IVentaRepository extends JpaRepository<Venta, Integer> {

	@Query("select v from Venta v where v.usuario.id = :id order by v.fecha desc")
	List<Venta> buscarVentasProovedor(@Param("id") Integer proovedorId);
	
	@Query("select distinct v.usuario.id from Venta v where v.fecha between :lunes and :fechaActual")
	List<Integer> buscarProovedoresConVentaSemana(@Param("lunes") LocalDate lunes,
			@Param("fechaActual") LocalDate fechaActual);

	@Query("select v from Venta v where v.usuario.id = :id and v.fecha between :lunes and :fechaActual")
	List<Venta> buscarVentaProovedorSemana(@Param("id") Integer proovedorId, @Param("lunes") LocalDate lunes,
			@Param("fechaActual") LocalDate fechaActual);
	
	
	
	@Query("select v from Venta v where v.fecha = :dia")
	List<Venta> buscarVentasDelDia(@Param("dia") LocalDate dia);
}
