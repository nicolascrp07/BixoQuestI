package main.java.model.entity.world;

import main.java.model.entity.character.Animal;
import main.java.model.entity.character.Colega;
import main.java.model.entity.character.Jogador;
import main.java.model.entity.character.Personagem;

import java.util.ArrayList;

public class Universidade extends Local { // Não precisa do caminho completo
    private ArrayList<Local> locais; // Limpo
    private ArrayList<Personagem> personagens;

    public Universidade(String nome, String descricao){
        super(nome, descricao);
        this.locais = new ArrayList<>();
        this.personagens = new ArrayList<>();
    }

    public ArrayList<Personagem> getPersonagens() {
        return personagens;
    }

    public ArrayList<Local> getLocais() {
        return locais;
    }

    @Override
    public void interagir(Jogador jogador) {
        jogador.setLocalAtual(this);
    }

    @Override
    public void acaoEspecifica(Jogador jogador){
        jogador.setLocalAtual(this);
    }
}