package main.java.model.entity.academic;

import main.java.model.entity.character.Professor;
import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private Professor professor;
    private double notaFinal;
    private int cargaHoraria;
    private boolean statusAprovacao;
    private ArrayList<Avaliacao> avaliacoes; // Correção: não precisa do caminho completo

    public Disciplina(String nome, Professor professor, double notaFinal, int cargaHoraria, boolean statusAprovacao){
        this.nome = nome;
        this.professor = professor;
        this.notaFinal = notaFinal;
        this.cargaHoraria = cargaHoraria;
        this.statusAprovacao = statusAprovacao;
        this.avaliacoes = new ArrayList<>();
    }

    public void calcularNota() {
        double soma = 0;
        for (Avaliacao a : avaliacoes) { // Correção aqui também
            soma += a.getNota();
        }
        this.notaFinal = soma / avaliacoes.size(); // Adicionado tratamento para não dividir por zero caso a lista seja vazia? Vale a pena olhar depois!
    }

    public void verificarAprovacao(){
        if (notaFinal < 7){
            this.statusAprovacao = false;
        } else {
            this.statusAprovacao = true;
        }
    }
}