package main.java.model.entity.world;

import main.java.model.entity.game.Tempo; // import não utilizado, pode ser removido
import main.java.model.entity.character.Jogador;

// Ponto de ônibus
public class PontoDeOnibus extends Local {

    private String linha; // Linha do ônibus

    // Constrói o ponto de ônibus
    public PontoDeOnibus(String nome, String descricao, String linha) {
        super(nome, descricao);
        this.linha = linha;
    }

    // Restaura a energia do jogador
    private void pegarOnibus(Jogador jogador) {
        jogador.setEnergia(100);
    }

    // A ação específica do ponto de ônibus é pegar o ônibus
    @Override
    public void acaoEspecifica(Jogador j) {
        this.pegarOnibus(j);
    }
}