package main.java.model.entity.character;

import main.java.model.entity.world.LEDS;
import main.java.model.entity.world.Local;
import main.java.model.entity.world.Sala;

public class Colega extends Personagem {
    public Colega (String nome, Local local){
        super(nome, local);
    }

    @Override
    public boolean podeAcessar(Local l){
        return !(l instanceof Sala) && !(l instanceof LEDS);
    }

    private void fofocaAlheia(Jogador jogador) {
        jogador.setMotivacao(jogador.getMotivacao() + 5);
    }

    @Override
    public void interacaoEspecifica(Jogador jogador) {
        this.fofocaAlheia(jogador);
    }
}