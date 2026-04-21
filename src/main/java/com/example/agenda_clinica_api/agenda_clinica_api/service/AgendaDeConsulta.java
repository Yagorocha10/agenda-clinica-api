package com.example.agenda_clinica_api.agenda_clinica_api.service;


import com.example.agenda_clinica_api.agenda_clinica_api.entity.Consulta;
import com.example.agenda_clinica_api.agenda_clinica_api.entity.Status;
import com.example.agenda_clinica_api.agenda_clinica_api.entity.dto.DadosCadastroConsulta;
import com.example.agenda_clinica_api.agenda_clinica_api.entity.dto.DadosDetalhamentoConsulta;
import com.example.agenda_clinica_api.agenda_clinica_api.repository.ClienteRepository;
import com.example.agenda_clinica_api.agenda_clinica_api.repository.ConsultaRepository;
import com.example.agenda_clinica_api.agenda_clinica_api.repository.MedicoRepository;
import com.example.agenda_clinica_api.agenda_clinica_api.validador.ValidadorAgendamentoDeConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsulta {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    List<ValidadorAgendamentoDeConsulta> validadores;


    public DadosDetalhamentoConsulta agendarConsulta(DadosCadastroConsulta dadosCadastroConsulta) {


        if (!clienteRepository.existsById(dadosCadastroConsulta.clienteId())) {
            throw new RuntimeException("Id do cliente informado não existe!!");
        }

        if (!medicoRepository.existsById(dadosCadastroConsulta.medicoId())) {
            throw new RuntimeException("Id do médico informado não existe!!");
        }

        validadores.forEach(v -> v.validar(dadosCadastroConsulta));


        var medico = medicoRepository.getReferenceById(dadosCadastroConsulta.medicoId());
        var cliente = clienteRepository.getReferenceById(dadosCadastroConsulta.clienteId());
        var dataHoraInicio = dadosCadastroConsulta.dataHoraInicio();
        var dataHoraFim  = dadosCadastroConsulta.dataHoraFim();



        var consulta = new Consulta(null, medico, cliente, dataHoraInicio, dataHoraFim, Status.AGENDADO);
        consultaRepository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);
    }










}
