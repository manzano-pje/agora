package com.pjem.agora.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_Gestao")
public class Gestao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGestao;
    private LocalDate inicioGestao;
    private LocalDate fimGestao;
    private boolean ativo;
}
