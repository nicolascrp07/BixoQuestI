package main.java.model.entity.event;

import main.java.model.entity.character.Jogador;
import main.java.model.entity.game.Tempo;

public class ProvaSurpresa extends Evento { // Limpo

    public ProvaSurpresa() {
        super("Prova Surpresa", "O professor resolveu aplicar uma prova hoje!", 0.3);

        // Tudo limpo aqui embaixo, sem os prefixos!
        Consequencia cEstudar = new Consequencia(-10, -5, 0, +5, 0, +10);
        Escolha estudar = new Escolha("Tentar responder com o que sabe", cEstudar);

        Consequencia cColar = new Consequencia(-5, 0, 0, 0, -10, -15);
        Escolha colar = new Escolha("Tentar colar do colega", cColar);

        Consequencia cDesistir = new Consequencia(0, -20, 0, 0, 0, -10);
        Escolha desistir = new Escolha("Entregar em branco", cDesistir);

        escolhas.add(estudar);
        escolhas.add(colar);
        escolhas.add(desistir);
    }

    @Override
    public boolean podeOcorrer(Tempo tempo, Jogador jogador) {
        boolean condicao = tempo.getSemanaAtual() != 4;
        boolean sorteio = Math.random() < getProbabilidadeOcorrencia();
        return condicao && sorteio;
    }
}