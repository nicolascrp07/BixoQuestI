package main.java.model.service;

import main.java.model.entity.academic.Disciplina;
import main.java.model.entity.character.*;
import main.java.model.entity.game.Tempo;
import main.java.model.entity.world.*;

import java.util.ArrayList;

public class ExplorarService {
    private QuestService questService;

    public ExplorarService(AcademicoService ac, QuestService qs) {
        this.questService = qs;
    }

    public boolean podeTransitar(Jogador j, Local l){
        if (j.getLocalAtual() instanceof Universidade || l instanceof Universidade){
            return true;
        }
        return false;
    }

    public void moverPara(Jogador j, Local l) {
        l.interagir(j);
        questService.verificarAndamento(j);
    }

    public boolean executarAcao(Jogador j, Local l) {
        l.acaoEspecifica(j);
        questService.verificarAndamento(j);
        return l instanceof PontoDeOnibus;
    }

    public void interacaoNPC (Jogador j, Personagem npc){
        if (j.getLocalAtual() == npc.getLocalAtual()){
            npc.interacaoEspecifica(j);
        }
    }

    public void atualizarSalas(ArrayList<Disciplina> aprovadas, Universidade uni, ArrayList<Disciplina> grade) {
        for (Disciplina aprovada : aprovadas) {
            Disciplina proxima = null;
            for (Disciplina d : grade) {
                if (aprovada.equals(d.getPreRequisito())) {
                    proxima = d;
                    break;
                }
            }
            if (proxima != null) {
                for (Local l : uni.getLocais()) {
                    if (l instanceof Sala s && s.getDisciplinaAtual().equals(aprovada)) {
                        s.setDisciplinaAtual(proxima);
                    } else if (l instanceof LEDS le && le.getDisciplinaAtual().equals(aprovada)) {
                        le.setDisciplinaAtual(proxima);
                    }
                }
            }
        }
    }

    public void atualizarLocal(Universidade uni) {
        ArrayList<Personagem> ps = uni.getPersonagens();
        ArrayList<Local> lu = uni.getLocais();

        for (Personagem p : ps) {

            if (p instanceof Professor) {
                continue;
            }

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
