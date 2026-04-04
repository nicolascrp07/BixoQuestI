package main.java.model.service;

import main.java.model.entity.character.Jogador;
import main.java.model.entity.character.Personagem;
import main.java.model.entity.world.Local;
import main.java.model.entity.world.Universidade;

import java.util.ArrayList;

public class ExplorarService {
    public boolean podeTransitar(Jogador j, Local l){
        if (j.getLocalAtual() instanceof Universidade || l instanceof Universidade){
            return true;
        }
        return false;
    }

    public void interacaoAmbiente(Jogador j, Local l){
        l.interagir(j);
        l.acaoEspecifica(j);
    }

    public void interacaoNPC (Jogador j, Personagem npc){
        if (j.getLocalAtual() == npc.getLocalAtual()){
            npc.interacaoEspecifica(j);
        }
    }

    public void atualizarLocal(Universidade uni) {
        ArrayList<Personagem> ps = uni.getPersonagens();
        ArrayList<Local> lu = uni.getLocais();

        for (Personagem p : ps) {
            boolean encontrouLocalValido = false;
            while (!encontrouLocalValido) {
                int indice = (int) (Math.random() * lu.size());
                Local localSorteado = lu.get(indice);

                if (p.podeAcessar(localSorteado)) {
                    p.setLocal(localSorteado);
                    encontrouLocalValido = true;
                }
            }
        }
    }
}
