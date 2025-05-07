package com.gianmarques001.tarefas_api.comando;

import com.gianmarques001.tarefas_api.Tarefa;
import com.gianmarques001.tarefas_api.service.TarefaService;

public class SalvarCommand implements Command<Tarefa> {

    private Tarefa tarefa;

    private TarefaService tarefaService;

    public SalvarCommand(Tarefa tarefa, TarefaService tarefaService) {
        this.tarefa = tarefa;
        this.tarefaService = tarefaService;
    }

    @Override
    public Tarefa executar() {
        return tarefaService.salvar(tarefa);
    }
}
