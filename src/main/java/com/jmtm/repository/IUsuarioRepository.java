package com.jmtm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jmtm.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("select u.id from Usuario u where u.identificacion = :identificacion")
	Optional<Integer> buscarIdPorIdentificacion(@Param("identificacion") String identificacion);
	
	@Query("select u from Usuario u where u.rol.id = :rol")
	List<Usuario> buscarProovedores(@Param("rol") Integer rol);
}
