package main.java.model.entity.character;

import main.java.model.entity.world.Local;
import main.java.model.entity.world.Sala;

public class Professor extends Personagem {
    public Professor (String nome, Local local){
        super(nome, local);
    }

    @Override
    public boolean podeAcessar(Local l){
        return (l instanceof Sala);
    }

    private void tirarDuvida(Jogador jogador) {
        jogador.setNivelConhecimento(jogador.getNivelConhecimento() + 10);
    }

    @Override
    public void interacaoEspecifica(Jogador jogador) {
        this.tirarDuvida(jogador);
    }
}