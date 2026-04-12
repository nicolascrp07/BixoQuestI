package test.java.model.service;

import main.java.model.entity.academic.Disciplina;
import main.java.model.entity.character.Jogador;
import main.java.model.entity.game.Partida;
import main.java.model.entity.game.Tempo;
import main.java.model.entity.world.Universidade;
import main.java.model.service.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PartidaServiceTeste {
    private AcademicoService academicoService;
    private ExplorarService explorarService;
    private PartidaService partidaService;
    private EventoService eventoService;
    private QuestService questService;
    private Jogador jogador;
    private Partida partida;

    @Before
    public void setUp() {
        academicoService = new AcademicoService();
        questService = new QuestService();
        explorarService = new ExplorarService(academicoService, questService);
        partidaService = new PartidaService(academicoService, explorarService, eventoService, null, null, null, null, null);

        Universidade uni = new Universidade("UEFS", "Universidade");
        jogador = new Jogador("Nicolas", 100, 50, 50, 100, 50.0, 0.0, uni);
        Tempo tempo = new Tempo(1, 1);
        partida = new Partida(jogador, tempo, uni, null, false, new ArrayList<>(), new ArrayList<>());
    }

    @Test
    public void jogoNaoTerminouPoucasAprovadas() {
        ArrayList<Disciplina> aprovadas = new ArrayList<>();
        Disciplina disp = new Disciplina("DispTeste", AcademicoService.ALGORITMOS, null, null, 0.0, 60, true, null);
        for (int i = 0; i < 23; i++) {
            aprovadas.add(disp);
        }
        jogador.setHistoricoAprovadas(aprovadas);
        assertFalse(partidaService.verificarFimDeJogo(jogador));
    }

    @Test
    public void jogoTerminouTodasAprovadas() {
        ArrayList<Disciplina> aprovadas = new ArrayList<>();
        Disciplina disp = new Disciplina("DispTeste", AcademicoService.HARDWARE, null, null, 0.0, 60, true, null);
        for (int i = 0; i < 24; i++) {
            aprovadas.add(disp);
        }
        jogador.setHistoricoAprovadas(aprovadas);
        assertTrue(partidaService.verificarFimDeJogo(jogador));
    }

    @Test
    public void gameOverPorSaude() {
        jogador.setSaude(0);
        assertTrue(partidaService.verificarGameOver(jogador));
    }

    @Test
    public void gameOverPorMotivacao() {
        jogador.setMotivacao(0);
        assertTrue(partidaService.verificarGameOver(jogador));
    }

    @Test
    public void semGameOver() {
        assertFalse(partidaService.verificarGameOver(jogador));
    }

    @Test
    public void avancarSemanaNoMesmoSemestre() {
        int semestreAntes = partida.getTempo().getSemestreAtual();
        partidaService.avancarSemana(partida);
        assertEquals(semestreAntes, partida.getTempo().getSemestreAtual());
        assertEquals(2, partida.getTempo().getSemanaAtual());
    }

    @Test
    public void avancarSemanaComMudancaDeSemestre() {
        Disciplina disp = new Disciplina("DispTeste", AcademicoService.ALGORITMOS, null, null, 10.0, 60, false, null);
        disp.verificarAprovacao();
        jogador.addDisciplina(disp);

        partida.getTempo().avancarSemana();
        partida.getTempo().avancarSemana();
        partida.getTempo().avancarSemana();

        int semestreAntes = partida.getTempo().getSemestreAtual();
        partidaService.avancarSemana(partida);

        assertEquals(semestreAntes + 1, partida.getTempo().getSemestreAtual());
        assertEquals(1, partida.getTempo().getSemanaAtual());
        assertEquals(0, jogador.getDisciplinas().size());
        assertEquals(1, jogador.getHistoricoAprovadas().size());
    }
}