package com.pjem.agora.entities;

import com.pjem.agora.entities.enuns.DiretoriaRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_Membros_DIretoria")
public class MembrosDiretoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMembrosDiretoria;
    private DiretoriaRole diretoriaRole;

    @ManyToOne
    @JoinColumn(name = "id_associados")
    private Associados associados;

    @ManyToOne
    @JoinColumn(name = "id_gestao")
    private Gestao gestao;
}
