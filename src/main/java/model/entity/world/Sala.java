package main.java.model.entity.world;

import main.java.model.entity.academic.Disciplina;
import main.java.model.entity.character.Jogador;

public class Sala extends Local {
    private Disciplina disciplinaAtual;

    public Sala(String nome, String descricao, Disciplina disciplinaAtual){
        super(nome, descricao);
        this.disciplinaAtual = disciplinaAtual;
    }

    private void assistirAulaTeorica(Jogador jogador) {
        jogador.setNivelConhecimento(jogador.getNivelConhecimento() + 10);
        jogador.setEnergia(jogador.getEnergia() - 10);
    }

    @Override
    public void acaoEspecifica(Jogador j){
        this.assistirAulaTeorica(j);
    }
}