package main.java.model.entity.event;

import main.java.model.entity.character.Jogador;

public class Consequencia {
    private int efeitoEnergia;
    private int efeitoMotivacao;
    private double efeitoDinheiro;
    private int efeitoConhecimento;
    private int efeitoSaude;
    private int efeitoAcademico;

    public Consequencia(int efeitoEnergia, int efeitoMotivacao, double efeitoDinheiro,
                        int efeitoConhecimento, int efeitoSaude, int efeitoAcademico) {
        this.efeitoEnergia = efeitoEnergia;
        this.efeitoMotivacao = efeitoMotivacao;
        this.efeitoDinheiro = efeitoDinheiro;
        this.efeitoConhecimento = efeitoConhecimento;
        this.efeitoSaude = efeitoSaude;
        this.efeitoAcademico = efeitoAcademico;
    }

    public void aplicar(Jogador jogador) {
        jogador.setEnergia(jogador.getEnergia() + efeitoEnergia);
        jogador.setMotivacao(jogador.getMotivacao() + efeitoMotivacao);
        jogador.setDinheiro(jogador.getDinheiro() + efeitoDinheiro);
        jogador.setNivelConhecimento(jogador.getNivelConhecimento() + efeitoConhecimento);
        jogador.setSaude(jogador.getSaude() + efeitoSaude);
        jogador.setDesempenhoAcademico(jogador.getDesempenhoAcademico() + efeitoAcademico);
    }
}