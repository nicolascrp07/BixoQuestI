package main.java.model.entity.game;

public class Tempo {
    private int semanaAtual;
    private int semestreAtual;

    public Tempo(int semanaAtual, int semestreAtual) {
        this.semanaAtual = semanaAtual;
        this.semestreAtual = semestreAtual;
    }

    public void avancarSemana() {
        if (semanaAtual < 4) {
            semanaAtual++;
        } else {
            semanaAtual = 1;
            semestreAtual++;
        }
    }

    public int getSemanaAtual() {
        return semanaAtual;
    }

    public int getSemestreAtual() {
        return semestreAtual;
    }

    public void setSemanaAtual(int semanaAtual) {
        this.semanaAtual = semanaAtual;
    }

    public void setSemestreAtual(int semestreAtual) {
        this.semestreAtual = semestreAtual;
    }
}