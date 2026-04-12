package main.java.model.entity.event;

import main.java.model.entity.character.Jogador;
import main.java.model.entity.character.Personagem;
import main.java.model.entity.world.Local;

public class QuestVisita extends Quest {
    private Local localDestino;

    public QuestVisita(String nome, Personagem origem, String objetivo, Recompensa recompensa, Local localDestino) {
        super(nome, origem, objetivo, recompensa);
        this.localDestino = localDestino;
    }

    @Override
    public boolean checarProgresso(Jogador jogador) {
        if (jogador.getLocalAtual() == null) {
            return false;
        }
        return jogador.getLocalAtual().equals(localDestino);
    }

    public Local getLocalDestino() {
        return localDestino;
    }
}