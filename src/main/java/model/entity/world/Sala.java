package main.java.model.entity.world;

import main.java.model.entity.academic.Disciplina;
import main.java.model.entity.character.Jogador;

// Sala de aula
public class Sala extends Local {

    private Disciplina disciplinaAtual; // Disciplina lecionada no momento

    // Constrói a sala
    public Sala(String nome, String descricao, Disciplina disciplinaAtual) {
        super(nome, descricao);
        this.disciplinaAtual = disciplinaAtual;
    }

    // Aumenta o conhecimento e consome energia do jogador
    private void assistirAulaTeorica(Jogador jogador) {
        jogador.setNivelConhecimento(jogador.getNivelConhecimento() + 10);
        jogador.setEnergia(jogador.getEnergia() - 10);
    }

    // A ação específica da sala é assistir uma aula teórica
    @Override
    public void acaoEspecifica(Jogador j) {
        this.assistirAulaTeorica(j);
    }

    // Retorna a disciplina na sala
    public Disciplina getDisciplinaAtual() { return disciplinaAtual; }

    // Atualiza a disciplina da sala
    public void setDisciplinaAtual(Disciplina d) { this.disciplinaAtual = d; }
}