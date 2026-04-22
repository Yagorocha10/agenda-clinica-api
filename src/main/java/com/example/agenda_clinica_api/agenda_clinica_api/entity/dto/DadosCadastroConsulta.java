package com.example.agenda_clinica_api.agenda_clinica_api.entity.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroConsulta(

        @NotNull
        Long medicoId,
        @NotNull
        Long clienteId,
        @NotNull
        LocalDateTime dataHoraInicio,
        @NotNull
        LocalDateTime dataHoraFim
) {



}
