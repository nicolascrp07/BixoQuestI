package main.java.model.entity.character;

import java.util.ArrayList;

import main.java.model.entity.academic.Disciplina;
import main.java.model.entity.event.Quest;
import main.java.model.entity.world.Local;

public class Jogador {
    private String nome;
    private int energia;
    private int nivelConhecimento;
    private int motivacao;
    private int saude;
    private double dinheiro;
    private double desempenhoAcademico;
    private int pontosAtividade;
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Quest> questsAtivas;
    private Local localAtual;

    public Jogador(String n, int e, int nc, int m, int s, double d, double da, int pa, Local l) {
        this.nome = n;
        this.energia = e;
        this.nivelConhecimento = nc;
        this.motivacao = m;
        this.saude = s;
        this.dinheiro = d;
        this.desempenhoAcademico = da;
        this.pontosAtividade = pa;
        this.localAtual = l;
        this.disciplinas = new ArrayList<>();
        this.questsAtivas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getNivelConhecimento() {
        return nivelConhecimento;
    }

    public void setNivelConhecimento(int nivelConhecimento) {
        this.nivelConhecimento = nivelConhecimento;
    }

    public int getMotivacao() {
        return motivacao;
    }

    public void setMotivacao(int motivacao) {
        this.motivacao = motivacao;
    }

    public int getSaude() {
        return saude;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public double getDesempenhoAcademico() {
        return desempenhoAcademico;
    }

    public void setDesempenhoAcademico(double desempenhoAcademico) {
        this.desempenhoAcademico = desempenhoAcademico;
    }

    public int getPontosAtividade() {
        return pontosAtividade;
    }

    public void setPontosAtividade(int pontosAtividade) {
        this.pontosAtividade = pontosAtividade;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public ArrayList<Quest> getQuestsAtivas() {
        return questsAtivas;
    }

    public void setQuestsAtivas(ArrayList<Quest> questsAtivas) {
        this.questsAtivas = questsAtivas;
    }

    public Local getLocalAtual() {
        return localAtual;
    }

    public void setLocalAtual(Local localAtual) {
        this.localAtual = localAtual;
    }

    public void addQuest(Quest quest) {
        this.questsAtivas.add(quest);
    }

    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }
}