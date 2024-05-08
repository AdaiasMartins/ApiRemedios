package com.example.ApiRemedios.Controllers;


import com.example.ApiRemedios.Remedio.DTO.DadosAtualizarRemedio;
import com.example.ApiRemedios.Remedio.DTO.DadosCadastroRemedio;
import com.example.ApiRemedios.Remedio.DTO.DadosDetalhamentoRemedio;
import com.example.ApiRemedios.Remedio.DTO.DadosListagemRemedios;
import com.example.ApiRemedios.Remedio.Entities.Remedio;
import com.example.ApiRemedios.Remedio.Repository.RemediosRepository;
import com.example.ApiRemedios.Remedio.Services.ServicesRemedio;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemediosRepository repository;

    private ServicesRemedio services;

    @PostMapping
    @Transactional
    public ResponseEntity<Remedio> cadastrar(@RequestBody @Valid DadosCadastroRemedio dados) {
        return ResponseEntity.ok(services.cadastrar(dados));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemRemedios>> listar() {
        return ResponseEntity.ok(services.listar());
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> atualizar(@RequestBody @Valid DadosAtualizarRemedio dados){
        return ResponseEntity.ok(services.atualizar(dados));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> reativar(@PathVariable Long id){
        services.reativar(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        services.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable Long id){
        services.inativar(id);
        return ResponseEntity.noContent().build();
    }

}
