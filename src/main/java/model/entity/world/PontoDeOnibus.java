package main.java.model.entity.world;

import main.java.model.entity.game.Tempo;
import main.java.model.entity.character.Jogador;

public class PontoDeOnibus extends Local {
    private String linha;

    public PontoDeOnibus(String nome, String descricao, String linha){
        super(nome, descricao);
        this.linha = linha;
    }

    @Override
    public void interagir(Jogador jogador) {
        jogador.setEnergia(jogador.getEnergia() - 5);
        jogador.setLocalAtual(this);
    }

    public void pegarOnibus(Jogador jogador, Tempo tempo){
        jogador.setEnergia(100);
        tempo.avancarSemana();
    }
}