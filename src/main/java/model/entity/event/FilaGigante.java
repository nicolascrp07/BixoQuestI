package main.java.model.entity.event;

import main.java.model.entity.character.Jogador;
import main.java.model.entity.game.Tempo;

public class FilaGigante extends Evento {

    public FilaGigante() {
        super("Fila Gigante", "A fila lotou! Está enorme...", 0.3);

        Consequencia cDesistir = new Consequencia(0, -20, 0, 0, -10, 0);
        Escolha desistir = new Escolha("Não enfrentar a fila e desistir.", cDesistir);

        Consequencia cEnfrentar = new Consequencia(-15, -10, 0, 0, +5, 0);
        Escolha enfrentar = new Escolha("Ir com tudo e garantir o lanche!", cEnfrentar);

        escolhas.add(enfrentar);
        escolhas.add(desistir);
    }

    @Override
    public boolean podeOcorrer(Tempo tempo, Jogador jogador) {
        boolean condicao = tempo.getSemanaAtual() == 1;
        boolean sorteio = Math.random() < getProbabilidadeOcorrencia();
        return condicao && sorteio;
    }
}