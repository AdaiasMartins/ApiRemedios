package com.example.ApiRemedios.Remedio.DTO;

import com.example.ApiRemedios.Remedio.Laboratorio;
import com.example.ApiRemedios.Remedio.Via;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarRemedio(
        @NotNull
        Long id,

        String nome,
        Via via,
        Laboratorio Laboratorio
) {
}
