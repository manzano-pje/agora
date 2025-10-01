package com.pjem.agora.entities;

import com.pjem.agora.entities.enuns.ProjetoRole;
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
@Table
public class MembrosProjetos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMembrosProjetos;
    private LocalDate DataEntrada;
    private LocalDate DataSaida;
    private ProjetoRole projetosRole;

    @ManyToOne
    @JoinColumn(name = "id_associados")
    private Associados associados;

    @ManyToOne
    @JoinColumn(name = "id_gestao")
    private Gestao gestao;
}
