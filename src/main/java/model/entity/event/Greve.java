package main.java.model.entity.event;

import main.java.model.entity.game.Tempo;

// Evento de Greve dos Professores
public class Greve extends Evento {

    // Constrói o evento
    public Greve() {
        super("Greve", "Os professores anunciaram uma greve inesperada. As aulas foram suspensas por tempo indeterminado.", 0.15);

        // Escolha de Descansar e sua consequência
        Consequencia cFolga = new Consequencia(10, 20, -10, -15, 10, 0);
        Escolha folga = new Escolha("Aproveitar a greve e descansar.", cFolga);

        // Escolha de Estudar e sua consequência
        Consequencia cEstudar = new Consequencia(-10, 5, 10, 20, -5, 0);
        Escolha estudar = new Escolha("Estudar durante este periodo", cEstudar);

        // Escolha de Participar dos Protestos e sua consequência
        Consequencia cParticipar = new Consequencia(-15, 10, -5, 10, -15, 0);
        Escolha participar = new Escolha("Participar dos protestos estudantis.", cParticipar);

        // Adiciona escolhas na ArrayList do evento
        escolhas.add(folga);
        escolhas.add(estudar);
        escolhas.add(participar);
    }

    // O evento só pode ocorrer a partir do segundo semestre
    @Override
    public boolean condicaoOcorrencia(Tempo tempo) {
        return tempo.getSemestreAtual() >= 2;
    }

    // Verifica a condição de tempo e realiza o sorteio
    @Override
    public boolean podeOcorrer(Tempo tempo) {
        boolean sorteio = Math.random() < getProbabilidadeOcorrencia();
        return this.condicaoOcorrencia(tempo) && sorteio;
    }
}