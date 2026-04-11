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
    private ArrayList<Disciplina> historicoAprovadas;
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
        this.historicoAprovadas = new ArrayList<>();
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
        this.energia = Math.clamp(energia, 0, 100);
    }

    public int getNivelConhecimento() {
        return nivelConhecimento;
    }

    public void setNivelConhecimento(int nivelConhecimento) {
        this.nivelConhecimento = Math.clamp(nivelConhecimento, 0, 100);
    }

    public int getMotivacao() {
        return motivacao;
    }

    public void setMotivacao(int motivacao) {
        this.motivacao = Math.clamp(motivacao, 0, 100);
    }

    public int getSaude() {
        return saude;
    }

    public void setSaude(int saude) {
        this.saude = Math.clamp(saude, 0, 100);
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = Math.max(0.0, dinheiro);
    }

    public double getDesempenhoAcademico() {
        return desempenhoAcademico;
    }

    public void setDesempenhoAcademico(double desempenhoAcademico) {
        this.desempenhoAcademico = Math.clamp(desempenhoAcademico, 0, 10);
    }

    public int getPontosAtividade() {
        return pontosAtividade;
    }

    public void setPontosAtividade(int pontosAtividade) {
        this.pontosAtividade = Math.clamp(pontosAtividade, 0, 100);
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public ArrayList<Disciplina> getHistoricoAprovadas() {
        return historicoAprovadas;
    }

    public void setHistoricoAprovadas(ArrayList<Disciplina> historicoAprovadas) {
        this.historicoAprovadas = historicoAprovadas;
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

    public void removeDisciplina(Disciplina disciplina) {
        this.disciplinas.remove(disciplina);
    }

    public void addDisciplinaHistorico(Disciplina disciplina) {
        this.historicoAprovadas.add(disciplina);
    }
}