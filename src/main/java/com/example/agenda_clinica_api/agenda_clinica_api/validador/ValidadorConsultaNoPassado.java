package com.example.agenda_clinica_api.agenda_clinica_api.validador;

import com.example.agenda_clinica_api.agenda_clinica_api.entity.dto.DadosCadastroConsulta;
import com.example.agenda_clinica_api.agenda_clinica_api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class ValidadorConsultaNoPassado implements ValidadorAgendamentoDeConsulta{


    @Override
    public void validar(DadosCadastroConsulta dadosCadastroConsulta) {
        var dataAgora = LocalDateTime.now();

        if(dadosCadastroConsulta.dataHoraInicio().isBefore(dataAgora)) {
            throw new RuntimeException("Não é permitido agendar consultas para datas e horários passados");
        }




    }
}
