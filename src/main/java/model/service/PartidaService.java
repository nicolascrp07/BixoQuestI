package main.java.model.service;

import main.java.model.entity.academic.Disciplina;
import main.java.model.entity.character.Jogador;
import main.java.model.entity.event.Evento;
import main.java.model.entity.game.Partida;
import main.java.model.entity.game.Tempo;
import main.java.model.entity.world.Universidade;
import main.java.model.repository.*;

import java.util.ArrayList;

public class PartidaService {
    private AcademicoService academicoService;
    private ExplorarService explorarService;
    private EventoService eventoService;
    private ProfessorRepository profRepo;
    private DisciplinaRepository discRepo;
    private UniversidadeRepository uniRepo;
    private PartidaRepository partRepo;
    private EventoRepository eventoRepo;

    public static final int TOTAL_DISCIPLINAS = 24;

    public PartidaService(AcademicoService ac, ExplorarService es, EventoService ev, ProfessorRepository pr, DisciplinaRepository dr,
                          UniversidadeRepository ur, PartidaRepository par, EventoRepository er) {
        this.academicoService = ac;
        this.explorarService = es;
        this.eventoService = ev;
        this.profRepo = pr;
        this.discRepo = dr;
        this.uniRepo = ur;
        this.partRepo = par;
        this.eventoRepo = er;
    }
    public void avancarSemana(Partida p){
        int semestreAnterior = p.getTempo().getSemestreAtual();
        p.getTempo().avancarSemana();
        explorarService.atualizarLocal(p.getUniversidade());
        p.setEventoAtual(eventoService.gerarEvento(p.getEventos(), p.getTempo()));
        if (p.getTempo().getSemestreAtual() > semestreAnterior) {
            ArrayList<Disciplina> aprovadas = academicoService.fecharSemestre(p.getJogador());
            explorarService.atualizarSalas(aprovadas, p.getUniversidade(), p.getGradeCompleta());
            academicoService.matricularNovoSemestre(p.getJogador(), p.getGradeCompleta());
        }
    }

    public boolean verificarFimDeJogo(Jogador j){
        return j.getHistoricoAprovadas().size() == TOTAL_DISCIPLINAS;
    }

    public Partida iniciarJogo(String nomeJogador) {
        profRepo.criarProfessores();
        discRepo.criarGrade(profRepo.buscarTodos());
        uniRepo.criarMundo(discRepo.buscarTodas());
        eventoRepo.criarEventosPadrao();

        ArrayList<Disciplina> grade = discRepo.buscarTodas();
        Universidade uni = uniRepo.buscarPorNome("UEFS");
        ArrayList<Evento> eventos = eventoRepo.buscarTodos();

        Jogador jogador = new Jogador(nomeJogador, 100, 0, 100, 100, 50.0, 0.0, uni);
        academicoService.matricularNovoSemestre(jogador, grade);

        Tempo tempo = new Tempo(1, 1);
        Partida partida = new Partida(jogador, tempo, uni, null,false, eventos, grade);

        partRepo.salvarPartida(partida);
        return partida;
    }

    public boolean verificarGameOver(Jogador j){
        return j.getSaude() == 0 || j.getMotivacao() == 0;
    }
}