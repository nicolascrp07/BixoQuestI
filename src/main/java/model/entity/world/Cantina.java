package main.java.model.entity.world;

import main.java.model.entity.character.Jogador;
import java.util.ArrayList;

public class Cantina extends Local {

    private ArrayList<String> cardapio;
    private int tamanhoFila;
    private double valorLanche;

    public Cantina(String nome, String descricao, ArrayList<String> cardapio, int tamanhoFila, double valorLanche) {
        super(nome, descricao);
        this.cardapio = cardapio;
        this.tamanhoFila = tamanhoFila;
        this.valorLanche = valorLanche;
    }

    private void comprarLanche(Jogador jogador) {
        jogador.setDinheiro(jogador.getDinheiro() - valorLanche);
        jogador.setMotivacao(jogador.getMotivacao() + 15);
    }

    @Override
    public void acaoEspecifica(Jogador j){
        this.comprarLanche(j);
    }
}