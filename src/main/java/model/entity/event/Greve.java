package main.java.model.entity.event;

import main.java.model.entity.character.Jogador;
import main.java.model.entity.game.Tempo;

public class Greve extends Evento {

    public Greve() {
        super("Greve", "Os professores anunciaram uma greve inesperada. As aulas foram suspensas por tempo indeterminado.", 0.15);

        Consequencia cFolga = new Consequencia(10, 20, -10, -15, 10, 0);
        Escolha folga = new Escolha("Aproveitar a greve e descansar.", cFolga);

        Consequencia cEstudar = new Consequencia(-10, 5, 10, 20, -5, 0);
        Escolha estudar = new Escolha("Estudar durante este periodo", cEstudar);

        Consequencia cParticipar = new Consequencia(-15, 10, -5, 10, -15, 0);
        Escolha participar = new Escolha("Participar dos protestos estudantis.", cParticipar);

        escolhas.add(folga);
        escolhas.add(estudar);
        escolhas.add(participar);
    }

    @Override
    public boolean condicaoOcorrencia(Tempo tempo) {
        return tempo.getSemestreAtual() >= 2;
    }

    @Override
    public boolean podeOcorrer(Tempo tempo) {
        boolean sorteio = Math.random() < getProbabilidadeOcorrencia();
        return this.condicaoOcorrencia(tempo) && sorteio;
    }
}