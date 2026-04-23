package com.example.agenda_clinica_api.agenda_clinica_api.repository;

import com.example.agenda_clinica_api.agenda_clinica_api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByLogin(String login);

}
