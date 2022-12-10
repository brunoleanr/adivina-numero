package com.jona;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.jona.entity.Usuario;
import com.jona.repository.UsuarioRepository;

@ApplicationScoped
public class UsuarioEjb {

	@Inject
	private UsuarioRepository usuarioRepository;

	public Usuario getUsuario() {
		Optional<Usuario> usuarios = usuarioRepository.findById(1L);
		if (usuarios.isPresent()) {
			return usuarios.get();
		}
		return null;

	}

}
