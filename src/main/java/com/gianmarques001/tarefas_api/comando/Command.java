package com.gianmarques001.tarefas_api.comando;

public interface Command<T> {

    T executar();
}
