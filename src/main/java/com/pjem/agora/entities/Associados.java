package com.pjem.agora.entities;

import io.swagger.v3.oas.annotations.callbacks.Callback;
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
@Table(name = "tb_Associados")
public class Associados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAssociados;
    private String nome;
    private String rg;
    private String cpf;
    private LocalDate dataNascimento;
    private String Telefone;
    private String email;
    private String endereco;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private boolean ativo;
}
