package main.java.model.entity.academic;

import main.java.model.entity.event.Consequencia;
import main.java.model.entity.character.Jogador;

public class Avaliacao {
    private String nome;
    private Disciplina disciplina; // Correção: não precisa do caminho completo
    private int dificuldade;
    private double nota;
    private double resultado;

    public Avaliacao(String nome, Disciplina disciplina, int dificuldade, double nota, double resultado){
        this.nome = nome;
        this.disciplina = disciplina;
        this.dificuldade = dificuldade;
        this.nota = nota;
        this.resultado = resultado;
    }

    public double getNota(){
        return nota;
    }

    public double aplicarAvaliacao(Jogador jogador) {
        return Math.max(0, 10 - (jogador.getNivelConhecimento() * resultado));
    }

    public void calcularDificuldade(Jogador jogador){
        if (jogador.getNivelConhecimento() <= 30){
            this.dificuldade = 3;
        } else if (jogador.getNivelConhecimento() <= 70){
            this.dificuldade = 2;
        } else {
            this.dificuldade = 1;
        }
    }

    public void calcularImpacto(Jogador jogador){
        if (dificuldade == 3){
            Consequencia impacto3 = new Consequencia(-15, -10, 0, 0, -15, 0);
            impacto3.aplicar(jogador);
        } else if (dificuldade == 2){
            Consequencia impacto2 = new Consequencia(-10, -5, 0, 0, -5, 0);
            impacto2.aplicar(jogador);
        } else {
            Consequencia impacto1 = new Consequencia(-5, 0, 0, 10, 0, 1);
            impacto1.aplicar(jogador);
        }
    }
}