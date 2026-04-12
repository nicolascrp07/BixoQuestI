package java.model.service;

import main.java.model.entity.academic.Avaliacao;
import main.java.model.entity.academic.Disciplina;
import main.java.model.entity.character.Jogador;
import main.java.model.service.AcademicoService;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AcademicoServiceTeste {

    private AcademicoService academicoService;
    private Jogador jogador;
    private Disciplina disciplina;
    private Avaliacao avaliacao;

    @Before
    public void setUp() {
        academicoService = new AcademicoService();
        jogador = new Jogador("Nicolas", 100, 50, 100, 100, 50.0, 0.0, null);
        avaliacao = new Avaliacao("Avaliação Teste", 0, 0.0);
        disciplina = new Disciplina("Teste", AcademicoService.ALGORITMOS, null, null, 0.0, 60, false, avaliacao);
    }

    @Test
    public void dificuldadeAlta() {
        jogador.setNivelConhecimento(30);
        academicoService.calcularDificuldade(jogador, avaliacao);
        assertEquals(3, avaliacao.getDificuldade());
    }

    @Test
    public void dificuldadeMedia() {
        jogador.setNivelConhecimento(60);
        academicoService.calcularDificuldade(jogador, avaliacao);
        assertEquals(2, avaliacao.getDificuldade());
    }

    @Test
    public void dificuldadeBaixa() {
        jogador.setNivelConhecimento(90);
        academicoService.calcularDificuldade(jogador, avaliacao);
        assertEquals(1, avaliacao.getDificuldade());
    }

    @Test
    public void impactoDificuldadeAlta() {
        jogador.setNivelConhecimento(20);
        academicoService.aplicarProva(jogador, disciplina, avaliacao, 0.0);
        assertEquals(85, jogador.getEnergia());
        assertEquals(90, jogador.getMotivacao());
        assertEquals(85, jogador.getSaude());
    }

    @Test
    public void impactoDificuldadeMedia() {
        jogador.setNivelConhecimento(50);
        academicoService.aplicarProva(jogador, disciplina, avaliacao, 0.0);
        assertEquals(90, jogador.getEnergia());
        assertEquals(95, jogador.getMotivacao());
        assertEquals(95, jogador.getSaude());
    }

    @Test
    public void impactoDificuldadeBaixa() {
        jogador.setNivelConhecimento(80);
        academicoService.aplicarProva(jogador, disciplina, avaliacao, 0.0);
        assertEquals(95, jogador.getEnergia());
        assertEquals(100, jogador.getMotivacao());
        assertEquals(100, jogador.getSaude());
        assertEquals(10, jogador.getNivelConhecimento() - 80);
    }

    @Test
    public void aprovacaoComNotaSuficiente() {
        academicoService.aplicarProva(jogador, disciplina, avaliacao, 8.0);
        disciplina.verificarAprovacao();
        assertTrue(disciplina.getStatusAprovacao());
    }

    @Test
    public void aprovacaoComNotaInsuficiente() {
        academicoService.aplicarProva(jogador, disciplina, avaliacao, 5.0);
        disciplina.verificarAprovacao();
        assertFalse(disciplina.getStatusAprovacao());
    }

    @Test
    public void todasAprovadas() {
        Disciplina disciplina1 = new Disciplina("Teste1", AcademicoService.EXATAS, null, null, 0.0, 60, false, avaliacao);
        Disciplina disciplina2 = new Disciplina("Teste2", AcademicoService.HARDWARE, null, null, 0.0, 60, false, avaliacao);

        disciplina.setNotaFinal(10.0);
        disciplina.verificarAprovacao();
        disciplina1.setNotaFinal(10.0);
        disciplina1.verificarAprovacao();
        disciplina2.setNotaFinal(10.0);
        disciplina2.verificarAprovacao();

        jogador.addDisciplina(disciplina);
        jogador.addDisciplina(disciplina1);
        jogador.addDisciplina(disciplina2);

        academicoService.fecharSemestre(jogador);

        assertEquals(0, jogador.getDisciplinas().size());
        assertEquals(3, jogador.getHistoricoAprovadas().size());
        assertEquals(disciplina, jogador.getHistoricoAprovadas().get(0));
        assertEquals(disciplina1, jogador.getHistoricoAprovadas().get(1));
        assertEquals(disciplina2, jogador.getHistoricoAprovadas().get(2));
    }

    @Test
    public void todasReprovadas() {
        Disciplina disciplina1 = new Disciplina("Teste1", AcademicoService.EXATAS, null, null, 0.0, 60, false, avaliacao);
        Disciplina disciplina2 = new Disciplina("Teste2", AcademicoService.HARDWARE, null, null, 0.0, 60, false, avaliacao);

        disciplina.verificarAprovacao();
        disciplina1.verificarAprovacao();
        disciplina2.verificarAprovacao();

        jogador.addDisciplina(disciplina);
        jogador.addDisciplina(disciplina1);
        jogador.addDisciplina(disciplina2);

        academicoService.fecharSemestre(jogador);

        assertEquals(3, jogador.getDisciplinas().size());
        assertEquals(0, jogador.getHistoricoAprovadas().size());
        assertEquals(disciplina, jogador.getDisciplinas().get(0));
        assertEquals(disciplina1, jogador.getDisciplinas().get(1));
        assertEquals(disciplina2, jogador.getDisciplinas().get(2));
    }

    @Test
    public void umaAprovada() {
        Disciplina disciplina1 = new Disciplina("Teste1", AcademicoService.EXATAS, null, null, 0.0, 60, false, avaliacao);
        Disciplina disciplina2 = new Disciplina("Teste2", AcademicoService.HARDWARE, null, null, 0.0, 60, false, avaliacao);

        disciplina.setNotaFinal(10.0);
        disciplina.verificarAprovacao();
        disciplina1.verificarAprovacao();
        disciplina2.verificarAprovacao();

        jogador.addDisciplina(disciplina);
        jogador.addDisciplina(disciplina1);
        jogador.addDisciplina(disciplina2);

        academicoService.fecharSemestre(jogador);

        assertEquals(2, jogador.getDisciplinas().size());
        assertEquals(1, jogador.getHistoricoAprovadas().size());
        assertEquals(disciplina, jogador.getHistoricoAprovadas().getFirst());
        assertEquals(disciplina1, jogador.getDisciplinas().get(0));
        assertEquals(disciplina2, jogador.getDisciplinas().get(1));
    }

    @Test
    public void scoreComTresAprovadas() {
        Disciplina disciplina1 = new Disciplina("Teste1", AcademicoService.EXATAS, null, null, 0.0, 60, false, avaliacao);
        Disciplina disciplina2 = new Disciplina("Teste2", AcademicoService.HARDWARE, null, null, 0.0, 60, false, avaliacao);

        disciplina.setNotaFinal(10.0);
        disciplina.verificarAprovacao();
        disciplina1.setNotaFinal(10.0);
        disciplina1.verificarAprovacao();
        disciplina2.setNotaFinal(10.0);
        disciplina2.verificarAprovacao();

        jogador.addDisciplina(disciplina);
        jogador.addDisciplina(disciplina1);
        jogador.addDisciplina(disciplina2);

        academicoService.fecharSemestre(jogador);

        academicoService.atualizarScore(jogador);
        assertEquals(10.0, jogador.getDesempenhoAcademico(), 0.0001);
    }

    @Test
    public void scoreComNenhumaAprovada() {
        Disciplina disciplina1 = new Disciplina("Teste1", AcademicoService.EXATAS, null, null, 0.0, 60, false, avaliacao);
        Disciplina disciplina2 = new Disciplina("Teste2", AcademicoService.HARDWARE, null, null, 0.0, 60, false, avaliacao);

        disciplina.verificarAprovacao();
        disciplina1.verificarAprovacao();
        disciplina2.verificarAprovacao();

        jogador.addDisciplina(disciplina);
        jogador.addDisciplina(disciplina1);
        jogador.addDisciplina(disciplina2);

        academicoService.fecharSemestre(jogador);

        academicoService.atualizarScore(jogador);
        assertEquals(0.0, jogador.getDesempenhoAcademico(), 0.0001);
    }

    @Test
    public void scoreComSeisAprovadas() {
        Disciplina disciplina1 = new Disciplina("Teste1", AcademicoService.EXATAS, null, null, 8.0, 60, false, avaliacao);
        Disciplina disciplina2 = new Disciplina("Teste2", AcademicoService.HARDWARE, null, null, 9.0, 60, false, avaliacao);
        Disciplina disciplina3 = new Disciplina("Teste3", AcademicoService.ALGORITMOS, null, null, 10.0, 60, false, avaliacao);
        Disciplina disciplina4 = new Disciplina("Teste4", AcademicoService.EXATAS, null, null, 8.0, 60, false, avaliacao);
        Disciplina disciplina5 = new Disciplina("Teste5", AcademicoService.HARDWARE, null, null, 9.0, 60, false, avaliacao);

        disciplina.setNotaFinal(10.0);

        disciplina.verificarAprovacao();
        disciplina1.verificarAprovacao();
        disciplina2.verificarAprovacao();
        disciplina3.verificarAprovacao();
        disciplina4.verificarAprovacao();
        disciplina5.verificarAprovacao();

        jogador.addDisciplina(disciplina);
        jogador.addDisciplina(disciplina1);
        jogador.addDisciplina(disciplina2);
        academicoService.fecharSemestre(jogador);
        academicoService.atualizarScore(jogador);

        jogador.addDisciplina(disciplina3);
        jogador.addDisciplina(disciplina4);
        jogador.addDisciplina(disciplina5);
        academicoService.fecharSemestre(jogador);
        academicoService.atualizarScore(jogador);

        assertEquals(9.0, jogador.getDesempenhoAcademico(), 0.0001);
    }

    @Test
    public void matriculaComTodasAprovadas() {
        Disciplina alg1 = new Disciplina("Alg1", AcademicoService.ALGORITMOS, null, null, 10.0, 60, false, avaliacao);
        Disciplina alg2 = new Disciplina("Alg2", AcademicoService.ALGORITMOS, null, alg1, 0.0, 60, false, avaliacao);
        Disciplina ext1 = new Disciplina("Ext1", AcademicoService.EXATAS, null, null, 10.0, 60, false, avaliacao);
        Disciplina ext2 = new Disciplina("Ext2", AcademicoService.EXATAS, null, ext1, 0.0, 60, false, avaliacao);
        Disciplina hw1  = new Disciplina("Hw1", AcademicoService.HARDWARE, null, null, 10.0, 60, false, avaliacao);
        Disciplina hw2  = new Disciplina("Hw2", AcademicoService.HARDWARE, null, hw1, 0.0, 60, false, avaliacao);

        ArrayList<Disciplina> catalogo = new ArrayList<>();
        catalogo.add(alg1); catalogo.add(alg2);
        catalogo.add(ext1); catalogo.add(ext2);
        catalogo.add(hw1);  catalogo.add(hw2);

        alg1.verificarAprovacao();
        ext1.verificarAprovacao();
        hw1.verificarAprovacao();

        jogador.addDisciplina(alg1);
        jogador.addDisciplina(ext1);
        jogador.addDisciplina(hw1);

        academicoService.fecharSemestre(jogador);
        academicoService.matricularNovoSemestre(jogador, catalogo);

        assertEquals(3, jogador.getDisciplinas().size());
        assertTrue(jogador.getDisciplinas().contains(alg2));
        assertTrue(jogador.getDisciplinas().contains(ext2));
        assertTrue(jogador.getDisciplinas().contains(hw2));
        assertEquals(3, jogador.getHistoricoAprovadas().size());
    }

    @Test
    public void matriculaAlgoritmosAprovado() {
        Disciplina alg1 = new Disciplina("Alg1", AcademicoService.ALGORITMOS, null, null, 10.0, 60, false, avaliacao);
        Disciplina alg2 = new Disciplina("Alg2", AcademicoService.ALGORITMOS, null, alg1, 0.0, 60, false, avaliacao);
        Disciplina ext1 = new Disciplina("Ext1", AcademicoService.EXATAS, null, null, 00.0, 60, false, avaliacao);
        Disciplina ext2 = new Disciplina("Ext2", AcademicoService.EXATAS, null, ext1, 0.0, 60, false, avaliacao);
        Disciplina hw1  = new Disciplina("Hw1", AcademicoService.HARDWARE, null, null, 00.0, 60, false, avaliacao);
        Disciplina hw2  = new Disciplina("Hw2", AcademicoService.HARDWARE, null, hw1, 0.0, 60, false, avaliacao);

        ArrayList<Disciplina> catalogo = new ArrayList<>();
        catalogo.add(alg1); catalogo.add(alg2);
        catalogo.add(ext1); catalogo.add(ext2);
        catalogo.add(hw1);  catalogo.add(hw2);

        alg1.verificarAprovacao();
        ext1.verificarAprovacao();
        hw1.verificarAprovacao();

        jogador.addDisciplina(alg1);
        jogador.addDisciplina(ext1);
        jogador.addDisciplina(hw1);

        academicoService.fecharSemestre(jogador);
        academicoService.matricularNovoSemestre(jogador, catalogo);

        assertEquals(3, jogador.getDisciplinas().size());
        assertTrue(jogador.getDisciplinas().contains(alg2));
        assertTrue(jogador.getDisciplinas().contains(ext1));
        assertTrue(jogador.getDisciplinas().contains(hw1));
        assertEquals(1, jogador.getHistoricoAprovadas().size());
    }

    @Test
    public void matriculaExatasAprovado() {
        Disciplina alg1 = new Disciplina("Alg1", AcademicoService.ALGORITMOS, null, null, 00.0, 60, false, avaliacao);
        Disciplina alg2 = new Disciplina("Alg2", AcademicoService.ALGORITMOS, null, alg1, 0.0, 60, false, avaliacao);
        Disciplina ext1 = new Disciplina("Ext1", AcademicoService.EXATAS, null, null, 10.0, 60, false, avaliacao);
        Disciplina ext2 = new Disciplina("Ext2", AcademicoService.EXATAS, null, ext1, 0.0, 60, false, avaliacao);
        Disciplina hw1  = new Disciplina("Hw1", AcademicoService.HARDWARE, null, null, 00.0, 60, false, avaliacao);
        Disciplina hw2  = new Disciplina("Hw2", AcademicoService.HARDWARE, null, hw1, 0.0, 60, false, avaliacao);

        ArrayList<Disciplina> catalogo = new ArrayList<>();
        catalogo.add(alg1); catalogo.add(alg2);
        catalogo.add(ext1); catalogo.add(ext2);
        catalogo.add(hw1);  catalogo.add(hw2);

        alg1.verificarAprovacao();
        ext1.verificarAprovacao();
        hw1.verificarAprovacao();

        jogador.addDisciplina(alg1);
        jogador.addDisciplina(ext1);
        jogador.addDisciplina(hw1);

        academicoService.fecharSemestre(jogador);
        academicoService.matricularNovoSemestre(jogador, catalogo);

        assertEquals(3, jogador.getDisciplinas().size());
        assertTrue(jogador.getDisciplinas().contains(alg1));
        assertTrue(jogador.getDisciplinas().contains(ext2));
        assertTrue(jogador.getDisciplinas().contains(hw1));
        assertEquals(1, jogador.getHistoricoAprovadas().size());
    }

    @Test
    public void matriculaHardwareAprovado() {
        Disciplina alg1 = new Disciplina("Alg1", AcademicoService.ALGORITMOS, null, null, 00.0, 60, false, avaliacao);
        Disciplina alg2 = new Disciplina("Alg2", AcademicoService.ALGORITMOS, null, alg1, 0.0, 60, false, avaliacao);
        Disciplina ext1 = new Disciplina("Ext1", AcademicoService.EXATAS, null, null, 00.0, 60, false, avaliacao);
        Disciplina ext2 = new Disciplina("Ext2", AcademicoService.EXATAS, null, ext1, 0.0, 60, false, avaliacao);
        Disciplina hw1  = new Disciplina("Hw1", AcademicoService.HARDWARE, null, null, 10.0, 60, false, avaliacao);
        Disciplina hw2  = new Disciplina("Hw2", AcademicoService.HARDWARE, null, hw1, 0.0, 60, false, avaliacao);

        ArrayList<Disciplina> catalogo = new ArrayList<>();
        catalogo.add(alg1); catalogo.add(alg2);
        catalogo.add(ext1); catalogo.add(ext2);
        catalogo.add(hw1);  catalogo.add(hw2);

        alg1.verificarAprovacao();
        ext1.verificarAprovacao();
        hw1.verificarAprovacao();

        jogador.addDisciplina(alg1);
        jogador.addDisciplina(ext1);
        jogador.addDisciplina(hw1);

        academicoService.fecharSemestre(jogador);
        academicoService.matricularNovoSemestre(jogador, catalogo);

        assertEquals(3, jogador.getDisciplinas().size());
        assertTrue(jogador.getDisciplinas().contains(alg1));
        assertTrue(jogador.getDisciplinas().contains(ext1));
        assertTrue(jogador.getDisciplinas().contains(hw2));
        assertEquals(1, jogador.getHistoricoAprovadas().size());
    }
}