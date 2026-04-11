package main.java.model.repository;

import main.java.model.entity.character.Professor;

import java.util.ArrayList;

public class ProfessorRepository {

    private ArrayList<Professor> pb = new ArrayList<>();

    public Professor salvar(Professor professor) {
        if (!pb.contains(professor)){
            pb.add(professor);
            return professor;
        }
        return null;
    }

    public ArrayList<Professor> buscarTodos() {
        return new ArrayList<>(pb);
    }

    public Professor buscarPorNome(String nome) {
        for (Professor d : pb) {
            if (d.getNome().equalsIgnoreCase(nome)) {
                return d;
            }
        }
        return null;
    }

    public boolean deletar(Professor professor) {
        return pb.remove(professor);
    }

    public void criarProfessores() {

        this.salvar(new Professor("Claudênia Pintolária", null));
        this.salvar(new Professor("Pamelinda Cortizona", null));
        this.salvar(new Professor("Biancarlota Santanilda", null));
        this.salvar(new Professor("Gabriela Peixolinda", null));

        this.salvar(new Professor("Anfransérgio Diastronho", null));
        this.salvar(new Professor("Joãoberto Boscolino", null));
        this.salvar(new Professor("Delmarvilho Brogliovski", null));
        this.salvar(new Professor("Ângelo Duartênis", null));

        this.salvar(new Professor("Jaquelândia Sintrônica", null));
        this.salvar(new Professor("Geraldoncio Assislânio", null));
        this.salvar(new Professor("Cristianópolis Mascarenhudo", null));
        this.salvar(new Professor("Ademaksonildo Araujástico", null));

    }
}