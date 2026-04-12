package main.java.model.entity.event;

import main.java.model.entity.game.Tempo;

// Evento de Prova Surpresa
public class ProvaSurpresa extends Evento {

    // Constrói o evento
    public ProvaSurpresa() {
        super("Prova Surpresa", "O professor resolveu aplicar uma prova hoje!", 0.3);

        // Escolha de Responder e sua consequência
        Consequencia cEstudar = new Consequencia(-10, -5, 0, +5, 0, +10);
        Escolha estudar = new Escolha("Tentar responder com o que sabe", cEstudar);

        // Escolha de Colar e sua consequência
        Consequencia cColar = new Consequencia(-5, 0, 0, 0, -10, -15);
        Escolha colar = new Escolha("Tentar colar do colega", cColar);

        // Escolha de Entregar em Branco e sua consequência
        Consequencia cDesistir = new Consequencia(0, -20, 0, 0, 0, -10);
        Escolha desistir = new Escolha("Entregar em branco", cDesistir);

        // Adiciona escolhas na ArrayList do evento
        escolhas.add(estudar);
        escolhas.add(colar);
        escolhas.add(desistir);
    }

    // O evento não pode ocorrer na semana de provas
    @Override
    public boolean condicaoOcorrencia(Tempo tempo) {
        return tempo.getSemanaAtual() != 4;
    }

    // Verifica a condição de tempo e realiza o sorteio
    @Override
    public boolean podeOcorrer(Tempo tempo) {
        boolean sorteio = Math.random() < getProbabilidadeOcorrencia();
        return this.condicaoOcorrencia(tempo) && sorteio;
    }
}