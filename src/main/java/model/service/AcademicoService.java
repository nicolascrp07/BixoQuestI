package main.java.model.service;

import main.java.model.entity.academic.Avaliacao;
import main.java.model.entity.academic.Disciplina;
import main.java.model.entity.character.Jogador;
import main.java.model.entity.character.Professor;
import main.java.model.entity.event.Consequencia;
import main.java.model.entity.world.LEDS;
import main.java.model.entity.world.Local;
import main.java.model.entity.world.Sala;
import main.java.model.entity.world.Universidade;

import java.util.ArrayList;

public class AcademicoService {
    private static final Consequencia IMPACTO_DIFICIL = new Consequencia(-15, -10, 0, 0, -15, 0);
    private static final Consequencia IMPACTO_MEDIO = new Consequencia(-10, -5, 0, 0, -5, 0);
    private static final Consequencia IMPACTO_FACIL = new Consequencia(-5, 0, 0, 10, 0, 1);
    public static final String EXATAS = "exatas";
    public static final String ALGORITMOS = "algoritmos";
    public static final String HARDWARE = "hardware";

    public void aplicarProva(Jogador j, Disciplina d, Avaliacao a, double notaDoMinigame) {
        this.calcularDificuldade(j,a);
        if (a.getDificuldade() == 3) IMPACTO_DIFICIL.aplicar(j);
        else if (a.getDificuldade() == 2) IMPACTO_MEDIO.aplicar(j);
        else IMPACTO_FACIL.aplicar(j);
        a.setNota(notaDoMinigame);
        d.setNotaFinal(a.getNota());
    }

    public void calcularDificuldade(Jogador j, Avaliacao a){
        if (j.getNivelConhecimento() <= 30){
            a.setDificuldade(3);
        } else if (j.getNivelConhecimento() <= 70){
            a.setDificuldade(2);
        } else {
            a.setDificuldade(1);
        }
    }

    public ArrayList<Disciplina> fecharSemestre(Jogador j) {
        ArrayList<Disciplina> ativas = j.getDisciplinas();
        ArrayList<Disciplina> recemAprovadas = new ArrayList<>();

        for (Disciplina d : ativas) {
            d.verificarAprovacao();
            if (d.getStatusAprovacao()) {
                recemAprovadas.add(d);
            }
        }

        for (Disciplina aprovada : recemAprovadas) {
            j.removeDisciplina(aprovada);
            j.addDisciplinaHistorico(aprovada);
        }

        this.atualizarScore(j);
        return recemAprovadas;
    }

    public void atualizarScore(Jogador j){
        ArrayList<Disciplina> aprovadas = j.getHistoricoAprovadas();
        if (aprovadas.isEmpty()) {
            j.setDesempenhoAcademico(0.0);
            return;
        }

        double soma = 0;
        for (Disciplina a : aprovadas) {
            soma += a.getNotaFinal();
        }
        j.setDesempenhoAcademico(soma / aprovadas.size());
    }

    public void matricularNovoSemestre(Jogador j, ArrayList<Disciplina> catalogo){

        boolean faltaAlgoritmos = true;
        boolean faltaHardware = true;
        boolean faltaExatas = true;

        for (Disciplina d : j.getDisciplinas()) {
            if (d.getArea().equals(ALGORITMOS)) faltaAlgoritmos = false;
            if (d.getArea().equals(HARDWARE)) faltaHardware = false;
            if (d.getArea().equals(EXATAS)) faltaExatas = false;
        }

        for (Disciplina materiaDoCatalogo : catalogo) {

            if (faltaAlgoritmos && materiaDoCatalogo.getArea().equals(ALGORITMOS)) {

                boolean jaPassou = j.getHistoricoAprovadas().contains(materiaDoCatalogo);

                boolean temPreRequisito = (materiaDoCatalogo.getPreRequisito() == null) ||
                        (j.getHistoricoAprovadas().contains(materiaDoCatalogo.getPreRequisito()));

                if (!jaPassou && temPreRequisito) {
                    j.addDisciplina(materiaDoCatalogo);
                    faltaAlgoritmos = false;
                }
            }

            if (faltaHardware && materiaDoCatalogo.getArea().equals(HARDWARE)) {
                boolean jaPassou = j.getHistoricoAprovadas().contains(materiaDoCatalogo);
                boolean temPreRequisito = (materiaDoCatalogo.getPreRequisito() == null) ||
                        (j.getHistoricoAprovadas().contains(materiaDoCatalogo.getPreRequisito()));

                if (!jaPassou && temPreRequisito) {
                    j.addDisciplina(materiaDoCatalogo);
                    faltaHardware = false;
                }
            }

            if (faltaExatas && materiaDoCatalogo.getArea().equals(EXATAS)) {
                boolean jaPassou = j.getHistoricoAprovadas().contains(materiaDoCatalogo);
                boolean temPreRequisito = (materiaDoCatalogo.getPreRequisito() == null) ||
                        (j.getHistoricoAprovadas().contains(materiaDoCatalogo.getPreRequisito()));

                if (!jaPassou && temPreRequisito) {
                    j.addDisciplina(materiaDoCatalogo);
                    faltaExatas = false;
                }
            }
        }
    }
}
