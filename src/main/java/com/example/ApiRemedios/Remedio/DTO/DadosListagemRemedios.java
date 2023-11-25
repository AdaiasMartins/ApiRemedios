package com.example.ApiRemedios.Remedio.DTO;

import com.example.ApiRemedios.Remedio.Laboratorio;
import com.example.ApiRemedios.Remedio.Remedio;
import com.example.ApiRemedios.Remedio.Via;

import java.time.LocalDate;

public record DadosListagemRemedios(Long id, String nome, Via via, String lote, Laboratorio laboratorio, LocalDate validade) {

    public DadosListagemRemedios(Remedio remedio){
        this(remedio.getId(),remedio.getNome(), remedio.getVia(), remedio.getLote(), remedio.getLaboratorio(), remedio.getValidade());
    }
}
