package main.java.model.entity.event;

import main.java.model.entity.character.Jogador;

public class Escolha {
    private String descricao;
    private Consequencia consequencia; // Limpo

    public Escolha(String descricao, Consequencia consequencia) {
        this.descricao = descricao;
        this.consequencia = consequencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void executar(Jogador jogador) {
        consequencia.aplicar(jogador);
    }
}