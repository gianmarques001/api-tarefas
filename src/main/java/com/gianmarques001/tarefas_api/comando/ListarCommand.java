package com.gianmarques001.tarefas_api.comando;

import com.gianmarques001.tarefas_api.entity.Tarefa;
import com.gianmarques001.tarefas_api.service.TarefaService;

import java.util.List;

public class ListarCommand implements Command<List<Tarefa>> {


    private TarefaService tarefaService;

    public ListarCommand(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @Override
    public List<Tarefa> executar() {
        return tarefaService.listar();
    }
}
