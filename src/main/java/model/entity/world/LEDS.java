package main.java.model.entity.world;

import main.java.model.entity.academic.Disciplina;
import main.java.model.entity.character.Jogador;

// Laboratório LEDS
public class LEDS extends Local {

    private Disciplina disciplinaAtual; // Disciplina lecionada no momento

    // Constrói o LEDS
    public LEDS(String nome, String descricao, Disciplina disciplinaAtual) {
        super(nome, descricao);
        this.disciplinaAtual = disciplinaAtual;
    }

    // Aumenta o conhecimento e consome energia do jogador
    private void realizarAulaPratica(Jogador jogador) {
        jogador.setNivelConhecimento(jogador.getNivelConhecimento() + 10);
        jogador.setEnergia(jogador.getEnergia() - 10);
    }

    // A ação específica do LEDS é realizar uma aula prática
    @Override
    public void acaoEspecifica(Jogador j) {
        this.realizarAulaPratica(j);
    }

    // Retorna a disciplina no LEDS
    public Disciplina getDisciplinaAtual() { return disciplinaAtual; }

    // Atualiza a disciplina do LEDS
    public void setDisciplinaAtual(Disciplina d) { this.disciplinaAtual = d; }
}