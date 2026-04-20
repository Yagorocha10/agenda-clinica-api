package com.example.agenda_clinica_api.agenda_clinica_api.entity.dto;

import com.example.agenda_clinica_api.agenda_clinica_api.entity.Especialidade;
import com.example.agenda_clinica_api.agenda_clinica_api.entity.Medico;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        Especialidade especialidade
) {

}
