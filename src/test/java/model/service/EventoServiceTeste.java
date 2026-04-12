package test.java.model.service;

import main.java.model.entity.character.Jogador;
import main.java.model.entity.event.*;
import main.java.model.entity.game.Tempo;
import main.java.model.entity.world.Universidade;
import main.java.model.service.EventoService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EventoServiceTeste {
    private FilaGigante filaGigante;
    private Greve greve;
    private MaterialCaro materialCaro;
    private MilagreAcademico milagreAcademico;
    private ProvaSurpresa provaSurpresa;
    private EventoService eventoService;
    private Jogador jogador;

    @Before
    public void setUp() {
        filaGigante = new FilaGigante();
        greve = new Greve();
        materialCaro = new MaterialCaro();
        milagreAcademico = new MilagreAcademico();
        provaSurpresa = new ProvaSurpresa();
        eventoService = new EventoService();
        jogador = new Jogador("Nicolas", 100, 50, 100, 100, 50.0, 0.0, new Universidade("UEFS", "Universidade"));
    }

    @Test
    public void provaSurpresaNaoOcorreNaSemana4() {
        assertFalse(provaSurpresa.condicaoOcorrencia(new Tempo(4, 1)));
    }

    @Test
    public void provaSurpresaOcorreFora4() {
        assertTrue(provaSurpresa.condicaoOcorrencia(new Tempo(1, 1)));
    }

    @Test
    public void filaGiganteOcorreNaSemana1() {
        assertTrue(filaGigante.condicaoOcorrencia(new Tempo(1, 1)));
    }

    @Test
    public void filaGiganteNaoOcorreFora1() {
        assertFalse(filaGigante.condicaoOcorrencia(new Tempo(2, 1)));
    }

    @Test
    public void greveNaoOcorreNoSemestre1() {
        assertFalse(greve.condicaoOcorrencia(new Tempo(1, 1)));
    }

    @Test
    public void greveOcorreAPartirDoSemestre2() {
        assertTrue(greve.condicaoOcorrencia(new Tempo(1, 2)));
    }

    @Test
    public void milagreAcademicoOcorreNaSemana4() {
        assertTrue(milagreAcademico.condicaoOcorrencia(new Tempo(4, 1)));
    }

    @Test
    public void milagreAcademicoNaoOcorreFora4() {
        assertFalse(milagreAcademico.condicaoOcorrencia(new Tempo(1, 1)));
    }

    @Test
    public void escolhaProvaSurpresaEstudar() {
        eventoService.processarEscolha(jogador, provaSurpresa.getEscolhas().get(0));
        assertEquals(90, jogador.getEnergia());
        assertEquals(95, jogador.getMotivacao());
        assertEquals(55, jogador.getNivelConhecimento());
    }

    @Test
    public void escolhaProvaSurpresaColar() {
        eventoService.processarEscolha(jogador, provaSurpresa.getEscolhas().get(1));
        assertEquals(95, jogador.getEnergia());
        assertEquals(90, jogador.getSaude());
    }

    @Test
    public void escolhaProvaSurpresaDesistir() {
        eventoService.processarEscolha(jogador, provaSurpresa.getEscolhas().get(2));
        assertEquals(80, jogador.getMotivacao());
    }

    @Test
    public void escolhaFilaGiganteEnfrentar() {
        eventoService.processarEscolha(jogador, filaGigante.getEscolhas().get(0));
        assertEquals(85, jogador.getEnergia());
        assertEquals(90, jogador.getMotivacao());
        assertEquals(100, jogador.getSaude());
    }

    @Test
    public void escolhaFilaGiganteDesistir() {
        eventoService.processarEscolha(jogador, filaGigante.getEscolhas().get(1));
        assertEquals(100, jogador.getEnergia());
        assertEquals(80, jogador.getMotivacao());
        assertEquals(90, jogador.getSaude());
    }

    @Test
    public void escolhaGreveFolga() {
        eventoService.processarEscolha(jogador, greve.getEscolhas().get(0));
        assertEquals(100, jogador.getEnergia());
        assertEquals(100, jogador.getMotivacao());
        assertEquals(40.0, jogador.getDinheiro(), 0.001);
        assertEquals(35, jogador.getNivelConhecimento());
        assertEquals(100, jogador.getSaude());
    }

    @Test
    public void escolhaGreveEstudar() {
        eventoService.processarEscolha(jogador, greve.getEscolhas().get(1));
        assertEquals(90, jogador.getEnergia());
        assertEquals(100, jogador.getMotivacao());
        assertEquals(60.0, jogador.getDinheiro(), 0.001);
        assertEquals(70, jogador.getNivelConhecimento());
        assertEquals(95, jogador.getSaude());
    }

    @Test
    public void escolhaGreveParticipar() {
        eventoService.processarEscolha(jogador, greve.getEscolhas().get(2));
        assertEquals(85, jogador.getEnergia());
        assertEquals(100, jogador.getMotivacao());
        assertEquals(45.0, jogador.getDinheiro(), 0.001);
        assertEquals(60, jogador.getNivelConhecimento());
        assertEquals(85, jogador.getSaude());
    }

    @Test
    public void escolhaMaterialCaroComprar() {
        eventoService.processarEscolha(jogador, materialCaro.getEscolhas().get(0));
        assertEquals(100, jogador.getEnergia());
        assertEquals(90, jogador.getMotivacao());
        assertEquals(30.0, jogador.getDinheiro(), 0.001);
    }

    @Test
    public void escolhaMaterialCaroEmprestado() {
        eventoService.processarEscolha(jogador, materialCaro.getEscolhas().get(1));
        assertEquals(90, jogador.getEnergia());
        assertEquals(95, jogador.getMotivacao());
        assertEquals(40, jogador.getNivelConhecimento());
    }

    @Test
    public void escolhaMilagreAcademicoAceitar() {
        eventoService.processarEscolha(jogador, milagreAcademico.getEscolhas().get(0));
        assertEquals(100, jogador.getEnergia());
        assertEquals(100, jogador.getMotivacao());
    }

    @Test
    public void escolhaMilagreAcademicoQuestionar() {
        eventoService.processarEscolha(jogador, milagreAcademico.getEscolhas().get(1));
        assertEquals(90, jogador.getEnergia());
        assertEquals(85, jogador.getMotivacao());
        assertEquals(60, jogador.getNivelConhecimento());
        assertEquals(95, jogador.getSaude());
    }
}