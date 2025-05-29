package com.gianmarques001.tarefas_api.comando;

import com.gianmarques001.tarefas_api.entity.Tarefa;
import com.gianmarques001.tarefas_api.service.TarefaService;

public class DeletarCommand implements Command<Tarefa> {

    private String idTarefa;
    private String idSubTarefa;
    private TarefaService tarefaService;

    public DeletarCommand(String idTarefa, TarefaService tarefaService) {
        this.idTarefa = idTarefa;
        this.tarefaService = tarefaService;
    }

    public DeletarCommand(String idTarefa, String idSubTarefa, TarefaService tarefaService) {
        this.idTarefa = idTarefa;
        this.idSubTarefa = idSubTarefa;
        this.tarefaService = tarefaService;
    }


    @Override
    public Tarefa executar() {
        if (idSubTarefa != null && !idSubTarefa.isEmpty()) {
            return tarefaService.excluirSubTarefa(idTarefa, idSubTarefa);
        }
        return tarefaService.excluirTarefa(idTarefa);
    }
}
