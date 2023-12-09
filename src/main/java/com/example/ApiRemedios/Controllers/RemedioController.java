package com.example.ApiRemedios.Controllers;


import com.example.ApiRemedios.Remedio.DTO.DadosAtualizarRemedio;
import com.example.ApiRemedios.Remedio.DTO.DadosCadastroRemedio;
import com.example.ApiRemedios.Remedio.DTO.DadosDetalhamentoRemedio;
import com.example.ApiRemedios.Remedio.DTO.DadosListagemRemedios;
import com.example.ApiRemedios.Remedio.Entidades.Remedio;
import com.example.ApiRemedios.Remedio.Repositorios.RemediosRepository;
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

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid DadosCadastroRemedio dados) {
        repository.save(new Remedio(dados));

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemRemedios>> listar() {
        var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemRemedios::new).toList();

        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> atualizar(@RequestBody @Valid DadosAtualizarRemedio dados){
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInfomacao(dados);

        return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> reativar(@PathVariable Long id){
        var remedio = repository.getReferenceById(id);
        remedio.reativar();

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable Long id){
        var remedio = repository.getReferenceById(id);
        remedio.inativar();

        return ResponseEntity.noContent().build();
    }

}
