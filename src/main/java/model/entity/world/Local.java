package main.java.model.entity.world;

import main.java.model.entity.character.Jogador;

public abstract class Local {
    protected String nome;
    protected String descricao;

    public Local(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }

    public void interagir(Jogador jogador) {
        jogador.setEnergia(jogador.getEnergia() - 5);
        jogador.setLocalAtual(this);
    }

    public abstract void acaoEspecifica(Jogador jogador);
}