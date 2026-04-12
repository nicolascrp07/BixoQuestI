package main.java.model.entity.world;

import main.java.model.entity.character.Jogador;
import main.java.model.entity.character.Personagem;

import java.util.ArrayList;

// Universidade agrupa todos os outros locais e personagens
public class Universidade extends Local {

    private ArrayList<Local> locais;            // Locais que compõem a universidade
    private ArrayList<Personagem> personagens;  // Personagens presentes na universidade

    // Constrói a universidade
    public Universidade(String nome, String descricao) {
        super(nome, descricao);
        this.locais = new ArrayList<>();
        this.personagens = new ArrayList<>();
    }

    // Retorna todos os personagens
    public ArrayList<Personagem> getPersonagens() { return personagens; }

    // Retorna todos os locais
    public ArrayList<Local> getLocais() { return locais; }

    // Interagir com a universidade apenas reposiciona o jogador
    @Override
    public void interagir(Jogador jogador) {
        jogador.setLocalAtual(this);
    }

    // A ação específica da universidade reposiciona o jogador
    @Override
    public void acaoEspecifica(Jogador jogador) {
        jogador.setLocalAtual(this);
    }
}