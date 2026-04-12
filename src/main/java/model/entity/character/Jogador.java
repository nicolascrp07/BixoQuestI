package main.java.model.entity.character;

import java.util.ArrayList;

import main.java.model.entity.academic.Disciplina;
import main.java.model.entity.event.Quest;
import main.java.model.entity.world.Local;

// Representa o jogador e todos os seus atributos durante a partida
public class Jogador {

    private String nome;
    private int energia;                            // Nível de energia (0 a 100)
    private int nivelConhecimento;                  // Conhecimento acumulado (0 a 100)
    private int motivacao;                          // Motivação atual (0 a 100)
    private int saude;                              // Saúde do jogador (0 a 100)
    private double dinheiro;                        // Saldo disponível
    private double desempenhoAcademico;             // Score acadêmico (0 a 10)
    private ArrayList<Disciplina> disciplinas;      // Disciplinas cursando atualmente
    private ArrayList<Disciplina> historicoAprovadas; // Disciplinas aprovadas
    private ArrayList<Quest> questsAtivas;          // Quests em andamento
    private Local localAtual;                       // Local onde o jogador se encontra

    // Constrói o jogador com todos os atributos iniciais da partida
    public Jogador(String n, int e, int nc, int m, int s, double d, double da, Local l) {
        this.nome = n;
        this.energia = e;
        this.nivelConhecimento = nc;
        this.motivacao = m;
        this.saude = s;
        this.dinheiro = d;
        this.desempenhoAcademico = da;
        this.localAtual = l;
        this.disciplinas = new ArrayList<>();
        this.historicoAprovadas = new ArrayList<>();
        this.questsAtivas = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getEnergia() { return energia; }
    // Mantém a energia dentro dos limites permitidos
    public void setEnergia(int energia) { this.energia = Math.clamp(energia, 0, 100); }

    public int getNivelConhecimento() { return nivelConhecimento; }
    // Mantém o conhecimento dentro dos limites permitidos
    public void setNivelConhecimento(int nivelConhecimento) { this.nivelConhecimento = Math.clamp(nivelConhecimento, 0, 100); }

    public int getMotivacao() { return motivacao; }
    // Mantém a motivação dentro dos limites permitidos
    public void setMotivacao(int motivacao) { this.motivacao = Math.clamp(motivacao, 0, 100); }

    public int getSaude() { return saude; }
    // Mantém a saúde dentro dos limites permitidos
    public void setSaude(int saude) { this.saude = Math.clamp(saude, 0, 100); }

    public double getDinheiro() { return dinheiro; }
    // Garante que o saldo nunca fique negativo
    public void setDinheiro(double dinheiro) { this.dinheiro = Math.max(0.0, dinheiro); }

    public double getDesempenhoAcademico() { return desempenhoAcademico; }
    // Mantém o desempenho acadêmico dentro dos limites permitidos
    public void setDesempenhoAcademico(double desempenhoAcademico) { this.desempenhoAcademico = Math.clamp(desempenhoAcademico, 0, 10); }

    public ArrayList<Disciplina> getDisciplinas() { return disciplinas; }
    public void setDisciplinas(ArrayList<Disciplina> disciplinas) { this.disciplinas = disciplinas; }

    public ArrayList<Disciplina> getHistoricoAprovadas() { return historicoAprovadas; }
    public void setHistoricoAprovadas(ArrayList<Disciplina> historicoAprovadas) { this.historicoAprovadas = historicoAprovadas; }

    public ArrayList<Quest> getQuestsAtivas() { return questsAtivas; }
    public void setQuestsAtivas(ArrayList<Quest> questsAtivas) { this.questsAtivas = questsAtivas; }

    public Local getLocalAtual() { return localAtual; }
    public void setLocalAtual(Local localAtual) { this.localAtual = localAtual; }

    // Adiciona uma nova quest à lista de quests ativas
    public void addQuest(Quest quest) { this.questsAtivas.add(quest); }

    // Matricula o jogador em uma nova disciplina
    public void addDisciplina(Disciplina disciplina) { this.disciplinas.add(disciplina); }

    // Remove uma disciplina da grade atual do jogador
    public void removeDisciplina(Disciplina disciplina) { this.disciplinas.remove(disciplina); }

    // Registra uma disciplina aprovada no histórico do jogador
    public void addDisciplinaHistorico(Disciplina disciplina) { this.historicoAprovadas.add(disciplina); }
}