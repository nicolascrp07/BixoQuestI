package main.java.model.entity.character;

import main.java.model.entity.event.Quest;
import main.java.model.entity.event.Recompensa;
import main.java.model.entity.world.Local;
import java.util.ArrayList;

public abstract class Personagem {
    protected String nome;
    protected Local local;
    protected ArrayList<Quest> questsDisponiveis;

    public Personagem(String nome, Local local) {
        this.nome = nome;
        this.local = local;
        this.questsDisponiveis = new ArrayList<>();
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public abstract String getDialogo(String dialogo);
    public abstract Quest getQuest(String nome, Personagem origem, String objetivo, Recompensa recompensa, Boolean statusConcluida);
}