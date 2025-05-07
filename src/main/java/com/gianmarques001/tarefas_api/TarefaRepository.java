package com.gianmarques001.tarefas_api;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TarefaRepository extends MongoRepository<Tarefa, String> {
    Tarefa findByTitulo(String titulo);
}
