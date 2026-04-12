package main.java.model.entity.world;

import main.java.model.entity.character.Jogador;

// Colegiado do curso
public class Colegiado extends Local {

    private boolean aberto; // Indica se o colegiado está aberto

    // Constrói o colegiado
    public Colegiado(String nome, String descricao) {
        super(nome, descricao);
        this.aberto = true;
    }

    // Se o colegiado estiver aberto, recupera energia, motivação e conhecimento do jogador
    private void pedirAjudaMaeli(Jogador jogador) {
        if (this.aberto) {
            jogador.setEnergia(jogador.getEnergia() + 15);
            jogador.setMotivacao(jogador.getMotivacao() + 20);
            jogador.setNivelConhecimento(jogador.getNivelConhecimento() + 5);
        }
    }

    // A ação específica do colegiado é ofertar a ajuda da Maeli
    @Override
    public void acaoEspecifica(Jogador j) {
        this.pedirAjudaMaeli(j);
    }
}