package main.java.model.entity.game;

import main.java.model.entity.character.Jogador;
import main.java.model.entity.world.Universidade;
import main.java.model.entity.event.Evento;
import java.util.ArrayList;

public class Partida {
    private Jogador jogador;
    private Tempo tempo;
    private Universidade universidade;
    private boolean jogoEncerrado;
    private ArrayList<Evento> eventos; // Limpo!

    public Partida(Jogador jogador, Tempo tempo, Universidade universidade, boolean jogoEncerrado){
        this.jogador = jogador;
        this.tempo = tempo;
        this.universidade = universidade;
        this.jogoEncerrado = jogoEncerrado;
        this.eventos = new ArrayList<>();
    }

    public void aplicarEvento() {
        for (Evento e : eventos) { // Limpo!
            if (e.podeOcorrer(tempo, jogador)) {
                int indice = (int) (Math.random() * e.getEscolhas().size());
                e.getEscolhas().get(indice).executar(jogador);
            }
        }
    }
}