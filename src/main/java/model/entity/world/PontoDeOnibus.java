package main.java.model.entity.world;

import main.java.model.entity.game.Tempo;
import main.java.model.entity.character.Jogador;

public class PontoDeOnibus extends Local {
    private String linha;

    public PontoDeOnibus(String nome, String descricao, String linha){
        super(nome, descricao);
        this.linha = linha;
    }

    private void pegarOnibus(Jogador jogador){
        jogador.setEnergia(100);
    }

    @Override
    public void acaoEspecifica(Jogador j){
        this.pegarOnibus(j);
    }
}