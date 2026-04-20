package com.example.agenda_clinica_api.agenda_clinica_api.controller;

import com.example.agenda_clinica_api.agenda_clinica_api.entity.Medico;
import com.example.agenda_clinica_api.agenda_clinica_api.entity.dto.DadosAtualizacaoMedico;
import com.example.agenda_clinica_api.agenda_clinica_api.entity.dto.DadosCadastroMedico;
import com.example.agenda_clinica_api.agenda_clinica_api.entity.dto.DadosDetalhamentoMedico;
import com.example.agenda_clinica_api.agenda_clinica_api.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity criarMedico(@RequestBody @Valid DadosCadastroMedico dadosCadastroMedico, UriComponentsBuilder uriComponentsBuilder) {
        var medico = new Medico(dadosCadastroMedico);
        medicoRepository.save(medico);


        var uri = uriComponentsBuilder.path("/medicos/{id}")
                .buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }


    @GetMapping
    public ResponseEntity listarMedicos() {
        var medico = medicoRepository.findAll().stream().map(DadosDetalhamentoMedico::new).toList();
        return ResponseEntity.ok(medico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarMedico(@RequestBody @Valid DadosAtualizacaoMedico dadosAtualizacaoMedico) {
        var medico = medicoRepository.getReferenceById(dadosAtualizacaoMedico.id());
        medico.atualizarInformacoes(dadosAtualizacaoMedico);
        medicoRepository.save(medico);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarMedico(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }















}
