package com.example.ApiRemedios.Remedio.Services;

import com.example.ApiRemedios.Remedio.DTO.DadosCadastroRemedio;
import com.example.ApiRemedios.Remedio.DTO.DadosListagemRemedios;
import com.example.ApiRemedios.Remedio.Entities.Laboratorio;
import com.example.ApiRemedios.Remedio.Entities.Remedio;
import com.example.ApiRemedios.Remedio.Entities.Via;
import com.example.ApiRemedios.Remedio.Repository.RemediosRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ServicesRemedioTest {

    @InjectMocks
    private ServicesRemedio servicesRemedio;
    @Mock
    private RemediosRepository remediosRepository;
    @Mock
    private DadosCadastroRemedio dadosCadastroRemedio;

    @Test
    @DisplayName("Deve retornar uma lista com apenas um remedio")
    public void deveRetornarUmaListaDeRemedios(){
        Remedio remedio = new Remedio(new DadosCadastroRemedio("dipirona", Via.ORAL, "loteexemplo", 10, LocalDate.of(2025, 6,20), Laboratorio.MEDLEY));
        Mockito.when(remediosRepository.findAllByAtivoTrue()).thenReturn(Collections.singletonList(remedio));
        List<DadosListagemRemedios> remedios = servicesRemedio.listar();
        System.out.println(remedios);

        Assertions.assertEquals(1, remedios.size());

    }

}