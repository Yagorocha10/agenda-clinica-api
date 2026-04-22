package com.example.agenda_clinica_api.agenda_clinica_api.validador;

import com.example.agenda_clinica_api.agenda_clinica_api.ValidacaoException;
import com.example.agenda_clinica_api.agenda_clinica_api.entity.dto.DadosCadastroConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;


@Component
public class ValidadorHorarioFuncionamentoDaClinica implements ValidadorAgendamentoDeConsulta{
    @Override
    public void validar(DadosCadastroConsulta dadosCadastroConsulta) {

        var dataHora = dadosCadastroConsulta.dataHoraInicio();
        var domingo = dataHora.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var dataAntesDaAberturaDaClinica = dataHora.getHour() < 7;
        var dataDepoisDoEncerramentoDaClinica = dataHora.getHour() > 18;


        if (domingo || dataAntesDaAberturaDaClinica || dataDepoisDoEncerramentoDaClinica) {
            throw new ValidacaoException("Consulta fora do horário do funcionamento da clinica");
        }





    }
}
