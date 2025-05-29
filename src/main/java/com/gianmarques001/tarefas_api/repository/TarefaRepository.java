package com.gianmarques001.tarefas_api.repository;

import com.gianmarques001.tarefas_api.entity.Tarefa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TarefaRepository extends MongoRepository<Tarefa, String> {
    Tarefa findByTitulo(String titulo);
}
