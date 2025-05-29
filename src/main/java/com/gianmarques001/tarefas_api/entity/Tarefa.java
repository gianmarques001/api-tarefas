package com.gianmarques001.tarefas_api.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Setter
public class Tarefa {

    @Id
    private String id;

    private String titulo;

    private List<SubTarefa> subTarefas;

    public Tarefa() {
    }

    public Tarefa(String titulo) {
        this.titulo = titulo;
    }

    public Tarefa(String titulo, List<SubTarefa> subTarefas) {
        this.titulo = titulo;
        this.subTarefas = subTarefas;
    }


    @Override
    public String toString() {
        return "Tarefa - " +
                "Titulo='" + titulo + '\'' +
                ", subTarefas=" + subTarefas +
                '}';
    }
}
