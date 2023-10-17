package com.AtividadeNovo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.AtividadeNovo.controller.PathVariable;
import com.AtividadeNovo.entities.Usuario;
import com.AtividadeNovo.repository.UsuarioRepository;

import jakarta.validation.Valid;

@Service
public class UsuarioService {
	private UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	public List<Usuario> buscaTodosUsuarios(){
		return usuarioRepository.findAll();
	}
	public Usuario buscaUsuarioId(Long id) {
		Optional <Usuario> Usuario = usuarioRepository.findById(id);
		return Usuario.orElse(null);
	}
	public Usuario salvaUsuario(@RequestBody @Valid Usuario Usuario) {
		return usuarioRepository.save(Usuario);
	}
	public Usuario alterarUsuario(@org.springframework.web.bind.annotation.PathVariable Long id,@RequestBody @Valid Usuario alterarU) {
		Optional <Usuario> existeUsuario = usuarioRepository.findById(id);
		if (existeUsuario.isPresent()) {
			alterarU.setId(id);
			return usuarioRepository.save(alterarU);
		}
		return null;
	}
	public boolean apagarUsuario(Long Id) {
		Optional <Usuario> existeUsuario = usuarioRepository.findById(Id);
		if (existeUsuario.isPresent()) {
			usuarioRepository.deleteById(Id);
			return true;
		}
		return false;
	}
}
