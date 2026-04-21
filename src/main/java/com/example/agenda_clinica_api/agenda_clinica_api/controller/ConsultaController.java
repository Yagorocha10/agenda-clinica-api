package com.example.agenda_clinica_api.agenda_clinica_api.controller;

import com.example.agenda_clinica_api.agenda_clinica_api.entity.Consulta;
import com.example.agenda_clinica_api.agenda_clinica_api.entity.dto.DadosCadastroConsulta;
import com.example.agenda_clinica_api.agenda_clinica_api.entity.dto.DadosDetalhamentoConsulta;
import com.example.agenda_clinica_api.agenda_clinica_api.repository.ConsultaRepository;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    ConsultaRepository consultaRepository;


    @PostMapping
    @Transactional
    public ResponseEntity agendarConsulta(@RequestBody @Valid DadosCadastroConsulta dadosCadastroConsulta, UriComponentsBuilder uriComponentsBuilder) {
        var consulta = new Consulta(dadosCadastroConsulta);
        consultaRepository.save(consulta);

        var uri = uriComponentsBuilder.path("/consultas/{id}")
                .buildAndExpand(consulta.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoConsulta(consulta));
    }


    @GetMapping
    public ResponseEntity listarConsultas() {
        var consulta = consultaRepository.findAll().stream().map(DadosDetalhamentoConsulta::new).toList();
        return ResponseEntity.ok(consulta);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity cancelarConsulta(@PathVariable Long id) {
        var consulta = consultaRepository.getReferenceById(id);
        consulta.cancelarConsulta();
        return ResponseEntity.noContent().build();
    }




}
