package com.example.agenda_clinica_api.agenda_clinica_api.entity;

import com.example.agenda_clinica_api.agenda_clinica_api.entity.dto.DadosCadastroConsulta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    @Enumerated(EnumType.STRING)
    private Status status;


    public Consulta(DadosCadastroConsulta dadosCadastroConsulta) {
        this.medico = new Medico();
        this.medico.setId(dadosCadastroConsulta.medicoId());
        this.cliente = new Cliente();
        this.cliente.setId(dadosCadastroConsulta.clienteId());
        this.dataHoraInicio = dadosCadastroConsulta.dataHoraInicio();
        this.dataHoraFim = dadosCadastroConsulta.dataHoraFim();
        this.status = Status.AGENDADO;
    }

    public void cancelarConsulta() {
        this.status = Status.CANCELADO;
    }




}
