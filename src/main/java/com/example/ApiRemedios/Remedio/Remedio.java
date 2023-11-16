package com.example.ApiRemedios.Remedio;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Remedio")
@Table(name = "Remedios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedio {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private Via via;
    private String lote;
    private String quantidade;
    private String validade;
    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;
}
