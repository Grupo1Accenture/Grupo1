package com.accenture.academy.entity;

public enum UF { // ainda vo criar

	PE("Pernambuco"),
    REC("Recife");

    private final String descricao;

    UF(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
