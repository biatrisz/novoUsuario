package com.AtividadeNovo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AtividadeNovo.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
