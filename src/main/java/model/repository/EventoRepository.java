package main.java.model.repository;

import main.java.model.entity.event.*;

import java.util.ArrayList;

public class EventoRepository {
    private ArrayList<Evento> db = new ArrayList<>();

    public Evento salvar(Evento evento) {
        if (!db.contains(evento)) {
            db.add(evento);
            return evento;
        }
        return null;
    }

    public ArrayList<Evento> buscarTodos() {
        return new ArrayList<>(db);
    }

    public void criarEventosPadrao() {
        this.salvar(new ProvaSurpresa());
        this.salvar(new FilaGigante());
        this.salvar(new Greve());
        this.salvar(new MaterialCaro());
        this.salvar(new MilagreAcademico());
    }
}
