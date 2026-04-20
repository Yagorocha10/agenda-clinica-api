package com.example.agenda_clinica_api.agenda_clinica_api.entity.dto;

import com.example.agenda_clinica_api.agenda_clinica_api.entity.Especialidade;
import com.example.agenda_clinica_api.agenda_clinica_api.entity.Medico;

public record DadosDetalhamentoMedico(

        Long id,
        String nome,
        String email,
        String telefone,
        String crm,
        Boolean ativo,
        Especialidade especialidade

) {
    public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getTelefone(), medico.getEmail(), medico.getCrm(), medico.getAtivo(), medico.getEspecialidade());
    }
}
