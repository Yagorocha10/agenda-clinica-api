package com.example.agenda_clinica_api.agenda_clinica_api.entity.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record DadosCadastroCliente(

        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,

        @NotNull
        @Past
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        LocalDate dataDeNascimento


) {
}
