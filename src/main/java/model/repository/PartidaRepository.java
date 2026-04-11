package main.java.model.repository;

import main.java.model.entity.game.Partida;
import java.util.ArrayList;

public class PartidaRepository {

    private ArrayList<Partida> slotsDeSave = new ArrayList<>();

    public Partida salvarPartida(Partida partida) {
        if (slotsDeSave.contains(partida)) {
            slotsDeSave.remove(partida);
        }
        slotsDeSave.add(partida);
        return partida;
    }

    public ArrayList<Partida> buscarJogosSalvos() {
        return new ArrayList<>(slotsDeSave);
    }

    public Partida buscarPorNomeDoJogador(String nome) {
        for (Partida p : slotsDeSave) {
            if (p.getJogador() != null && p.getJogador().getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public boolean deletarSave(Partida partida) {
        return slotsDeSave.remove(partida);
    }
}