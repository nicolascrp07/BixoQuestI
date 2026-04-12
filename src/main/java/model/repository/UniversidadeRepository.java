package main.java.model.repository;

import main.java.model.entity.academic.Disciplina;
import main.java.model.entity.character.Animal;
import main.java.model.entity.character.Colega;
import main.java.model.entity.world.*;

import java.util.ArrayList;

// Repositório responsável por armazenar e gerenciar a universidade do jogo
public class UniversidadeRepository {

    private ArrayList<Universidade> ub = new ArrayList<>(); // Base de dados das universidades

    // Salva a universidade se ela ainda não estiver cadastrada | Retorna null caso contrário
    public Universidade salvar(Universidade uni) {
        if (!ub.contains(uni)) {
            ub.add(uni);
            return uni;
        }
        return null;
    }

    // Retorna uma cópia da lista com todas as universidades cadastradas
    public ArrayList<Universidade> buscarTodos() {
        return new ArrayList<>(ub);
    }

    // Busca uma universidade pelo nome
    public Universidade buscarPorNome(String nome) {
        for (Universidade u : ub) {
            if (u.getNome().equalsIgnoreCase(nome)) {
                return u;
            }
        }
        return null; // Nenhuma universidade encontrada
    }

    // Remove a universidade do repositório e retorna true se a operação for realizada
    public boolean deletar(Universidade uni) {
        return ub.remove(uni);
    }

    // Constrói o mundo do jogo com locais, personagens e professores posicionados
    public void criarMundo(ArrayList<Disciplina> grade) {

        // Criação dos locais do campus
        Sala salaAlgoritmos = new Sala("Sala de Algoritmos", "Sala de aula de programação", grade.get(8));
        Sala salaExatas     = new Sala("Sala de Exatas",     "Sala de aula de matemática",  grade.get(0));
        LEDS leds           = new LEDS("LEDS",               "Laboratório de Eletrônica Digital e Sistemas", grade.get(16));
        Cantina cantina     = new Cantina("Cantina",         "Cantina universitária",        new ArrayList<>(), 0, 15.0);
        Colegiado colegiado = new Colegiado("Colegiado",     "Colegiado do curso");
        PontoDeOnibus ponto = new PontoDeOnibus("Ponto de Ônibus", "Ponto de ônibus do campus", "Linha 1");

        // Criação dos NPCS
        Animal gato      = new Animal("Felícia",          colegiado);
        Animal cachorro  = new Animal("Scooby",            cantina);
        Colega colega1   = new Colega("Ying Marros",       ponto);
        Colega colega2   = new Colega("Ouriçangro Sales",  salaAlgoritmos);

        // Monta a universidade e adiciona todos os locais
        Universidade uni = new Universidade("UEFS", "Universidade Estadual de Feira de Santana");
        uni.getLocais().add(salaAlgoritmos);
        uni.getLocais().add(salaExatas);
        uni.getLocais().add(leds);
        uni.getLocais().add(cantina);
        uni.getLocais().add(colegiado);
        uni.getLocais().add(ponto);

        // Posiciona cada professor no local correspondente à sua área
        for (Disciplina d : grade) {
            if (d.getArea().equals(DisciplinaRepository.ALGORITMOS)) {
                d.getProfessor().setLocal(salaAlgoritmos);
            } else if (d.getArea().equals(DisciplinaRepository.HARDWARE)) {
                d.getProfessor().setLocal(leds);
            } else if (d.getArea().equals(DisciplinaRepository.EXATAS)) {
                d.getProfessor().setLocal(salaExatas);
            }
        }

        // Adiciona os NPCS a universidade
        uni.getPersonagens().add(gato);
        uni.getPersonagens().add(cachorro);
        uni.getPersonagens().add(colega1);
        uni.getPersonagens().add(colega2);

        // Adiciona os professores a universidade
        for (Disciplina d : grade) {
            if (!uni.getPersonagens().contains(d.getProfessor())) {
                uni.getPersonagens().add(d.getProfessor());
            }
        }

        this.salvar(uni);
    }
}