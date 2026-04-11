package main.java.model.entity.event;

import main.java.model.entity.character.Jogador;
import main.java.model.entity.game.Tempo;

public class MaterialCaro extends Evento {

    public MaterialCaro() {
        super("Material Caro", "Opa! O material exigido para a aula foi cobrado! Bem caro por sinal...", 0.3);

        Consequencia cComprar = new Consequencia(0, -10, -20, 0, 0, 0);
        Escolha comprar = new Escolha("Comprar o material.", cComprar);

        Consequencia cEmprestado = new Consequencia(-10, -5, 0, -10, 0, 0);
        Escolha emprestado = new Escolha("Esperar que um colega acabe antes com o material para solicitá-lo emprestado.", cEmprestado);

        escolhas.add(comprar);
        escolhas.add(emprestado);
    }

    @Override
    public boolean podeOcorrer(Tempo tempo, Jogador jogador) {
        return Math.random() < getProbabilidadeOcorrencia();
    }
}