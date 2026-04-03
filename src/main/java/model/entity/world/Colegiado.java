package main.java.model.entity.world;

import main.java.model.entity.game.Tempo;
import main.java.model.entity.character.Jogador;

public class Colegiado extends Local {
    private boolean aberto;

    public Colegiado(String nome, String descricao){
        super(nome, descricao);
    }

    @Override
    public void interagir(Jogador jogador) {
        jogador.setEnergia(jogador.getEnergia() - 5);
        jogador.setLocalAtual(this);
    }

    public void pedirAjudaMaeli(Jogador jogador, Tempo tempo){
        jogador.setEnergia(jogador.getEnergia() + 15);
        jogador.setMotivacao(jogador.getMotivacao() + 30);
        jogador.setNivelConhecimento(jogador.getNivelConhecimento() + 5);
    }
}