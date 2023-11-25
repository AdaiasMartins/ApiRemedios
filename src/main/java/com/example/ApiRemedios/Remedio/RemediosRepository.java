package com.example.ApiRemedios.Remedio;

import com.example.ApiRemedios.Remedio.DTO.DadosListagemRemedios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface RemediosRepository extends JpaRepository<Remedio, Long> {

    List<Remedio> findAllByAtivoTrue();
}
