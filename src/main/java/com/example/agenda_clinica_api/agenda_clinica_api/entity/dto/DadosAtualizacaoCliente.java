package com.example.agenda_clinica_api.agenda_clinica_api.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone

) {
}
