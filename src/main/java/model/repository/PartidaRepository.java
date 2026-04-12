package main.java.model.repository;

import main.java.model.entity.game.Partida;
import java.util.ArrayList;

// Repositório responsável por armazenar e gerenciar as partidas salvas
public class PartidaRepository {

    private ArrayList<Partida> slotsDeSave = new ArrayList<>(); // Slots de save disponíveis

    // Salva ou atualiza a partida | Substitui caso já exista um save anterior
    public Partida salvarPartida(Partida partida) {
        if (slotsDeSave.contains(partida)) {
            slotsDeSave.remove(partida);
        }
        slotsDeSave.add(partida);
        return partida;
    }

    // Retorna uma cópia da lista com todos os saves disponíveis
    public ArrayList<Partida> buscarJogosSalvos() {
        return new ArrayList<>(slotsDeSave);
    }

    // Busca uma partida salva pelo nome do jogador
    public Partida buscarPorNomeDoJogador(String nome) {
        for (Partida p : slotsDeSave) {
            if (p.getJogador() != null && p.getJogador().getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null; // Nenhuma partida encontrada
    }

    // Remove o save da lista e retorna true se a operação for realizada
    public boolean deletarSave(Partida partida) {
        return slotsDeSave.remove(partida);
    }
}