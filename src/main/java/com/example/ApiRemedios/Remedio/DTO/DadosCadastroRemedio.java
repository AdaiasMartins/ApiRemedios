package com.example.ApiRemedios.Remedio.DTO;

import com.example.ApiRemedios.Remedio.Entities.Laboratorio;
import com.example.ApiRemedios.Remedio.Entities.Via;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
public record DadosCadastroRemedio(
        @NotBlank(message = "O nome não pode estar em branco.")
        @Size(max = 20, message = "O nome deve ter no máximo 20 caracteres.")
        String nome,

        @Enumerated
        Via via,

        @NotBlank(message = "O lote não pode estar em branco.")
        String lote,

        int quantidade,

        @Future(message = "A data de validade deve ser no futuro.")
        LocalDate validade,

        @Enumerated
        Laboratorio laboratorio) {
        public DadosCadastroRemedio(String nome, Via via, String lote, int quantidade, LocalDate validade, Laboratorio laboratorio) {
                this.nome = nome;
                this.via = via;
                this.lote = lote;
                this.quantidade = quantidade;
                this.validade = validade;
                this.laboratorio = laboratorio;

        }
}
