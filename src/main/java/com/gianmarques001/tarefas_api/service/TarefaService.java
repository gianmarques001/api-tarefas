package com.gianmarques001.tarefas_api.service;

import com.gianmarques001.tarefas_api.SubTarefa;
import com.gianmarques001.tarefas_api.Tarefa;
import com.gianmarques001.tarefas_api.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listar() {
        return tarefaRepository.findAll();
    }

    public Tarefa buscarPorId(String idTarefa) {
        return tarefaRepository.findById(idTarefa).orElseThrow(() -> new RuntimeException("Tarefa Não Encontrada"));
    }

    public Tarefa excluirTarefa(String idTarefa) {
        Tarefa tarefa = tarefaRepository.findById(idTarefa).orElseThrow(() -> new RuntimeException("Erro"));
        tarefaRepository.delete(tarefa);
        return tarefa;
    }

    public Tarefa excluirSubTarefa(String idTarefa, String idSubTarefa) {
        Tarefa tarefa = buscarPorId(idTarefa);

        tarefa.getSubTarefas().removeIf(subTarefa -> subTarefa.getId().equals(idSubTarefa));
        return tarefaRepository.save(tarefa);
    }

    public Tarefa editarSubTarefa(String idTarefa, String idSubTarefa, SubTarefa subTarefa) {
        Tarefa tarefa = tarefaRepository.findById(idTarefa).orElseThrow(() -> new RuntimeException("Erro"));

        tarefa.getSubTarefas().stream().filter(s -> s.getId().equals(idSubTarefa)).findAny().ifPresent(s -> {
            s.setConcluido(subTarefa.isConcluido());
            s.setDescricao(subTarefa.getDescricao());
        });

        return tarefaRepository.save(tarefa);
    }

    public Tarefa editarTarefa(String idTarefa, SubTarefa subTarefa) {
        Tarefa tarefa = buscarPorId(idTarefa);
        tarefa.getSubTarefas().add(subTarefa);
        return tarefaRepository.save(tarefa);
    }
}
