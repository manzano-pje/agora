package com.pjem.agora.entities.enuns;

public enum DiretoriaRole {
    PRESIDENTE("Presidente"),
    VICE_PRESIDENTE("Vice Presidente"),
    SECRETARIO("Secretário"),
    Tesoureiro("Tesoureiro"),
    CONSELHEIRO_FISCAL("Conselheiro Fiscal");


    private final String descricao;

    DiretoriaRole(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}