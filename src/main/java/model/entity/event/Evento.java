package main.java.model.entity.event;

import main.java.model.entity.character.Jogador;
import main.java.model.entity.game.Tempo; // Importado do novo pacote game
import java.util.ArrayList;

public abstract class Evento {
    protected String nome;
    protected String descricao;
    protected double probabilidadeOcorrencia;
    protected ArrayList<Escolha> escolhas;

    public Evento(String nome, String descricao, double probabilidadeOcorrencia) {
        this.nome = nome;
        this.descricao = descricao;
        this.probabilidadeOcorrencia = probabilidadeOcorrencia;
        this.escolhas = new ArrayList<>();
    }

    public double getProbabilidadeOcorrencia(){
        return probabilidadeOcorrencia;
    }

    public ArrayList<Escolha> getEscolhas(){ // Limpo
        return escolhas;
    }

    public abstract boolean condicaoOcorrencia(Tempo tempo);

    public abstract boolean podeOcorrer(Tempo tempo);
}