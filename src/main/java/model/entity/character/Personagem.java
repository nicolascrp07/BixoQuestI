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

    public Local getLocalAtual() {
        return local;
    }

    public String getDialogo(String d){
        return d;
    }

    public Quest getQuest(String n, Personagem o, String obj, Recompensa r, Boolean sc){
        return new Quest(n, o, obj, r, sc);
    }

    public abstract boolean podeAcessar(Local local);
    public abstract void interacaoEspecifica(Jogador jogador);
}