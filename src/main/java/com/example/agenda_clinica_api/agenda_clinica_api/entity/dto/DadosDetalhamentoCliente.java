package com.example.agenda_clinica_api.agenda_clinica_api.entity.dto;

import com.example.agenda_clinica_api.agenda_clinica_api.entity.Cliente;

import java.time.LocalDate;

public record DadosDetalhamentoCliente(
        Long id,
        String nome,
        String email,
        String telefone,
        LocalDate dataDeNascimento,
        Boolean ativo




) {
    public DadosDetalhamentoCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getDataDeNascimento(), cliente.getAtivo());
    }
}
