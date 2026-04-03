package main.java.model.entity.event;

import main.java.model.entity.character.Jogador;
import main.java.model.entity.character.Personagem;

public class Quest {
    private String nome;
    private Personagem origem;
    private String objetivo;
    private Recompensa recompensa;
    private boolean statusConcluida;

    public Quest(String nome, Personagem origem, String objetivo, Recompensa recompensa, Boolean statusConcluida){
        this.nome = nome;
        this.origem = origem;
        this.objetivo = objetivo;
        this.recompensa = recompensa;
        this.statusConcluida = statusConcluida;
    }

    public void iniciar(Jogador jogador){
        jogador.addQuest(this);
    }
}