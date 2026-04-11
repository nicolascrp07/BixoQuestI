package main.java.model.entity.game;

import main.java.model.entity.academic.Disciplina;
import main.java.model.entity.character.Jogador;
import main.java.model.entity.world.Universidade;
import main.java.model.entity.event.Evento;
import java.util.ArrayList;

public class Partida {
    private Jogador jogador;
    private Tempo tempo;
    private Universidade universidade;
    private boolean jogoEncerrado;
    private ArrayList<Evento> eventos;
    private ArrayList<Disciplina> gradeCompleta;

    public Partida(Jogador jogador, Tempo tempo, Universidade universidade, boolean jogoEncerrado,  ArrayList<Evento> eventos, ArrayList<Disciplina> gradeCompleta){
        this.jogador = jogador;
        this.tempo = tempo;
        this.universidade = universidade;
        this.jogoEncerrado = jogoEncerrado;
        this.eventos = eventos;
        this.gradeCompleta = gradeCompleta;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public Tempo getTempo() {
        return tempo;
    }

    public Universidade getUniversidade() {
        return universidade;
    }

    public ArrayList<Disciplina> getGradeCompleta() { return gradeCompleta; }

    public boolean isJogoEncerrado() {
        return jogoEncerrado;
    }

    public void setJogoEncerrado(boolean jogoEncerrado) {
        this.jogoEncerrado = jogoEncerrado;
    }
}