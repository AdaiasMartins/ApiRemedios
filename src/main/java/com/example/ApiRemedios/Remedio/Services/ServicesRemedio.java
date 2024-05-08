package com.example.ApiRemedios.Remedio.Services;

import com.example.ApiRemedios.Remedio.DTO.DadosAtualizarRemedio;
import com.example.ApiRemedios.Remedio.DTO.DadosCadastroRemedio;
import com.example.ApiRemedios.Remedio.DTO.DadosDetalhamentoRemedio;
import com.example.ApiRemedios.Remedio.DTO.DadosListagemRemedios;
import com.example.ApiRemedios.Remedio.Entities.Remedio;
import com.example.ApiRemedios.Remedio.Repository.RemediosRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class ServicesRemedio {

    @Autowired
    private final RemediosRepository repository;

    public ServicesRemedio(RemediosRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public Remedio cadastrar(@RequestBody @Valid DadosCadastroRemedio dados) {
        Remedio remedio = new Remedio(dados);
        return repository.save(remedio);
    }

    public List<DadosListagemRemedios>listar() {
        return repository.findAllByAtivoTrue().stream().map(DadosListagemRemedios::new).toList();
    }

    public DadosDetalhamentoRemedio atualizar(@RequestBody @Valid DadosAtualizarRemedio dados) {
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInfomacao(dados);

        return new DadosDetalhamentoRemedio(remedio);
    }

    public void reativar(@PathVariable Long id){
        var remedio = repository.getReferenceById(id);
        remedio.reativar();
    }

    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

    public void inativar(@PathVariable Long id){
        var remedio = repository.getReferenceById(id);
        remedio.inativar();
    }
}