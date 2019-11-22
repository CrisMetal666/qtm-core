package com.jmtm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jmtm.exception.YaExisteEntityException;
import com.jmtm.model.Rol;
import com.jmtm.model.Usuario;
import com.jmtm.repository.IUsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioRepository repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public void guardarNegociante(Usuario usuario) {

		if (existeUsuario(usuario.getIdentificacion())) {

			throw new YaExisteEntityException(
					"Ya existe un usuario registrado con la identificación -> " + usuario.getIdentificacion());
		}

		usuario.setClave(encoder.encode(usuario.getClave()));
		usuario.setRol(new Rol(Rol.ROLE_NEGOCIANTE));

		repo.save(usuario);
	}
	
	public void crearProovedor(Usuario usuario) {

		if (existeUsuario(usuario.getIdentificacion())) {

			throw new YaExisteEntityException(
					"Ya existe un usuario registrado con la identificación -> " + usuario.getIdentificacion());
		}

		usuario.setClave(encoder.encode(usuario.getClave()));
		usuario.setRol(new Rol(Rol.ROLE_PROOVEDOR));

		repo.save(usuario);
	}
	
	public void actualizarProovedor(Usuario usuario) {
		
		if(usuario.getId() == null) {
			throw new NullPointerException("El id del usuario esta nulo");
		}
		
		repo.save(usuario);
	}

	public boolean existeUsuario(String indentificacion) {

		Optional<Integer> id = repo.buscarIdPorIdentificacion(indentificacion);

		return id.isPresent();
	}
	
	public List<Usuario> buscarProovedores() {
		
		return repo.buscarProovedores(Rol.ROLE_PROOVEDOR);
	}
}
