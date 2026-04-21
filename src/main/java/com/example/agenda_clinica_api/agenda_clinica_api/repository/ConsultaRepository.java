package com.example.agenda_clinica_api.agenda_clinica_api.repository;

import com.example.agenda_clinica_api.agenda_clinica_api.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {


    boolean existsByMedicoIdAndDataHoraInicioLessThanAndDataHoraFimGreaterThan(
            Long medicoId,
            LocalDateTime dataHoraFim,
            LocalDateTime dataHoraInicio
    );

    boolean existsByClienteIdAndDataHoraInicioLessThanAndDataHoraFimGreaterThan(
            Long clienteId,
            LocalDateTime fim,
            LocalDateTime inicio
    );
}
