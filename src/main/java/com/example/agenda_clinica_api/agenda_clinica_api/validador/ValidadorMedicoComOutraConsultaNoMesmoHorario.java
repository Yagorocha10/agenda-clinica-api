package com.example.agenda_clinica_api.agenda_clinica_api.validador;

import com.example.agenda_clinica_api.agenda_clinica_api.entity.dto.DadosCadastroConsulta;
import com.example.agenda_clinica_api.agenda_clinica_api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta{

    @Autowired
    ConsultaRepository consultaRepository;


    @Override
    public void validar(DadosCadastroConsulta dadosCadastroConsulta) {
        var possuiConflitoDeHorario = consultaRepository.existsByMedicoIdAndDataHoraInicioLessThanAndDataHoraFimGreaterThan(
                dadosCadastroConsulta.medicoId(),
                dadosCadastroConsulta.dataHoraFim(),
                dadosCadastroConsulta.dataHoraInicio()
        );

        if (possuiConflitoDeHorario) {
            throw new RuntimeException("Médico já possui outra consulta agendada nesse horário");
        }



    }
}
