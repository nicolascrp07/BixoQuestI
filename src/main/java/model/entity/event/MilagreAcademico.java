package main.java.model.entity.event;

import main.java.model.entity.character.Jogador;
import main.java.model.entity.game.Tempo;

public class MilagreAcademico extends Evento {

    public MilagreAcademico() {
        super("Milagre Acadêmico", "Mesmo sem estar preparado, sua nota foi surpreendentemente alta.", 0.2);

        Consequencia cAceitar = new Consequencia(+10, +10, 0, 0, 0, 0);
        Escolha aceitar = new Escolha("Aceitar o resultado e seguir em frente.", cAceitar);

        Consequencia cQuestionar = new Consequencia(-10, -15, 0, +10, -5, 0);
        Escolha questionar = new Escolha("Questionar o professor sobre a nota.", cQuestionar);

        escolhas.add(aceitar);
        escolhas.add(questionar);
    }

    @Override
    public boolean podeOcorrer(Tempo tempo, Jogador jogador) {
        boolean condicao = tempo.getSemanaAtual() == 4;
        boolean sorteio = Math.random() < getProbabilidadeOcorrencia();
        return condicao && sorteio;
    }
}