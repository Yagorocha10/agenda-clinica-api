package com.example.agenda_clinica_api.agenda_clinica_api.entity;

import com.example.agenda_clinica_api.agenda_clinica_api.entity.dto.DadosAtualizacaoCliente;
import com.example.agenda_clinica_api.agenda_clinica_api.entity.dto.DadosCadastroCliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataDeNascimento;
    private Boolean ativo;


    public Cliente(DadosCadastroCliente dadosCadastroCliente) {
        this.nome = dadosCadastroCliente.nome();
        this.email = dadosCadastroCliente.email();
        this.telefone = dadosCadastroCliente.telefone();
        this.dataDeNascimento = dadosCadastroCliente.dataDeNascimento();
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoCliente dadosAtualizacaoCliente) {
        if (dadosAtualizacaoCliente.email() != null) {
            this.email = dadosAtualizacaoCliente.email();
        }
            if (dadosAtualizacaoCliente.nome() != null) {
                this.nome = dadosAtualizacaoCliente.nome();
            }
        if (dadosAtualizacaoCliente.telefone() != null) {
            this.telefone = dadosAtualizacaoCliente.telefone();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
