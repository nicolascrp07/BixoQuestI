package main.java.model.entity.world;

import main.java.model.entity.character.Jogador;

// Classe abstrata para todos os locais do jogo
public abstract class Local {

    protected String nome;      // Nome do local
    protected String descricao; // Descrição do local

    // Constrói o local
    public Local(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    // Interagir com um local consome energia e reposiciona o jogador
    public void interagir(Jogador jogador) {
        jogador.setEnergia(jogador.getEnergia() - 5);
        jogador.setLocalAtual(this);
    }

    // Define a interação específica de cada local sobre o jogador
    public abstract void acaoEspecifica(Jogador jogador);

    // Retorna o nome do local
    public String getNome() { return nome; }
}