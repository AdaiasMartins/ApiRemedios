package com.example.ApiRemedios.Controllers;


import com.example.ApiRemedios.Remedio.*;
import com.example.ApiRemedios.Remedio.DTO.DadosAtualizarRemedio;
import com.example.ApiRemedios.Remedio.DTO.DadosCadastroRemedio;
import com.example.ApiRemedios.Remedio.DTO.DadosListagemRemedios;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemediosRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroRemedio dados) {
        repository.save(new Remedio(dados));
    }

    @GetMapping
    public List<DadosListagemRemedios> listar() {
        return repository.findAllByAtivoTrue().stream().map(DadosListagemRemedios::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarRemedio dados){
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInfomacao(dados);
    }

    @PutMapping("/{id}")
    public void reativar(@PathVariable Long id){
        var remedio = repository.getReferenceById(id);
        remedio.reativar();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public void inativar(@PathVariable Long id){
        var remedio = repository.getReferenceById(id);
        remedio.inativar();
    }

}
