package main.java.model.entity.academic;

import main.java.model.entity.character.Professor;
import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private String area;
    private Professor professor;
    private Disciplina preRequisito;
    private double notaFinal;
    private int cargaHoraria;
    private boolean statusAprovacao;
    private ArrayList<Avaliacao> avaliacoes; // Correção: não precisa do caminho completo

    public Disciplina(String nome, String area, Professor professor, Disciplina preRequisito, double notaFinal, int cargaHoraria, boolean statusAprovacao){
        this.nome = nome;
        this.area = area;
        this.professor = professor;
        this.preRequisito = preRequisito;
        this.notaFinal = notaFinal;
        this.cargaHoraria = cargaHoraria;
        this.statusAprovacao = statusAprovacao;
        this.avaliacoes = new ArrayList<>();
    }

    public boolean getStatusAprovacao(){
        return statusAprovacao;
    }

    public void calcularNota() {
        double soma = 0;
        for (Avaliacao a : avaliacoes) {
            soma += a.getNota();
        }
        this.notaFinal = soma / avaliacoes.size();
    }

    public void verificarAprovacao(){
        if (notaFinal < 7){
            this.statusAprovacao = false;
        } else {
            this.statusAprovacao = true;
        }
    }

    public void limparAvaliacao(){
        this.avaliacoes.clear();
    }

    public void addAvaliacao (Avaliacao a){
        this.avaliacoes.add(a);
    }

    public double getNotaFinal(){
        return notaFinal;
    }

    public String getArea(){
        return area;
    }

    public Disciplina getPreRequisito(){
        return preRequisito;
    }

}