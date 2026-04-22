package com.example.agenda_clinica_api.agenda_clinica_api.validador;

import com.example.agenda_clinica_api.agenda_clinica_api.ValidacaoException;
import com.example.agenda_clinica_api.agenda_clinica_api.entity.dto.DadosCadastroConsulta;
import com.example.agenda_clinica_api.agenda_clinica_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorClienteAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    ClienteRepository clienteRepository;


    @Override
    public void validar(DadosCadastroConsulta dadosCadastroConsulta) {

        var ativo = clienteRepository.existsByIdAndAtivoTrue(dadosCadastroConsulta.clienteId());

        if (!ativo) {
            throw new ValidacaoException("Cliente não encontrado ou inativo");
        }



    }
}
