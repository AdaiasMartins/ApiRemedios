package com.example.ApiRemedios.Controllers;


import com.example.ApiRemedios.Remedio.DadosCadastroRemedio;
import com.example.ApiRemedios.Remedio.Remedio;
import com.example.ApiRemedios.Remedio.RemediosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemediosRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroRemedio dados){
        repository.save(new Remedio(dados));
    }
}
