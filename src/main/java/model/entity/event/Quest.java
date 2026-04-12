package main.java.model.entity.event;

import main.java.model.entity.character.Jogador;
import main.java.model.entity.character.Personagem;

// Classe abstrata para todas as quests no jogo
public abstract class Quest {

    private String nome;                // Nome da quest
    private Personagem origem;          // Personagem que ofereceu a quest
    private String objetivo;            // Descrição do que o jogador precisa fazer
    private Recompensa recompensa;      // Recompensa ao concluir a quest
    private boolean statusConcluida;    // Indica se a quest já foi concluída

    // Constrói a quest
    public Quest(String nome, Personagem origem, String objetivo, Recompensa recompensa) {
        this.nome = nome;
        this.origem = origem;
        this.objetivo = objetivo;
        this.recompensa = recompensa;
        this.statusConcluida = false;
    }

    // Define como cada quest verifica se o jogador atingiu seu objetivo
    public abstract boolean checarProgresso(Jogador jogador);

    // Adiciona esta quest à lista de quests ativas do jogador
    public void iniciar(Jogador jogador) {
        jogador.addQuest(this);
    }

    public String getNome() { return nome; }
    public Personagem getOrigem() { return origem; }
    public String getObjetivo() { return objetivo; }
    public Recompensa getRecompensa() { return recompensa; }
    public boolean isStatusConcluida() { return statusConcluida; }
    public void setStatusConcluida(boolean statusConcluida) { this.statusConcluida = statusConcluida; }
}