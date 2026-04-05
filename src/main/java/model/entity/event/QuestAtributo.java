package main.java.model.entity.event;

import main.java.model.entity.character.Jogador;
import main.java.model.entity.character.Personagem;

public class QuestAtributo extends Quest {
    private String atributoNecessario;
    private int valorNecessario;

    public QuestAtributo(String nome, Personagem origem, String objetivo, Recompensa recompensa, String atributoNecessario, int valorNecessario) {
        super(nome, origem, objetivo, recompensa);
        this.atributoNecessario = atributoNecessario;
        this.valorNecessario = valorNecessario;
    }

    @Override
    public boolean checarProgresso(Jogador jogador) {
        return false;
    }

    public String getAtributoNecessario() { return atributoNecessario; }
    public int getValorNecessario() { return valorNecessario; }
}