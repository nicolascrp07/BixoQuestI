package main.java.model.repository;

import main.java.model.entity.character.Professor;

import java.util.ArrayList;

// Repositório responsável por armazenar e gerenciar os professores do jogo
public class ProfessorRepository {

    private ArrayList<Professor> pb = new ArrayList<>(); // Base de dados dos professores

    // Salva o professor se ele ainda não estiver cadastrado | Retorna null caso contrário
    public Professor salvar(Professor professor) {
        if (!pb.contains(professor)) {
            pb.add(professor);
            return professor;
        }
        return null;
    }

    // Retorna uma cópia da lista com todos os professores cadastrados
    public ArrayList<Professor> buscarTodos() {
        return new ArrayList<>(pb);
    }

    // Busca um professor pelo nome
    public Professor buscarPorNome(String nome) {
        for (Professor d : pb) {
            if (d.getNome().equalsIgnoreCase(nome)) {
                return d;
            }
        }
        return null; // Nenhum professor encontrado
    }

    // Remove o professor do repositório e retorna true se a operação for realizada
    public boolean deletar(Professor professor) {
        return pb.remove(professor);
    }

    // Instancia e salva todos os professores do jogo
    public void criarProfessores() {

        // Professoras de Algoritmos
        this.salvar(new Professor("Claudênia Plinda",    null));
        this.salvar(new Professor("Pamelinda Cortizona",     null));
        this.salvar(new Professor("Biancarlota Santalinda",  null));
        this.salvar(new Professor("Gabriela Peixolinda",     null));

        // Professores de Hardware
        this.salvar(new Professor("Anfransérgio Diastronho", null));
        this.salvar(new Professor("Joãoberto Boscolino",     null));
        this.salvar(new Professor("Delmarvilho Brogliovski", null));
        this.salvar(new Professor("Ângelo Duartênis",        null));

        // Professores de Exatas
        this.salvar(new Professor("Jaquelândia Sintrônica",     null));
        this.salvar(new Professor("Geraldoncio Assislânio",     null));
        this.salvar(new Professor("Cristianópolis Mascarenhudo",null));
        this.salvar(new Professor("Ademaksonildo Araujástico",  null));
    }
}