package com.example.ApiRemedios.Controllers;


import com.example.ApiRemedios.Remedio.DadosCadastroRemedio;
import com.example.ApiRemedios.Remedio.DadosListagemRemedios;
import com.example.ApiRemedios.Remedio.Remedio;
import com.example.ApiRemedios.Remedio.RemediosRepository;
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
    public void cadastrar(@RequestBody @Valid DadosCadastroRemedio dados){
        repository.save(new Remedio(dados));
    }

    @GetMapping
    public List<DadosListagemRemedios> listar(){
        return repository.findAll().stream().map(DadosListagemRemedios:: new).toList();
    }
}
