package main.java.model.entity.game;

// Tempo dentro da partida
public class Tempo {

    private int semanaAtual;    // Semana atual do semestre (1 a 4)
    private int semestreAtual;  // Semestre atual

    // Constrói o tempo
    public Tempo(int semanaAtual, int semestreAtual) {
        this.semanaAtual = semanaAtual;
        this.semestreAtual = semestreAtual;
    }

    // Avança uma semana; ao completar 4 semanas, inicia um novo semestre
    public void avancarSemana() {
        if (semanaAtual < 4) {
            semanaAtual++;
        } else {
            semanaAtual = 1;
            semestreAtual++;
        }
    }

    // Retorna a semana atual
    public int getSemanaAtual() { return semanaAtual; }

    // Retorna o semestre atual
    public int getSemestreAtual() { return semestreAtual; }

    // Atualiza a semana atual
    public void setSemanaAtual(int semanaAtual) { this.semanaAtual = semanaAtual; }

    // Atualiza o semestre atual
    public void setSemestreAtual(int semestreAtual) { this.semestreAtual = semestreAtual; }
}