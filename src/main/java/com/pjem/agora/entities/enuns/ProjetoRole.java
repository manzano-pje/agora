package com.pjem.agora.entities.enuns;

public enum ProjetoRole {
    ADMINISTRADOR("Administrador"),
    VOLUNTARIO("Voluntário"),
    BENEFICIARIO("Beneficiário");

    private final String descricao;

    ProjetoRole(String descricao){
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
