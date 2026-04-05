package main.java.model.service;

import main.java.model.entity.character.Jogador;
import main.java.model.entity.event.Quest;

import java.util.ArrayList;

public class QuestService {
    public void aceitarQuest(Jogador j, Quest q){
        if (j.getQuestsAtivas().contains(q)){
            return;
        }
        q.iniciar(j);
    }

    public void verificarAndamento(Jogador j){
        ArrayList<Quest> jq = j.getQuestsAtivas();
        for (Quest quest : jq) {
            if (!quest.isStatusConcluida()) {
                quest.setStatusConcluida(quest.checarProgresso(j));
            }
        }
    }

    public void entregarQuest(Jogador j, Quest q){
        if (q.isStatusConcluida()){
            q.getRecompensa().aplicar(j);
            j.getQuestsAtivas().remove(q);
        }
    }
}
