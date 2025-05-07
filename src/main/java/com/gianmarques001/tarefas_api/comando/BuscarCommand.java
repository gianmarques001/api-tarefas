package com.gianmarques001.tarefas_api.comando;

import com.gianmarques001.tarefas_api.Tarefa;
import com.gianmarques001.tarefas_api.service.TarefaService;

public class BuscarCommand implements Command<Tarefa> {

    private TarefaService tarefaService;
    private String id;

    public BuscarCommand(String id, TarefaService tarefaService) {
        this.tarefaService = tarefaService;
        this.id = id;
    }


    @Override
    public Tarefa executar() {
        return tarefaService.buscarPorId(id);
    }
}
