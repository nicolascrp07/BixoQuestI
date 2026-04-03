package main.java.model.entity.event;

import main.java.model.entity.character.Jogador;

public class Recompensa {
    private double dinheiro;
    private int motivacao;
    private int conhecimento;

    public Recompensa(double dinheiro, int motivacao, int conhecimento) {
        this.dinheiro = dinheiro;
        this.motivacao = motivacao;
        this.conhecimento = conhecimento;
    }

    public void aplicar(Jogador jogador) {
        jogador.setDinheiro(jogador.getDinheiro() + dinheiro);
        jogador.setMotivacao(jogador.getMotivacao() + motivacao);
        jogador.setNivelConhecimento(jogador.getNivelConhecimento() + conhecimento);
    }
}