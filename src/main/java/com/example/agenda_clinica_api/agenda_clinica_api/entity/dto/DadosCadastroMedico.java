package com.example.agenda_clinica_api.agenda_clinica_api.entity.dto;

import com.example.agenda_clinica_api.agenda_clinica_api.entity.Especialidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroMedico(

        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        String crm,
        @NotNull
        Especialidade especialidade


) {
}
