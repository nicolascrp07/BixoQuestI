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
    private Avaliacao avaliacao;

    public Disciplina(String nome, String area, Professor professor, Disciplina preRequisito, double notaFinal, int cargaHoraria, boolean statusAprovacao, Avaliacao avaliacao){
        this.nome = nome;
        this.area = area;
        this.professor = professor;
        this.preRequisito = preRequisito;
        this.notaFinal = notaFinal;
        this.cargaHoraria = cargaHoraria;
        this.statusAprovacao = statusAprovacao;
        this.avaliacao = avaliacao;
    }

    public boolean getStatusAprovacao(){
        return statusAprovacao;
    }

    public void verificarAprovacao(){
        if (notaFinal < 7){
            this.statusAprovacao = false;
        } else {
            this.statusAprovacao = true;
        }
    }

    public void setNotaFinal(double nota){
        this.notaFinal = nota;
    }

    public double getNotaFinal(){
        return notaFinal;
    }

    public String getArea(){
        return area;
    }

    public String getNome(){
        return nome;
    }

    public Disciplina getPreRequisito(){
        return preRequisito;
    }

    public Professor getProfessor(){
        return professor;
    }

}