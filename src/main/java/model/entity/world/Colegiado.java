package main.java.model.entity.world;

import main.java.model.entity.character.Jogador;

public class Colegiado extends Local {
    private boolean aberto;

    public Colegiado(String nome, String descricao){
        super(nome, descricao);
    }

    private void pedirAjudaMaeli(Jogador jogador){
        if (this.aberto) {
            jogador.setEnergia(jogador.getEnergia() + 15);
            jogador.setMotivacao(jogador.getMotivacao() + 30);
            jogador.setNivelConhecimento(jogador.getNivelConhecimento() + 5);
        }
    }

    @Override
    public void acaoEspecifica(Jogador j){
        this.pedirAjudaMaeli(j);
    }
}