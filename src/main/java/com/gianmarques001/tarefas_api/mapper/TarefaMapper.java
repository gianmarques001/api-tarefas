package com.gianmarques001.tarefas_api.mapper;

import com.gianmarques001.tarefas_api.entity.SubTarefa;
import com.gianmarques001.tarefas_api.entity.Tarefa;
import com.gianmarques001.tarefas_api.dtos.SubTarefaUpdateRequestDTO;
import com.gianmarques001.tarefas_api.dtos.TarefaRequestDTO;

import java.util.ArrayList;
import java.util.List;

public class TarefaMapper {

    public static Tarefa toEntity(TarefaRequestDTO tarefaRequestDTO) {

        Tarefa tarefa = new Tarefa(tarefaRequestDTO.titulo());
        List<SubTarefa> subTarefaList = new ArrayList<>();
        tarefaRequestDTO.subTarefas().forEach(subTarefa -> {
            subTarefaList.add(new SubTarefa(subTarefa.descricao()));
        });
        tarefa.setSubTarefas(subTarefaList);

        return tarefa;
    }

    public static SubTarefa toEntitySubTarefa(SubTarefaUpdateRequestDTO subTarefaUpdateDTO) {
        SubTarefa subTarefa = new SubTarefa();
        subTarefa.setDescricao(subTarefaUpdateDTO.descricao());
        subTarefa.setConcluido(subTarefaUpdateDTO.concluido());
        return subTarefa;
    }
}
