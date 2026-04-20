package com.example.agenda_clinica_api.agenda_clinica_api.entity;

import com.example.agenda_clinica_api.agenda_clinica_api.entity.dto.DadosAtualizacaoMedico;
import com.example.agenda_clinica_api.agenda_clinica_api.entity.dto.DadosCadastroMedico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;


    public Medico(DadosCadastroMedico dadosCadastroMedico) {
        this.nome = dadosCadastroMedico.nome();
        this.email = dadosCadastroMedico.email();
        this.telefone = dadosCadastroMedico.telefone();
        this.crm = dadosCadastroMedico.crm();
        this.especialidade = dadosCadastroMedico.especialidade();
        this.ativo = true;
    }


    public void atualizarInformacoes(DadosAtualizacaoMedico dadosAtualizacaoMedico) {
        if (this.nome != null) {
            nome = dadosAtualizacaoMedico.nome();
        }

        if (this.email != null) {
            email = dadosAtualizacaoMedico.email();
        }

        if (this.telefone != null) {
            telefone = dadosAtualizacaoMedico.telefone();
        }

        if (this.especialidade != null) {
            especialidade = dadosAtualizacaoMedico.especialidade();
        }


    }

    public void excluir() {
        this.ativo = false;
    }
}
