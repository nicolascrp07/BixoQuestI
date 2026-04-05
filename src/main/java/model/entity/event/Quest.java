package main.java.model.entity.event;

import main.java.model.entity.character.Jogador;
import main.java.model.entity.character.Personagem;

public abstract class Quest {
    private String nome;
    private Personagem origem;
    private String objetivo;
    private Recompensa recompensa;
    private boolean statusConcluida;

    public Quest(String nome, Personagem origem, String objetivo, Recompensa recompensa) {
        this.nome = nome;
        this.origem = origem;
        this.objetivo = objetivo;
        this.recompensa = recompensa;
        this.statusConcluida = false;
    }

    public abstract boolean checarProgresso(Jogador jogador);

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