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

    @Override
    public void interagir(Jogador jogador) {
        jogador.setEnergia(jogador.getEnergia() - 5);
        jogador.setLocalAtual(this);
    }

    public void atualizarLocal() {
        for (Personagem p : personagens) {
            if (p instanceof Colega || p instanceof Animal) {
                Local localSorteado = null; // Limpo
                // Abaixo também tirei os prefixos de Sala e LEDS
                while (localSorteado == null || localSorteado instanceof Sala || localSorteado instanceof LEDS) {
                    int indice = (int) (Math.random() * locais.size());
                    localSorteado = locais.get(indice);
                }
                p.setLocal(localSorteado);
            }
        }
    }
}