package com.example.agenda_clinica_api.agenda_clinica_api.validador;

import com.example.agenda_clinica_api.agenda_clinica_api.ValidacaoException;
import com.example.agenda_clinica_api.agenda_clinica_api.entity.dto.DadosCadastroConsulta;
import com.example.agenda_clinica_api.agenda_clinica_api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta{

    @Autowired
    MedicoRepository medicoRepository;


    @Override
    public void validar(DadosCadastroConsulta dadosCadastroConsulta) {

        var ativo = medicoRepository.existsByIdAndAtivoTrue(dadosCadastroConsulta.medicoId());

        if(!ativo) {
            throw new ValidacaoException("Médico não encontrado ou inativo");
        }



    }
}
