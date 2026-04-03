package main.java.model.entity.character;

import main.java.model.entity.event.Quest;
import main.java.model.entity.event.Recompensa;
import main.java.model.entity.world.Local;

public class Professor extends Personagem {
    public Professor (String nome, Local local){
        super(nome, local);
    }

    @Override
    public String getDialogo(String d){
        return d;
    }

    @Override
    public Quest getQuest(String n, Personagem o, String obj, Recompensa r, Boolean sc){
        return new Quest(n, o, obj, r, sc);
    }
}