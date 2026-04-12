package main.java.model.entity.event;

import main.java.model.entity.character.Jogador;

// Recompensas concedidas ao jogador ao concluir uma quest
public class Recompensa {

    private double dinheiro;    // Valor em dinheiro obtido
    private int motivacao;      // Bônus de motivação obtido
    private int conhecimento;   // Bônus de conhecimento obtido

    // Constrói a recompensa
    public Recompensa(double dinheiro, int motivacao, int conhecimento) {
        this.dinheiro = dinheiro;
        this.motivacao = motivacao;
        this.conhecimento = conhecimento;
    }

    // Aplica todos os benefícios da recompensa no jogador
    public void aplicar(Jogador jogador) {
        jogador.setDinheiro(jogador.getDinheiro() + dinheiro);
        jogador.setMotivacao(jogador.getMotivacao() + motivacao);
        jogador.setNivelConhecimento(jogador.getNivelConhecimento() + conhecimento);
    }
}