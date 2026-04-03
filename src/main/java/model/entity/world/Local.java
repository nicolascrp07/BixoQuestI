package main.java.model.entity.world;

import main.java.model.entity.character.Jogador;

public abstract class Local {
    protected String nome;
    protected String descricao;

    public Local(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }
    public abstract void interagir(Jogador jogador);
}