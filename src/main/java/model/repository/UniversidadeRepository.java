package main.java.model.repository;

import main.java.model.entity.academic.Disciplina;
import main.java.model.entity.character.Animal;
import main.java.model.entity.character.Colega;
import main.java.model.entity.world.*;

import java.util.ArrayList;

public class UniversidadeRepository {

    private ArrayList<Universidade> ub = new ArrayList<>();

    public Universidade salvar(Universidade uni) {
        if (!ub.contains(uni)){
            ub.add(uni);
            return uni;
        }
        return null;
    }

    public ArrayList<Universidade> buscarTodos() {
        return new ArrayList<>(ub);
    }

    public Universidade buscarPorNome(String nome) {
        for (Universidade u : ub) {
            if (u.getNome().equalsIgnoreCase(nome)) {
                return u;
            }
        }
        return null;
    }

    public boolean deletar(Universidade uni) {
        return ub.remove(uni);
    }

    public void criarMundo(ArrayList<Disciplina> grade) {

        Sala salaAlgoritmos = new Sala("Sala de Algoritmos", "Sala de aula de programação", grade.get(8));
        Sala salaExatas = new Sala("Sala de Exatas", "Sala de aula de matemática", grade.get(0));
        LEDS leds = new LEDS("LEDS", "Laboratório de Eletrônica Digital e Sistemas", grade.get(16));
        Cantina cantina = new Cantina("Cantina", "Cantina universitária", new ArrayList<>(), 0, 15.0);
        Colegiado colegiado = new Colegiado("Colegiado", "Colegiado do curso");
        PontoDeOnibus ponto = new PontoDeOnibus("Ponto de Ônibus", "Ponto de ônibus do campus", "Linha 1");

        Animal gato = new Animal("Felícia", colegiado);
        Animal cachorro = new Animal("Scooby", cantina);
        Colega colega1 = new Colega("Ying Marros", ponto);
        Colega colega2 = new Colega("Ouriçangro Sales", salaAlgoritmos);

        Universidade uni = new Universidade("UEFS", "Universidade Estadual de Feira de Santana");
        uni.getLocais().add(salaAlgoritmos);
        uni.getLocais().add(salaExatas);
        uni.getLocais().add(leds);
        uni.getLocais().add(cantina);
        uni.getLocais().add(colegiado);
        uni.getLocais().add(ponto);

        for (Disciplina d : grade) {
            if (d.getArea().equals(DisciplinaRepository.ALGORITMOS)) {
                d.getProfessor().setLocal(salaAlgoritmos);
            } else if (d.getArea().equals(DisciplinaRepository.HARDWARE)) {
                d.getProfessor().setLocal(leds);
            } else if (d.getArea().equals(DisciplinaRepository.EXATAS)) {
                d.getProfessor().setLocal(salaExatas);
            }
        }

        uni.getPersonagens().add(gato);
        uni.getPersonagens().add(cachorro);
        uni.getPersonagens().add(colega1);
        uni.getPersonagens().add(colega2);

        for (Disciplina d : grade) {
            if (!uni.getPersonagens().contains(d.getProfessor())) {
                uni.getPersonagens().add(d.getProfessor());
            }
        }

        this.salvar(uni);
    }
}