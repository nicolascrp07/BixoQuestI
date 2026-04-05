package main.java.model.service;

import main.java.model.entity.character.Jogador;
import main.java.model.entity.event.Escolha;
import main.java.model.entity.event.Evento;
import main.java.model.entity.game.Tempo;
import java.util.ArrayList;

public class EventoService {
    public Evento gerarEvento(ArrayList<Evento> eventosTotais, Tempo tempo, Jogador jogador) {
        for (Evento e : eventosTotais) {
            if (e.podeOcorrer(tempo, jogador)) {
                if (Math.random() <= e.getProbabilidadeOcorrencia()) {
                    return e;
                }
            }
        }
        return null;
    }

    public void processarEscolha(Jogador jogador, Escolha escolhaClicada) {
        escolhaClicada.executar(jogador);
    }
}