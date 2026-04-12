package main.java.model.service;

import main.java.model.entity.character.Jogador;
import main.java.model.entity.event.Escolha;
import main.java.model.entity.event.Evento;
import main.java.model.entity.game.Tempo;
import java.util.ArrayList;

// Service responsável por gerar e processar os eventos durante a partida
public class EventoService {

    // Percorre os eventos disponíveis e retorna o primeiro que passar nas condições de ocorrência (tempo e sorteio)
    public Evento gerarEvento(ArrayList<Evento> eventosTotais, Tempo tempo) {
        for (Evento e : eventosTotais) {
            if (e.podeOcorrer(tempo)) {
                if (Math.random() <= e.getProbabilidadeOcorrencia()) {
                    return e;
                }
            }
        }
        return null; // Nenhum evento ocorreu neste turno
    }

    // Executa a escolha selecionada pelo jogador, aplicando suas consequências
    public void processarEscolha(Jogador jogador, Escolha escolhaClicada) {
        escolhaClicada.executar(jogador);
    }
}