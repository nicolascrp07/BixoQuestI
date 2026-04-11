package main.java.model.entity.event;

import main.java.model.entity.character.Jogador;
import main.java.model.entity.character.Personagem;

public class QuestAtributo extends Quest {
    public static final String ENERGIA = "energia";
    public static final String CONHECIMENTO = "conhecimento";
    public static final String MOTIVACAO = "motivacao";

    private String atributoNecessario;
    private int valorNecessario;

    public QuestAtributo(String nome, Personagem origem, String objetivo, Recompensa recompensa, String atributoNecessario, int valorNecessario) {
        super(nome, origem, objetivo, recompensa);
        this.atributoNecessario = atributoNecessario;
        this.valorNecessario = valorNecessario;
    }

    @Override
    public boolean checarProgresso(Jogador jogador) {
        return switch (atributoNecessario) {
            case ENERGIA -> jogador.getEnergia() >= valorNecessario;
            case CONHECIMENTO -> jogador.getNivelConhecimento() >= valorNecessario;
            case MOTIVACAO -> jogador.getMotivacao() >= valorNecessario;
            default -> false;
        };
    }

    public String getAtributoNecessario() { return atributoNecessario; }
    public int getValorNecessario() { return valorNecessario; }
}