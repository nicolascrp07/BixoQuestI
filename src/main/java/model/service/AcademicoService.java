package main.java.model.service;

import main.java.model.entity.academic.Avaliacao;
import main.java.model.entity.academic.Disciplina;
import main.java.model.entity.character.Jogador;

import java.util.ArrayList;

public class AcademicoService {

    public void aplicarProva (Jogador j, Disciplina d, Avaliacao a){
        a.calcularDificuldade(j);
        a.calcularImpacto(j);
        a.aplicarAvaliacao(j);
        d.addAvaliacao(a);
    }

    public void fecharSemestre(Jogador j){
        ArrayList<Disciplina> ativas = j.getDisciplinas();
        ArrayList<Disciplina> recemAprovadas = new ArrayList<>();

        for (Disciplina d : ativas){
            d.calcularNota();
            d.verificarAprovacao();

            if (d.getStatusAprovacao()){
                recemAprovadas.add(d);
            } else {
                d.limparAvaliacao();
            }
        }

        for (Disciplina aprovada : recemAprovadas) {
            j.removeDisciplina(aprovada);
            j.addDisciplinaHistorico(aprovada);
        }

        this.atualizarScore(j);
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
            if (d.getArea().equals("Algoritmos")) faltaAlgoritmos = false;
            if (d.getArea().equals("Hardware")) faltaHardware = false;
            if (d.getArea().equals("Exatas")) faltaExatas = false;
        }

        for (Disciplina materiaDoCatalogo : catalogo) {

            if (faltaAlgoritmos && materiaDoCatalogo.getArea().equals("Algoritmos")) {

                boolean jaPassou = j.getHistoricoAprovadas().contains(materiaDoCatalogo);

                boolean temPreRequisito = (materiaDoCatalogo.getPreRequisito() == null) ||
                        (j.getHistoricoAprovadas().contains(materiaDoCatalogo.getPreRequisito()));

                if (!jaPassou && temPreRequisito) {
                    j.addDisciplina(materiaDoCatalogo);
                    faltaAlgoritmos = false;
                }
            }

            if (faltaHardware && materiaDoCatalogo.getArea().equals("Hardware")) {
                boolean jaPassou = j.getHistoricoAprovadas().contains(materiaDoCatalogo);
                boolean temPreRequisito = (materiaDoCatalogo.getPreRequisito() == null) ||
                        (j.getHistoricoAprovadas().contains(materiaDoCatalogo.getPreRequisito()));

                if (!jaPassou && temPreRequisito) {
                    j.addDisciplina(materiaDoCatalogo);
                    faltaHardware = false;
                }
            }

            if (faltaExatas && materiaDoCatalogo.getArea().equals("Exatas")) {
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
