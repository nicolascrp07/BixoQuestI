package main.java.model.entity.world;

import main.java.model.entity.academic.Disciplina;
import main.java.model.entity.character.Jogador;

public class Sala extends Local {
    private Disciplina disciplinaAtual;

    public Sala(String nome, String descricao, Disciplina disciplinaAtual){
        super(nome, descricao);
        this.disciplinaAtual = disciplinaAtual;
    }

    @Override
    public void interagir(Jogador jogador) {
        jogador.setEnergia(jogador.getEnergia() - 5);
        jogador.setLocalAtual(this);
    }

    public void assistirAulaTeorica(Jogador jogador) {
        jogador.setNivelConhecimento(jogador.getNivelConhecimento() + 10);
        jogador.setEnergia(jogador.getEnergia() - 10);
    }
}