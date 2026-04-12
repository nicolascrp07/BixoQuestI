package main.java.model.entity.event;

import main.java.model.entity.character.Jogador;
import main.java.model.entity.character.Personagem;

// Quest para atingir um valor mínimo em um atributo específico
public class QuestAtributo extends Quest {

    // Constantes que identificam os atributos
    public static final String ENERGIA = "energia";
    public static final String CONHECIMENTO = "conhecimento";
    public static final String MOTIVACAO = "motivacao";

    private String atributoNecessario;  // Atributo que será verificado
    private int valorNecessario;        // Valor mínimo que o atributo precisa atingir

    // Constrói a quest
    public QuestAtributo(String nome, Personagem origem, String objetivo, Recompensa recompensa, String atributoNecessario, int valorNecessario) {
        super(nome, origem, objetivo, recompensa);
        this.atributoNecessario = atributoNecessario;
        this.valorNecessario = valorNecessario;
    }

    // Verifica se o atributo do jogador atingiu o valor necessário para concluir a quest
    @Override
    public boolean checarProgresso(Jogador jogador) {
        return switch (atributoNecessario) {
            case ENERGIA -> jogador.getEnergia() >= valorNecessario;
            case CONHECIMENTO -> jogador.getNivelConhecimento() >= valorNecessario;
            case MOTIVACAO -> jogador.getMotivacao() >= valorNecessario;
            default -> false;
        };
    }

    // Retorna o atributo
    public String getAtributoNecessario() { return atributoNecessario; }

    // Retorna o valor necessário para a conclusão
    public int getValorNecessario() { return valorNecessario; }
}