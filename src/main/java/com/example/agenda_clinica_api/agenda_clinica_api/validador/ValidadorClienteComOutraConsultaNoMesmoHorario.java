package com.example.agenda_clinica_api.agenda_clinica_api.validador;

import com.example.agenda_clinica_api.agenda_clinica_api.entity.dto.DadosCadastroConsulta;
import com.example.agenda_clinica_api.agenda_clinica_api.repository.ClienteRepository;
import com.example.agenda_clinica_api.agenda_clinica_api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorClienteComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta {

    @Autowired
    ConsultaRepository consultaRepository;


    @Override
    public void validar(DadosCadastroConsulta dadosCadastroConsulta) {
        var possuiConflitoDeHorario = consultaRepository.existsByClienteIdAndDataHoraInicioLessThanAndDataHoraFimGreaterThan(
                dadosCadastroConsulta.clienteId(),
                dadosCadastroConsulta.dataHoraFim(),
                dadosCadastroConsulta.dataHoraInicio()
        );

        if(possuiConflitoDeHorario) {
            throw new RuntimeException("Cliente já possui outra consulta agendada nesse horário");
        }




    }
}
