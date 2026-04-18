package com.example.agenda_clinica_api.agenda_clinica_api.controller;

import com.example.agenda_clinica_api.agenda_clinica_api.entity.Cliente;
import com.example.agenda_clinica_api.agenda_clinica_api.entity.dto.DadosAtualizacaoCliente;
import com.example.agenda_clinica_api.agenda_clinica_api.entity.dto.DadosCadastroCliente;
import com.example.agenda_clinica_api.agenda_clinica_api.entity.dto.DadosDetalhamentoCliente;
import com.example.agenda_clinica_api.agenda_clinica_api.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarCliente(@RequestBody @Valid DadosCadastroCliente dadosCadastroCliente, UriComponentsBuilder uriComponentsBuilder) {
        Cliente cliente = new Cliente(dadosCadastroCliente);
        clienteRepository.save(cliente);


        var uri = uriComponentsBuilder.path("/clientes/{id}")
                .buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));
    }

   @GetMapping
    public ResponseEntity listarClientes() {
        var clientes = clienteRepository.findAll().stream().map(DadosDetalhamentoCliente::new).toList();
        return ResponseEntity.ok(clientes);
   }

   @PutMapping
   @Transactional
   public ResponseEntity atualizarCliente(@RequestBody @Valid DadosAtualizacaoCliente dadosAtualizacaoCliente) {
        var cliente = clienteRepository.getReferenceById(dadosAtualizacaoCliente.id());
        cliente.atualizarInformacoes(dadosAtualizacaoCliente);
        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirCliente(@PathVariable Long id) {
        var cliente = clienteRepository.getReferenceById(id);
        cliente.excluir();
        return ResponseEntity.noContent().build();
    }







}

