package test.java.model.service;

import main.java.model.entity.character.Jogador;
import main.java.model.entity.event.QuestAtributo;
import main.java.model.entity.event.QuestVisita;
import main.java.model.entity.event.Recompensa;
import main.java.model.entity.world.Colegiado;
import main.java.model.entity.world.Universidade;
import main.java.model.service.QuestService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestServiceTeste {
    QuestService questService;
    QuestAtributo questAtributo;
    QuestVisita questVisita;
    Jogador jogador;
    Recompensa recompensa;

    @Before
    public void setUp(){
        questService = new QuestService();
        recompensa = new Recompensa(15.0, 10, 5);
        questAtributo = new QuestAtributo("Alcançar 60 em Nível de Conhecimento", null, "De cara nos livros! Alcance 60 em conhecimento!", recompensa, QuestAtributo.CONHECIMENTO, 60);
        questVisita = new QuestVisita("Visite a cantina", null, "Que larica! Vá até a cantina e confira o cardápio.", recompensa, new Colegiado("Colegiado Teste", "Instância do Colegiado"));
        jogador = new Jogador("Nicolas", 100, 50, 50, 100, 50.0, 0.0, new Universidade("UEFS", "Universidade"));
    }

    @Test
    public void adicionarNovasQuests() {
        questService.aceitarQuest(jogador, questVisita);
        questService.aceitarQuest(jogador, questAtributo);
        assertTrue(jogador.getQuestsAtivas().contains(questVisita));
        assertTrue(jogador.getQuestsAtivas().contains(questAtributo));
    }

    @Test
    public void naoDuplicarQuests(){
        questService.aceitarQuest(jogador, questVisita);
        questService.aceitarQuest(jogador, questVisita);
        assertEquals(1, jogador.getQuestsAtivas().size());
    }

    @Test
    public void questAtributoNaoConcluida() {
        questService.aceitarQuest(jogador, questAtributo);
        questService.verificarAndamento(jogador);
        assertFalse(questAtributo.isStatusConcluida());
    }

    @Test
    public void questAtributoConcluida() {
        jogador.setNivelConhecimento(65);
        questService.aceitarQuest(jogador, questAtributo);
        questService.verificarAndamento(jogador);
        assertTrue(questAtributo.isStatusConcluida());
    }

    @Test
    public void questVisitaNaoConcluida() {
        questService.aceitarQuest(jogador, questVisita);
        questService.verificarAndamento(jogador);
        assertFalse(questVisita.isStatusConcluida());
    }

    @Test
    public void questVisitaConcluida() {
        jogador.setLocalAtual(questVisita.getLocalDestino());
        questService.aceitarQuest(jogador, questVisita);
        questService.verificarAndamento(jogador);
        assertTrue(questVisita.isStatusConcluida());
    }

    @Test
    public void aplicarQuestConcluida() {
        jogador.setNivelConhecimento(65);
        questService.aceitarQuest(jogador, questAtributo);
        questService.verificarAndamento(jogador);
        questService.entregarQuest(jogador, questAtributo);
        assertEquals(70, jogador.getNivelConhecimento());
        assertEquals(60, jogador.getMotivacao());
        assertEquals(65.0, jogador.getDinheiro(), 0.0001);
        assertEquals(0, jogador.getQuestsAtivas().size());
    }

    @Test
    public void aplicarQuestNaoConcluida() {
        questService.aceitarQuest(jogador, questAtributo);
        questService.verificarAndamento(jogador);
        questService.entregarQuest(jogador, questAtributo);
        assertEquals(50, jogador.getNivelConhecimento());
        assertEquals(50, jogador.getMotivacao());
        assertEquals(50.0, jogador.getDinheiro(), 0.0001);
        assertEquals(1, jogador.getQuestsAtivas().size());
    }
}