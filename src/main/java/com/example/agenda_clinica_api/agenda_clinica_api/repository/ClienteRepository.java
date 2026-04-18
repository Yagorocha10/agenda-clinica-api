package com.example.agenda_clinica_api.agenda_clinica_api.repository;

import com.example.agenda_clinica_api.agenda_clinica_api.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
