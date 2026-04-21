package com.example.agenda_clinica_api.agenda_clinica_api.entity.dto;

import com.example.agenda_clinica_api.agenda_clinica_api.entity.Consulta;
import com.example.agenda_clinica_api.agenda_clinica_api.entity.Medico;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(

        Long id,
        Long medicoId,
        Long clienteId,
        LocalDateTime dataHoraInicio,
        LocalDateTime dataHoraFim,
        String status



) {
    public DadosDetalhamentoConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getCliente().getId(),
                consulta.getDataHoraInicio(), consulta.getDataHoraFim(), consulta.getStatus().name());
    }
}
