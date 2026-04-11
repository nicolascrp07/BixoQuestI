package main.java.model.entity.academic;

import main.java.model.entity.event.Consequencia;
import main.java.model.entity.character.Jogador;

public class Avaliacao {
    private String nome;
    private int dificuldade;
    private double nota;

    public Avaliacao(String nome, int dificuldade, double nota){
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.nota = nota;
    }

    public double getNota(){
        return nota;
    }

    public int getDificuldade(){
        return dificuldade;
    }

    public void setNota(double notaDoMinigame) {
        this.nota = notaDoMinigame;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }
}