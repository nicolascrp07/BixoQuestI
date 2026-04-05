package main.java.model.service;

import main.java.model.entity.academic.Disciplina;
import main.java.model.entity.character.Jogador;
import main.java.model.entity.game.Tempo;
import main.java.model.entity.world.Universidade;

import java.util.ArrayList;

public class PartidaService {
    public void avancarSemana(Jogador j, Universidade uni, Tempo tempo, AcademicoService ac, ExplorarService ex, ArrayList<Disciplina> catalogo){
        int semestreAnterior = tempo.getSemestreAtual();
        tempo.avancarSemana();
        ex.atualizarLocal(uni);
        if (tempo.getSemestreAtual() > semestreAnterior) {
            ac.fecharSemestre(j);
            ac.matricularNovoSemestre(j, catalogo);
        }
    }

    public boolean verificarFimDeJogo(Jogador j, int totalDisciplinasDoCurso){
        return j.getHistoricoAprovadas().size() == totalDisciplinasDoCurso;
    }

    public void iniciarJogo(Universidade uni, Jogador j, Tempo t){
        // ainda vou definir o preenchimento padrão! só os detalhes mesmo
    }

    public boolean verificarGameOver(Jogador j){
        return j.getSaude() == 0 || j.getMotivacao() == 0;
    }
}