package com.example.ApiRemedios.Remedio.DTO;

import com.example.ApiRemedios.Remedio.Entidades.Laboratorio;
import com.example.ApiRemedios.Remedio.Entidades.Via;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarRemedio(
        @NotNull
        Long id,

        String nome,
        Via via,
        Laboratorio Laboratorio
) {
}
