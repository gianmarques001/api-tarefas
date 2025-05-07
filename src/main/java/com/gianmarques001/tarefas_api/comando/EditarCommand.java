package com.gianmarques001.tarefas_api.comando;

import com.gianmarques001.tarefas_api.SubTarefa;
import com.gianmarques001.tarefas_api.Tarefa;
import com.gianmarques001.tarefas_api.service.TarefaService;

public class EditarCommand implements Command<Tarefa> {

    private String idTarefa;
    private String idSubTarefa;
    private TarefaService tarefaService;
    private SubTarefa subTarefa;

    public EditarCommand(String idTarefa, SubTarefa subTarefa, TarefaService tarefaService) {
        this.idTarefa = idTarefa;
        this.tarefaService = tarefaService;
        this.subTarefa = subTarefa;
    }

    public EditarCommand(String idTarefa, String idSubTarefa, SubTarefa subTarefa, TarefaService tarefaService) {
        this.idTarefa = idTarefa;
        this.idSubTarefa = idSubTarefa;
        this.tarefaService = tarefaService;
        this.subTarefa = subTarefa;
    }


    @Override
    public Tarefa executar() {
        if (idSubTarefa != null && !idSubTarefa.isEmpty()) {
            return tarefaService.editarSubTarefa(idTarefa, idSubTarefa, subTarefa);
        }
        return tarefaService.editarTarefa(idTarefa, subTarefa);
    }
}
