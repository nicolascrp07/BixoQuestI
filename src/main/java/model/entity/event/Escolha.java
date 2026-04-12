package main.java.model.entity.event;

import main.java.model.entity.character.Jogador;

// Opção disponível ao jogador diante de um evento
public class Escolha {

    private String descricao;           // Texto que descreve a opção
    private Consequencia consequencia;  // Efeitos que a escolha causa

    // Constrói a escolha
    public Escolha(String descricao, Consequencia consequencia) {
        this.descricao = descricao;
        this.consequencia = consequencia;
    }

    // Retorna a descrição
    public String getDescricao() { return descricao; }

    // Executa a escolha
    public void executar(Jogador jogador) {
        consequencia.aplicar(jogador);
    }
}